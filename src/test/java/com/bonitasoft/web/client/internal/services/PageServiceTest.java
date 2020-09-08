/*
 * Copyright (C) 2018 Bonitasoft S.A.
 * Bonitasoft is a trademark of Bonitasoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * or Bonitasoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 */
package com.bonitasoft.web.client.internal.services;

import com.bonitasoft.web.client.internal.BonitaCookieInterceptor;
import com.bonitasoft.web.client.internal.api.PageAPI;
import com.bonitasoft.web.client.internal.converters.RestApiConverter;
import com.bonitasoft.web.client.model.Page;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import retrofit2.Call;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.List;

import static com.bonitasoft.web.client.internal.services.TestCall.successCall;
import static com.bonitasoft.web.client.tests.FileAndContentUtils.file;
import static com.bonitasoft.web.client.tests.FileAndContentUtils.zip;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

/**
 * @author Baptiste Mesta.
 */
@ExtendWith(MockitoExtension.class)
class PageServiceTest {

    private final RestApiConverter restApiConverter = RestApiConverter.INSTANCE;

    @TempDir
    File temporaryFolder;

    @Mock(lenient = true)
    private PageAPI pageAPI;
    @Mock(lenient = true)
    private BonitaCookieInterceptor bonitaCookieInterceptor;

    private PageService pageService;

    @BeforeEach
    void before() {
        pageService = new PageService(restApiConverter, bonitaCookieInterceptor, pageAPI);
        doReturn(successCall(Collections.emptyList())).when(pageAPI).search(anyInt(), anyInt(), anyString());
        doReturn(successCall("uploadedFile")).when(pageAPI).uploadContent(any(), anyString());
        doReturn(successCall(ResponseBody.create(MediaType.parse("plain/test"), "ok"))).when(pageAPI)
                .add(anyString());
        doReturn(successCall(ResponseBody.create(MediaType.parse("plain/test"), "ok"))).when(pageAPI)
                .update(anyLong(), anyString());
    }

    @Test
    void should_delete_existing_page_before_importing_it() throws Exception {
        File pageFile = aPageFile("name=myPage");
        havingPageOnServer(6L, "myPage");

        pageService.importPage(pageFile);

        verify(pageAPI).update(6L, "{\"pageZip\":\"uploadedFile\"}");
        verify(pageAPI).uploadContent(any(), anyString());
        verify(pageAPI, never()).add(anyString());
    }

    @Test
    void should_throw_exception_if_page_is_not_valid() throws Exception {
        File pageFile = aPageFile("notName=myPage");
        assertThrows(IllegalArgumentException.class, () -> pageService.importPage(pageFile));
    }

    @Test
    void should_not_delete_page_before_import_if_page_do_not_exists() throws Exception {
        File pageFile = aPageFile("name=myPage");

        pageService.importPage(pageFile);

        verify(pageAPI, never()).update(anyLong(), anyString());
        verify(pageAPI).uploadContent(any(), anyString());
        verify(pageAPI).add("{\"pageZip\":\"uploadedFile\"}");
    }

    @Test
    void should_upload_file_and_call_import_page_when_importing_page() throws Exception {
        File pageFile = aPageFile("name=myPage");

        pageService.importPage(pageFile);

        verify(pageAPI).uploadContent(any(), anyString());
        verify(pageAPI).add("{\"pageZip\":\"uploadedFile\"}");
    }

    @Test
    void should_delete_unexisting_page() throws Exception {
        boolean result = pageService.deletePage("theToken");

        assertThat(result).isFalse();
    }

    @Test
    void should_delete_existing_page() throws Exception {
        havingPageOnServer(123L, "theToken");
        doReturn(successCall("success")).when(pageAPI).delete(123L);

        boolean result = pageService.deletePage("theToken");

        verify(pageAPI).delete(123L);
        assertThat(result).isTrue();
    }

    private Call<List<Page>> havingPageOnServer(long id, String urlToken) {
        return doReturn(successCall(Collections.singletonList(aPage(id, urlToken)))).when(pageAPI).search(0, 1,
                "urlToken=" + urlToken);
    }

    private Page aPage(long id, String urlToken) {
        Page page = new Page();
        page.setId(id);
        page.setUrlToken(urlToken);
        return page;
    }

    private File aPageFile(String content) throws IOException {
        String fileName = "page.properties";
        File pageFile = new File(temporaryFolder, fileName);
        Files.write(pageFile.toPath(), zip(file(fileName, content)));
        return pageFile;
    }

}
