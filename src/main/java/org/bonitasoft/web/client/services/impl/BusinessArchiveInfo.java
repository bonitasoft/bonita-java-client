/** 
 * Copyright (C) 2018 BonitaSoft S.A.
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
package org.bonitasoft.web.client.services.impl;

import java.io.File;

import org.bonitasoft.web.client.exception.ClientException;
import org.bonitasoft.web.client.services.impl.xml.XmlDocumentParser;
import org.bonitasoft.web.client.services.utils.FileUtils;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
class BusinessArchiveInfo {

    private static final String PROCESS_DESIGN_FILENAME = "process-design.xml";

    String processName;

    String processVersion;

    File archive;

    static BusinessArchiveInfo readFrom(File bar) {
        try {
            // Get name and version from process design file
            byte[] fileFromZip = FileUtils.getFileFromZip(bar, PROCESS_DESIGN_FILENAME);

            final XmlDocumentParser documentParser = new XmlDocumentParser();
            Document doc = documentParser.parse(fileFromZip);
            NamedNodeMap attributes = doc.getFirstChild().getAttributes();
            return BusinessArchiveInfo.builder()
                    .archive(bar)
                    .processName(attributes.getNamedItem("name").getNodeValue())
                    .processVersion(attributes.getNamedItem("version").getNodeValue())
                    .build();

        } catch (Exception e) {
            throw new ClientException("Unable to parse bar file", e);
        }
    }
}
