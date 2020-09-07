/*
 * Copyright (C) 2018 Bonitasoft S.A.
 * Bonitasoft is a trademark of Bonitasoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * or Bonitasoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 */
package com.bonitasoft.web.client.internal.services;

import com.bonitasoft.web.client.exception.UnauthorizedException;
import com.bonitasoft.web.client.internal.BonitaCookieInterceptor;
import com.bonitasoft.web.client.internal.api.PageAPI;
import com.bonitasoft.web.client.internal.converters.RestApiConverter;
import com.bonitasoft.web.client.model.Page;
import com.bonitasoft.web.utils.FileUtils;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Response;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class PageService extends ClientService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PageService.class);
    private final RestApiConverter restApiConverter;
    private final BonitaCookieInterceptor bonitaCookieInterceptor;
    private final PageAPI pageAPI;

    public PageService(RestApiConverter restApiConverter, BonitaCookieInterceptor bonitaCookieInterceptor,
                       PageAPI pageAPI) {
        this.restApiConverter = restApiConverter;
        this.bonitaCookieInterceptor = bonitaCookieInterceptor;
        this.pageAPI = pageAPI;
    }

    public String importPage(File content) throws IOException, UnauthorizedException {
        LOGGER.info("Deploying page '{}'...", content.getName());
        bonitaCookieInterceptor.checkLogged();
        RequestBody requestFile = RequestBody.create(MultipartBody.FORM, content);
        MultipartBody.Part body = MultipartBody.Part.createFormData("page.zip", "page.zip",
                requestFile);

        LOGGER.debug("Uploading page file...");
        Response<String> responseUpload = pageAPI.uploadContent(body, "add").execute();
        checkResponse(responseUpload);
        LOGGER.debug("Page file uploaded successfully.");

        String uploadedPageZipName = restApiConverter.buildSimpleJson("pageZip", responseUpload.body());
        Response<ResponseBody> responseImport;
        Page page = getPage(content);
        if (page != null) {
            //page already exists, we update it
            LOGGER.debug("Updating existing page...");
            responseImport = pageAPI.update(page.getId(), uploadedPageZipName).execute();
        } else {
            //page do not exists, we create it
            LOGGER.debug("Creating new page...");
            responseImport = pageAPI.add(uploadedPageZipName).execute();
        }
        checkResponse(responseImport);
        LOGGER.info("Page deployed successfully.");
        return responseImport.body().string();
    }

    private Page getPage(File content) throws IOException, UnauthorizedException {
        String name = getPageToken(content);
        return getPage(name);
    }

    private String getPageToken(File content) throws IOException {
        byte[] pageProperties = FileUtils.getFileFromZip(content, "page.properties");
        Properties properties = new Properties();
        properties.load(new ByteArrayInputStream(pageProperties));
        String name = properties.getProperty("name");
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(String.format("Invalid page %s, page.properties do not contains a name" +
                    " attribute", content.getPath()));
        }
        return name;
    }

    public List<Page> searchPages(int page, int count) throws IOException, UnauthorizedException {
        bonitaCookieInterceptor.checkLogged();
        Response<List<Page>> response = pageAPI.search(page, count).execute();
        checkResponse(response);
        return response.body();
    }

    public Page getPage(String urlToken) throws UnauthorizedException, IOException {
        LOGGER.debug("Retrieving page '{}'", urlToken);
        bonitaCookieInterceptor.checkLogged();
        Response<List<Page>> response = pageAPI.search(0, 1, "urlToken=" + urlToken).execute();
        checkResponse(response);
        List<Page> body = response.body();
        if (body.isEmpty()) {
            LOGGER.debug("Can't find any existing page with the token '{}'.", urlToken);
            return null;
        }
        LOGGER.debug("Page '{}' retrieved successfully.", urlToken);
        return body.get(0);
    }

    public boolean deletePage(String token) throws IOException, UnauthorizedException {
        Page page = getPage(token);
        if (page == null) {
            return false;
        }
        Response<ResponseBody> execute = pageAPI.delete(page.getId()).execute();
        checkResponse(execute);
        return true;
    }
}
