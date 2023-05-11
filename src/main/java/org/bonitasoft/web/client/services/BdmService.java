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

import org.bonitasoft.web.client.api.BusinessDataQueryApi.SearchBusinessDataQueryParams;
import org.bonitasoft.web.client.model.BDMAccessControl;
import org.bonitasoft.web.client.model.Bdm;

public interface BdmService {

    void importBDM(File bdm);

    void importBdmAccessControl(File accessControl);

    Bdm getBdmStatus();

    BDMAccessControl getBdmAccessControlStatus();

    /**
     * Perform the specified named query for the specified business data type and map the response to a single instance of T
     * 
     * @param businessDataType
     * @param namedQuery
     * @param queryResultType
     * @param <T>
     * @return
     */
    <T> T querySingle(String businessDataType, String namedQuery, Class<T> queryResultType);

    /**
     * Perform the specified named query for the specified business data type and map the response to a List of T instances
     * 
     * @param businessDataType
     * @param namedQuery
     * @param queryResultType
     * @param <T>
     * @return
     */
    <T> List<T> query(String businessDataType, String namedQuery, Class<T> queryResultType);

    /**
     * Perform the specified named query for the specified business data type using the search parameters and map the response to a single instance of T
     * 
     * @param businessDataType
     * @param queryParams
     * @param queryResultType
     * @param <T>
     * @return
     */
    <T> T querySingle(String businessDataType, SearchBusinessDataQueryParams queryParams, Class<T> queryResultType);

    /**
     * Perform the specified named query for the specified business data type using the search parameters and map the response to a List of T instances
     * 
     * @param businessDataType
     * @param queryParams
     * @param queryResultType
     * @param <T>
     * @return
     */
    <T> List<T> query(String businessDataType, SearchBusinessDataQueryParams queryParams, Class<T> queryResultType);
}
