package org.bonitasoft.web.client;

import java.io.File;
import java.net.URL;

public final class TestUtils {

  private TestUtils() {
    // utility class
  }

  public static File getClasspathFile(String path) throws Exception {
    if (!path.startsWith("/")) {
      path = "/" + path;
    }
    final URL resource = TestUtils.class.getResource(path);
    if (resource == null) {
      throw new RuntimeException("Classpaht resource not found: " + path);
    }
    return new File(resource.toURI());
  }
}
