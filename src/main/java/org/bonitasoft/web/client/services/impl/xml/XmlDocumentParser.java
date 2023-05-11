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
package org.bonitasoft.web.client.services.impl.xml;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.bonitasoft.web.client.exception.ClientException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlDocumentParser {

    private final DocumentBuilder documentBuilder;

    public XmlDocumentParser() {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
        documentBuilderFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
        documentBuilderFactory.setNamespaceAware(false);
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new ClientException("Failed to create xml parser", e);
        }
    }

    public Document parse(File xmlFile) {
        try {
            final Document document = documentBuilder.parse(xmlFile);
            document.getDocumentElement().normalize();
            return document;
        } catch (SAXException | IOException e) {
            throw new ClientException("Failed to read xml document", e);
        }
    }

    public Document parse(byte[] doc) {
        try {
            final Document document = documentBuilder.parse(new ByteArrayInputStream(doc));
            document.getDocumentElement().normalize();
            return document;
        } catch (SAXException | IOException e) {
            throw new ClientException("Failed to read xml document", e);
        }
    }

    public NodeList queryNodeList(Document document, String query) {
        try {
            XPath xPath = XPathFactory.newInstance().newXPath();
            XPathExpression compile = xPath.compile(query);
            return (NodeList) compile.evaluate(document, XPathConstants.NODESET);
        } catch (XPathExpressionException e) {
            throw new ClientException("Failed to query xml node from file: " + query, e);
        }
    }
}
