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
import com.bonitasoft.web.client.internal.api.PageAPI;
import com.bonitasoft.web.client.internal.security.SecurityContext;
import com.bonitasoft.web.client.model.Page;
import com.bonitasoft.web.client.utils.FileUtils;
import com.bonitasoft.web.client.utils.Json;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Response;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@Slf4j
public class PageService extends ClientService {

    private final PageAPI pageAPI;

    public PageService(SecurityContext securityContext, PageAPI pageAPI) {
        super(securityContext);
        this.pageAPI = pageAPI;
    }

    public String importPage(File content) throws IOException, UnauthorizedException {
        log.info("Deploying page '{}'...", content.getName());
        securityContext.isAuthenticated();
        RequestBody requestFile = RequestBody.create(MultipartBody.FORM, content);
        MultipartBody.Part body = MultipartBody.Part.createFormData("page.zip", "page.zip",
                requestFile);

        log.debug("Uploading page file...");
        Response<String> responseUpload = pageAPI.uploadContent(body, "add").execute();
        checkResponse(responseUpload);
        log.debug("Page file uploaded successfully.");

        Map<String, Serializable> uploadedPageZipName = Json.asMap("pageZip", responseUpload.body());
        Response<ResponseBody> responseImport;
        Page page = getPage(content);
        if (page != null) {
            //page already exists, we update it
            log.debug("Updating existing page...");
            responseImport = pageAPI.update(page.getId(), uploadedPageZipName).execute();
        } else {
            //page do not exists, we create it
            log.debug("Creating new page...");
            responseImport = pageAPI.add(uploadedPageZipName).execute();
        }
        checkResponse(responseImport);
        log.info("Page deployed successfully.");
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
        securityContext.isAuthenticated();
        Response<List<Page>> response = pageAPI.search(page, count).execute();
        checkResponse(response);
        return response.body();
    }

    public Page getPage(String urlToken) throws UnauthorizedException, IOException {
        log.debug("Retrieving page '{}'", urlToken);
        securityContext.isAuthenticated();
        Response<List<Page>> response = pageAPI.search(0, 1, "urlToken=" + urlToken).execute();
        checkResponse(response);
        List<Page> body = response.body();
        if (body.isEmpty()) {
            log.debug("Can't find any existing page with the token '{}'.", urlToken);
            return null;
        }
        log.debug("Page '{}' retrieved successfully.", urlToken);
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
