package org.bonitasoft.web.client;

import java.io.File;
import java.net.URISyntaxException;

public final class TestUtils {

    private TestUtils() {
        // utility class
    }

    public static File getClasspathFile(String s) throws Exception {
        return new File(TestUtils.class.getResource(s).toURI());
    }
}
