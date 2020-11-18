package org.bonitasoft.web.client.services;

import java.io.File;

import org.bonitasoft.web.client.model.BDMAccessControl;
import org.bonitasoft.web.client.model.Bdm;

public interface BdmService {

	void importBDM(File bdm);

	void importBdmAccessControl(File accessControl);

	Bdm getBdmStatus();

	BDMAccessControl getBdmAccessControlStatus();

}
