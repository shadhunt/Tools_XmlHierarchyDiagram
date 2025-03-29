package c.major.studio.processor;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import c.major.studio.handler.XmlHandler;

public class XmlProcessor {
	private XmlHandler handler;
	private SAXParserFactory saxParserFactory;
	private SAXParser saxParser;
	public XmlProcessor() {
		super();
		// TODO Auto-generated constructor stub

		
		handler = new XmlHandler();
		try {
			saxParser = SAXParserFactory.newInstance().newSAXParser();
		} catch (ParserConfigurationException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Map<String, String> processXml(String path)
	{
		Map<String, String> resultMap = new HashMap<>();
		File file = new File(path);
		try {
			saxParser.parse(file, handler);
			resultMap = handler.getInheritanceMap();	
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return resultMap;
	}
}
