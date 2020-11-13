package org.bonitasoft.web.client.services;

import org.bonitasoft.web.client.model.License;

public interface SystemService {

  boolean isTenantPaused();

  License getLicense();

  boolean isCommunity();
}
