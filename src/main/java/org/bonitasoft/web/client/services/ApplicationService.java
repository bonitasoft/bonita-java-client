/** 
 * Copyright (C) 2023 BonitaSoft S.A.
 * BonitaSoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2.0 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.bonitasoft.web.client.services;

import java.io.File;
import java.util.List;

import org.bonitasoft.web.client.api.ApplicationApi;
import org.bonitasoft.web.client.api.PageApi;
import org.bonitasoft.web.client.exception.NotFoundException;
import org.bonitasoft.web.client.model.Application;
import org.bonitasoft.web.client.model.Page;
import org.bonitasoft.web.client.services.policies.ApplicationImportPolicy;

public interface ApplicationService {

    void importApplications(File application, ApplicationImportPolicy policy);

    /**
     * Return The application for the given token or throw a {@link NotFoundException}
     * 
     * @param applicationToken
     * @return The corresponding application
     * @throws NotFoundException
     */
    Application getApplication(String applicationToken);

    List<Application> searchApplications(int page, int count);

    List<Application> searchApplications(ApplicationApi.SearchApplicationsQueryParams params);

    void deleteApplication(String applicationToken);

    void importBonitaConfiguration(File configurationFile);

    Page importPage(File pageZip);

    List<Page> searchPages(int page, int count);

    List<Page> searchPages(PageApi.SearchPagesQueryParams params);

    /**
     * Return the page for the given toke or throw a {@link NotFoundException}
     * 
     * @param token
     * @return
     * @throws NotFoundException
     */
    Page getPage(String token);

    void deletePage(String token);
}
