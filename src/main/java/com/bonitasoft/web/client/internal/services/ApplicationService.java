/*
 * Copyright (C) 2018 Bonitasoft S.A.
 * Bonitasoft is a trademark of Bonitasoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * or Bonitasoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 */
package com.bonitasoft.web.client.internal.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import com.bonitasoft.web.client.exception.UnauthorizedException;
import com.bonitasoft.web.client.internal.BonitaCookieInterceptor;
import com.bonitasoft.web.client.internal.api.ApplicationAPI;
import com.bonitasoft.web.client.model.Application;
import com.bonitasoft.web.client.policies.ApplicationImportPolicy;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import retrofit2.Response;

public class ApplicationService extends ClientService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationService.class);

    private final ApplicationAPI applicationAPI;
    private final BonitaCookieInterceptor bonitaCookieInterceptor;

    public ApplicationService(BonitaCookieInterceptor bonitaCookieInterceptor,
            ApplicationAPI applicationAPI) {
        this.bonitaCookieInterceptor = bonitaCookieInterceptor;
        this.applicationAPI = applicationAPI;
    }

    public String importApplications(File content, ApplicationImportPolicy policy)
            throws IOException, UnauthorizedException {
        LOGGER.info("Deploying applications in '{}' using policy {}", content.getName(), policy.name());
        bonitaCookieInterceptor.checkLogged();
        //temporary simulate a REPLACE_DUPLICATES policy here because it is not implemented in engine side
        if (policy.equals(ApplicationImportPolicy.REPLACE_DUPLICATES)) {
            LOGGER.debug("Policy REPLACE_DUPLICATES: deleting existing applications...");
            deleteExistingApplications(content);
            LOGGER.debug("Existing application deleted successfully.");
            //reset
            policy = ApplicationImportPolicy.FAIL_ON_DUPLICATES;
        }
        RequestBody requestFile = RequestBody.create(MultipartBody.FORM, content);
        MultipartBody.Part body = MultipartBody.Part.createFormData("applications.xml", "applications.xml",
                requestFile);
        LOGGER.debug("Uploading application file...");
        Response<String> responseUpload = applicationAPI.uploadContent(body).execute();
        checkResponse(responseUpload);
        LOGGER.debug("Application file uploaded successfully.");
        String uploadedFile = responseUpload.body();

        Response<ResponseBody> responseImport = applicationAPI.importFromUploadedFile(uploadedFile, policy.name())
                .execute();
        checkResponse(responseImport);
        LOGGER.info("Applications in '{}' deployed successfully.", content.getName());
        return responseImport.body().string();
    }

    public List<Application> searchApplications(int page, int count)
            throws IOException, UnauthorizedException {
        bonitaCookieInterceptor.checkLogged();
        Response<List<Application>> response = applicationAPI.search(page, count).execute();
        checkResponse(response);
        return response.body();
    }

    private void deleteExistingApplications(File content) throws IOException, UnauthorizedException {
        List<String> applicationTokens = getApplicationTokens(content);
        for (String applicationToken : applicationTokens) {
            Application application = getApplication(applicationToken);
            if (application != null) {
                LOGGER.debug("Deleting application '{}'...", application.getToken());
                Response<ResponseBody> execute = applicationAPI.delete(application.getId()).execute();
                checkResponse(execute);
                LOGGER.debug("Application '{}' deleted successfully.", application.getToken());
            }
        }
    }

    public Application getApplication(String applicationToken)
            throws UnauthorizedException, IOException {
        LOGGER.debug("Retrieving application '{}'", applicationToken);
        bonitaCookieInterceptor.checkLogged();
        Response<List<Application>> response = applicationAPI.search(0, 1, "token=" + applicationToken).execute();
        checkResponse(response);
        List<Application> body = response.body();
        if (body.isEmpty()) {
            LOGGER.debug("Can't find any existing application with the token '{}'.", applicationToken);
            return null;
        }
        LOGGER.debug("Application '{}' retrieved successfully.", applicationToken);
        return body.get(0);
    }

    private List<String> getApplicationTokens(File content) throws IOException {
        List<String> tokens = new ArrayList<>();
        try {
            DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
            domFactory.setNamespaceAware(false);
            DocumentBuilder builder = domFactory.newDocumentBuilder();
            Document doc = builder.parse(content);
            XPath xPath = XPathFactory.newInstance().newXPath();
            XPathExpression compile = xPath.compile("/applications/application/@token");
            NodeList evaluate1 = (NodeList) compile.evaluate(doc, XPathConstants.NODESET);
            for (int i = 0; i < evaluate1.getLength(); i++) {
                Node item = evaluate1.item(i);
                tokens.add(item.getNodeValue());
            }

        } catch (XPathExpressionException | FileNotFoundException | SAXException | ParserConfigurationException e) {
            throw new IOException(e);
        }
        return tokens;
    }

    public boolean deleteApplication(String applicationToken) throws UnauthorizedException, IOException {
        Application application = getApplication(applicationToken);
        if (application == null) {
            return false;
        }
        Response<ResponseBody> execute = applicationAPI.delete(application.getId()).execute();
        checkResponse(execute);
        return true;
    }
}
