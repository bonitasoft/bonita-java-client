/*
 * Copyright (C) 2018 Bonitasoft S.A.
 * Bonitasoft is a trademark of Bonitasoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * or Bonitasoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 */
package org.bonitasoft.web.client.services.impl;

import java.io.File;
import lombok.Builder;
import lombok.Value;
import org.bonitasoft.web.client.exception.ClientException;
import org.bonitasoft.web.client.services.impl.xml.XmlDocumentParser;
import org.bonitasoft.web.client.services.utils.FileUtils;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;

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
