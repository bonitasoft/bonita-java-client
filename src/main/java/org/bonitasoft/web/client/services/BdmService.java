package org.bonitasoft.web.client.services;

import org.bonitasoft.web.client.model.BDMAccessControl;
import org.bonitasoft.web.client.model.Bdm;

import java.io.File;

public interface BdmService {
    void importBDM(File content);

    void importBdmAccessControl(File accessControl);

    Bdm getBdmStatus();

    BDMAccessControl getBdmAccessControlStatus();
}
