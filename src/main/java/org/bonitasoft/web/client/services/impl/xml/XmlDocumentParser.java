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
		}
		catch (ParserConfigurationException e) {
			throw new ClientException("Failed to create xml parser", e);
		}
	}

	public Document parse(File xmlFile) {
		try {
			final Document document = documentBuilder.parse(xmlFile);
			document.getDocumentElement().normalize();
			return document;
		}
		catch (SAXException | IOException e) {
			throw new ClientException("Failed to read xml document", e);
		}
	}

	public Document parse(byte[] doc) {
		try {
			final Document document = documentBuilder.parse(new ByteArrayInputStream(doc));
			document.getDocumentElement().normalize();
			return document;
		}
		catch (SAXException | IOException e) {
			throw new ClientException("Failed to read xml document", e);
		}
	}

	public NodeList queryNodeList(Document document, String query) {
		try {
			XPath xPath = XPathFactory.newInstance().newXPath();
			XPathExpression compile = xPath.compile(query);
			return (NodeList) compile.evaluate(document, XPathConstants.NODESET);
		}
		catch (XPathExpressionException e) {
			throw new ClientException("Failed to query xml node from file: " + query, e);
		}
	}

}
