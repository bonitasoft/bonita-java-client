/** 
 * Copyright (C) 2023 BonitaSoft S.A.
 * BonitaSoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2.0 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.bonitasoft.web.client;

import java.io.File;
import java.net.URL;
import java.util.HashMap;

import org.jetbrains.annotations.NotNull;

import feign.Request;
import feign.RequestTemplate;
import feign.Response;

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
