/*
 * Copyright (C) 2018 Bonitasoft S.A.
 * Bonitasoft is a trademark of Bonitasoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * or Bonitasoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 */
package com.bonitasoft.web.client.internal.services;

import com.bonitasoft.web.client.internal.api.PageAPI;
import com.bonitasoft.web.client.internal.security.SecurityContext;
import com.bonitasoft.web.client.model.Page;
import com.bonitasoft.web.client.utils.Json;
import lombok.AllArgsConstructor;
import lombok.Getter;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import retrofit2.mock.Calls;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

/**
 * @author Baptiste Mesta.
 */
@ExtendWith(MockitoExtension.class)
class PageServiceTest {

    @TempDir
    File temporaryFolder;

    @Mock(lenient = true)
    private PageAPI pageAPI;
    @Mock
    private SecurityContext securityContext;

    @InjectMocks
    private PageService pageService;

    @BeforeEach
    public void before() throws Exception {
        when(pageAPI.search(anyInt(), anyInt(), anyString())).thenReturn(Calls.response(Collections.emptyList()));
        when(pageAPI.uploadContent(any(), anyString())).thenReturn(Calls.response("uploadedFile"));
        when(pageAPI.add(anyMap())).thenReturn(Calls.response(ResponseBody.create(MediaType.parse("plain/test"), "ok")));
        when(pageAPI.update(anyLong(), anyMap())).thenReturn(Calls.response(ResponseBody.create(MediaType.parse("plain/test"), "ok")));
    }

    @Test
    void should_delete_existing_page_before_importing_it() throws Exception {
        File pageFile = aPageFile("name=myPage");
        havingPageOnServer(6L, "myPage");

        pageService.importPage(pageFile);

        verify(pageAPI).update(6L, Json.asMap("pageZip", "uploadedFile"));
        verify(pageAPI).uploadContent(any(), anyString());
        verify(pageAPI, never()).add(anyMap());
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

        verify(pageAPI, never()).update(anyLong(), anyMap());
        verify(pageAPI).uploadContent(any(), anyString());
        verify(pageAPI).add(Json.asMap("pageZip", "uploadedFile"));
    }

    @Test
    void should_upload_file_and_call_import_page_when_importing_page() throws Exception {
        File pageFile = aPageFile("name=myPage");

        pageService.importPage(pageFile);

        verify(pageAPI).uploadContent(any(), anyString());
        verify(pageAPI).add(Json.asMap("pageZip", "uploadedFile"));
    }

    @Test
    void should_delete_unexisting_page() throws Exception {
        boolean result = pageService.deletePage("theToken");

        assertThat(result).isFalse();
    }

    @Test
    void should_delete_existing_page() throws Exception {
        havingPageOnServer(123L, "theToken");
        when(pageAPI.delete(eq(123L))).thenReturn(Calls.response(ResponseBody.create(MediaType.parse("plain/test"), "success")));

        boolean result = pageService.deletePage("theToken");

        verify(pageAPI).delete(123L);
        assertThat(result).isTrue();
    }

    private void havingPageOnServer(long id, String urlToken) {
        when(pageAPI.search(0, 1, "urlToken=" + urlToken)).thenReturn(Calls.response(singletonList(aPage(id, urlToken))));
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

    private static byte[] zip(FileAndContent... files) throws IOException {
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        final ZipOutputStream zos = new ZipOutputStream(baos);
        try {
            for (FileAndContent file : files) {
                ZipEntry e = new ZipEntry(file.getFileName());
                zos.putNextEntry(e);
                if (!e.isDirectory()) {
                    zos.write(file.getContent());
                }
                zos.flush();
                zos.closeEntry();
            }
        } finally {
            zos.close();
            baos.close();
        }
        return baos.toByteArray();
    }

    private static FileAndContent file(String fileName, String content) {
        return new FileAndContent(fileName, content.getBytes());
    }

    @Getter
    @AllArgsConstructor
    private static class FileAndContent {
        private final String fileName;
        private final byte[] content;
    }

}
