package org.bonitasoft.web.client.services;

import org.bonitasoft.web.client.model.Page;

import java.io.File;
import java.util.List;

public interface PageService {
    String importPage(File content);

    List<Page> searchPages(int page, int count);

    Page getPage(String token);

    boolean deletePage(String token);
}
