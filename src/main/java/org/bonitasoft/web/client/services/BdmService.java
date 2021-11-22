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

	<T> T querySingle(String businessDataType, String namedQuery, Class<T> queryResultType);

	<T> List<T> query(String businessDataType, String namedQuery, Class<T> queryResultType);

	<T> T querySingle(String businessDataType, SearchBusinessDataQueryParams queryParams, Class<T> queryResultType);

	<T> List<T> query(String businessDataType, SearchBusinessDataQueryParams queryParams, Class<T> queryResultType);
}
