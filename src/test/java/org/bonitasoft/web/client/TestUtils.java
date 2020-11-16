package org.bonitasoft.web.client;

import feign.Request;
import feign.RequestTemplate;
import feign.Response;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;

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

  @NotNull
  public static Response.Builder mockResponseBuilder() {
    return Response.builder()
        .request(
            Request.create(
                Request.HttpMethod.GET,
                "http://dummy.org",
                new HashMap<>(),
                null,
                new RequestTemplate()));
  }
}
