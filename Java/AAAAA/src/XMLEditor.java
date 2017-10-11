/***********************************************************************
 * BMC Software, Inc.
 * Confidential and Proprietary
 * Copyright (c) BMC Software, Inc. 1999-2012
 * All Rights Reserved.
 ***********************************************************************/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


/**
 * ITDAPostInstallInstallationTask performs the post-install steps for the
 * BayWatch
 *
 * @author Patrick Malloy
 */ 
public class XMLEditor {
	/*
	 * Method to update "web.xml" file while enabling RSSO in installer.
	 */
	public static void main(String[] args){
		XMLEditor x = new XMLEditor();
		x.updateWebXmlFileForRSSO();
	}
    void updateWebXmlFileForRSSO() {
    	File rssoWebXmlFile = new File("C:\\Program Files\\BMC Software\\TrueSight\\ITDA\\tomcat\\webapps\\console\\WEB-INF\\web.xml");
    		try {
    			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
    					.newInstance();
    			DocumentBuilder documentBuilder = documentBuilderFactory
    					.newDocumentBuilder();

    			if (rssoWebXmlFile != null && rssoWebXmlFile.exists()) {
    				/* parse existing file to DOM */
    				Document document = documentBuilder.parse(rssoWebXmlFile);
    				NodeList nodes = document.getElementsByTagName("session-config");
    				Element configFilterNode = document.createElement("filter");
    				document.appendChild(configFilterNode);

    				Element filterName = document.createElement("filter-name");
    				filterName.appendChild(document
    						.createTextNode("rsso"));
    				configFilterNode.appendChild(filterName);

    				Element filterClass = document.createElement("filter-class");
    				filterClass.appendChild(document
    						.createTextNode("rsso-text"));
    				configFilterNode.appendChild(filterClass);
    				if (nodes.item(0) != null) {
    					nodes.item(0).getParentNode().insertBefore(configFilterNode, nodes.item(0));
    				}

    				Element configFilterMappingNode = document
    						.createElement("filter-mapping");
    				document.appendChild(configFilterMappingNode);
    				Element filterName1 = document.createElement("filter-name");
    				filterName1.appendChild(document
    						.createTextNode("mapText"));
    				configFilterMappingNode.appendChild(filterName1);

    				Element urlPattern = document.createElement("url-pattern");
    				urlPattern.appendChild(document
    						.createTextNode("urlPattrensss"));
    				configFilterMappingNode.appendChild(urlPattern);
    				if (nodes.item(0) != null) {
    					nodes.item(0).getParentNode().insertBefore(configFilterMappingNode, nodes.item(0));
    				}

    				TransformerFactory transformerFactory = TransformerFactory
    						.newInstance();
    				Transformer transformer = transformerFactory.newTransformer();
    				DOMSource source = new DOMSource(document);
    				StreamResult result = new StreamResult(rssoWebXmlFile);
    				transformer.setOutputProperty(OutputKeys.INDENT, "yes");
    				transformer.setOutputProperty(
    						"{http://xml.apache.org/xslt}indent-amount","4");
    				transformer.transform(source, result);
    			} else {
    				
    			}
    		} catch (Throwable t) {
    			
    		}
    	}
    
}
