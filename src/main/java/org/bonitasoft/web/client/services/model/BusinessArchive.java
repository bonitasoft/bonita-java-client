/*
 * Copyright (C) 2018 Bonitasoft S.A.
 * Bonitasoft is a trademark of Bonitasoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * or Bonitasoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 */
package org.bonitasoft.web.client.services.model;

import org.bonitasoft.web.client.services.utils.FileUtils;
import lombok.Builder;
import lombok.Data;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;

@Data
@Builder
public class BusinessArchive {

    private String name;
    private String version;

    public static BusinessArchive read(File content) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(content)) {
            return read(fileInputStream);
        }
    }

    public static BusinessArchive read(InputStream content) throws IOException {
        byte[] fileFromZip = FileUtils.getFileFromZip(content, "process-design.xml");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document doc = documentBuilder.parse(new ByteArrayInputStream(fileFromZip));
            doc.getDocumentElement().normalize();
            NamedNodeMap attributes = doc.getFirstChild().getAttributes();
            return BusinessArchive.builder()
                    .name(attributes.getNamedItem("name").getNodeValue())
                    .version(attributes.getNamedItem("version").getNodeValue())
                    .build();
        } catch (ParserConfigurationException | SAXException e) {
            throw new IOException("Unable to parse xml file", e);
        }
    }
}
