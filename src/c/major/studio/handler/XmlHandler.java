package c.major.studio.handler;

import java.util.HashMap;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XmlHandler extends DefaultHandler{

	private Map<String, String> inheritanceMap = new HashMap<>();
	private String nameProperty = "name";
	private String includePropsProperty = "include_props";
	
	
	public Map<String, String> getInheritanceMap() {
		return inheritanceMap;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);
//		System.out.println("Starting Element uri:"+uri+" localName:"+localName+" qName:"+qName+" attributes:"+attributes);
		if(qName.equalsIgnoreCase("Object"))
		{
			String nameValue = getValue(nameProperty,attributes);
			String includePropsValue = getValue(includePropsProperty, attributes);
			if(nameValue != null)
			{
				if(includePropsValue!=null)
				{
					inheritanceMap.put(nameValue, includePropsValue);
				}
				else
				{
					inheritanceMap.put(nameValue, null);
				}
			}
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
//		System.out.println("Ending Element uri:"+uri+" localName:"+localName+" qName:"+qName);
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
//		System.out.println("Characters:"+ch+" start:"+start+" length:"+length);
	}
	
	
	private String getValue(String attibuteName, Attributes attributes)
	{
		 String value = attributes.getValue(attibuteName);
		 return value;
	}
}
