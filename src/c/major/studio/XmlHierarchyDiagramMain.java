package c.major.studio;

import java.util.Map;

import c.major.studio.printer.XmlHierarchyPrinter;
import c.major.studio.processor.XmlProcessor;

public class XmlHierarchyDiagramMain {
	private static String xmlPath = "Target_XML_Files\\dir1\\fileA1.config";

	public static void main(String[] args)
	{
		System.out.println("XML Hierarchy Diagram Main  v1.0");
		XmlProcessor processor = new XmlProcessor();
		try {
			Map<String, String> xmlMap = processor.processXml(xmlPath);
			XmlHierarchyPrinter printer = new XmlHierarchyPrinter(xmlMap);
			printer.processPrinting();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
