/*
 * Copyright (C) 2018 Bonitasoft S.A.
 * Bonitasoft is a trademark of Bonitasoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * or Bonitasoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 */
package org.bonitasoft.web.client.services.impl;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import lombok.Builder;
import lombok.Data;
import org.bonitasoft.web.client.exception.ClientException;
import org.bonitasoft.web.client.services.utils.FileUtils;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;

@Data
@Builder
class BusinessArchive {

  private static final String PROCESS_DESIGN_FILENAME = "process-design.xml";

  private String processName;
  private String processVersion;
  private File archive;

  static BusinessArchive create(File bar) {
    try (FileInputStream fileInputStream = new FileInputStream(bar)) {

      // Get name and version from process design file
      byte[] fileFromZip = FileUtils.getFileFromZip(fileInputStream, PROCESS_DESIGN_FILENAME);
      DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
      documentBuilderFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
      documentBuilderFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
      DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
      Document doc = documentBuilder.parse(new ByteArrayInputStream(fileFromZip));
      doc.getDocumentElement().normalize();
      NamedNodeMap attributes = doc.getFirstChild().getAttributes();

      return BusinessArchive.builder()
          .archive(bar)
          .processName(attributes.getNamedItem("name").getNodeValue())
          .processVersion(attributes.getNamedItem("version").getNodeValue())
          .build();

    } catch (Exception e) {
      throw new ClientException("Unable to parse bar file", e);
    }
  }
}
