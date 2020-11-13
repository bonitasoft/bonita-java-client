package org.bonitasoft.web.client.services.impl;

import java.util.function.Function;
import org.bonitasoft.web.client.model.License;

public interface ClientContext {

  License getLicense();

  License getLicense(Function<String, Object> value);

  void setLicense(License license);

  <T> T get(String key);

  void put(String key, Object o);

  <T> T remove(String key);
}
