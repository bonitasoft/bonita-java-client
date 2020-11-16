package org.bonitasoft.web.client.services.impl.base;

import java.util.function.Function;
import org.bonitasoft.web.client.model.License;

public interface ClientContext {

  License getLicense();

  void setLicense(License license);

  License getLicense(Function<String, Object> value);

  <T> T get(String key);

  void put(String key, Object o);

  <T> T remove(String key);

  void clear();
}
