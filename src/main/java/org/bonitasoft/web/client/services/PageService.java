package org.bonitasoft.web.client.services;

import org.bonitasoft.web.client.api.PageApi;
import org.bonitasoft.web.client.model.Page;

import java.io.File;
import java.util.List;

public interface PageService {
    Page importPage(File pageZip);

    List<Page> searchPages(int page, int count);

    List<Page> searchPages(PageApi.SearchPagesQueryParams params);

    Page getPage(String token);

    boolean deletePage(String token);
}
