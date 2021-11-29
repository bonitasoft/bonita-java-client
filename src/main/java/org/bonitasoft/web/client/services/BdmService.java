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
	 * @param businessDataType
	 * @param namedQuery
	 * @param queryResultType
	 * @param <T>
	 * @return
	 */
	<T> T querySingle(String businessDataType, String namedQuery, Class<T> queryResultType);

	/**
	 * Perform the specified named query for the specified business data type and map the response to a List of T instances
	 * @param businessDataType
	 * @param namedQuery
	 * @param queryResultType
	 * @param <T>
	 * @return
	 */
	<T> List<T> query(String businessDataType, String namedQuery, Class<T> queryResultType);

	/**
	 * Perform the specified named query for the specified business data type using the search parameters and map the response to a single instance of T
	 * @param businessDataType
	 * @param queryParams
	 * @param queryResultType
	 * @param <T>
	 * @return
	 */
	<T> T querySingle(String businessDataType, SearchBusinessDataQueryParams queryParams, Class<T> queryResultType);

	/**
	 * Perform the specified named query for the specified business data type using the search parameters and map the response to a List of T instances
	 * @param businessDataType
	 * @param queryParams
	 * @param queryResultType
	 * @param <T>
	 * @return
	 */
	<T> List<T> query(String businessDataType, SearchBusinessDataQueryParams queryParams, Class<T> queryResultType);
}
