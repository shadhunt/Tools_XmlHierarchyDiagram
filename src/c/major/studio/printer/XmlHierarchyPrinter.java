package c.major.studio.printer;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map;
import java.util.Map.Entry;

public class XmlHierarchyPrinter {
	
	private boolean isDebugged=false;
	private Map<String, String> xmlValueMap;
	public XmlHierarchyPrinter(Map<String, String> xmlValueMap) {
		this.xmlValueMap = xmlValueMap;
		// TODO Auto-generated constructor stub
	}
	
	public void processPrinting()
	{
		for(Entry<String, String> entry : xmlValueMap.entrySet())
		{
			if(entry.getValue()==null)
			{
				printHierarchy(entry.getKey(),0);
			}
		}
	}
	
	public void printHierarchy(String key, int level)
	{
		if (isDebugged) {
			System.out.println("level:"+level);
		}
		for(int n=0;n<level;n++)
		{
			System.out.print("  ");
		}
		System.out.println("|--"+key);
		for(Entry<String, String> entry : xmlValueMap.entrySet())
		{
			if(entry.getValue()!=null && entry.getValue().equals(key))
			{
				printHierarchy(entry.getKey(), ++level);
			}
		}
	}
	/* this ia reversed way of output the parent and child
	public void processPrinting()
	{
		for(Entry<String, String> entry: xmlValueMap.entrySet())
		{
			int level=0;
			if(entry.getValue()!=null)
			{
				printHierarchy(entry,level);
			}
		}
	}
	public void printHierarchy(Entry<String, String> entry, int level)
	{
		for(int n=0;n<level;n++)
		{
			System.out.print("-");
		}
		System.out.println(entry.getKey());
		if(entry.getValue()!=null)
		{
			String nextKey = xmlValueMap.get(entry.getKey());
			Entry<String, String> nextEntry = new SimpleEntry<>(nextKey, xmlValueMap.get(nextKey));
			printHierarchy(nextEntry,++level);
		} else {
			System.out.println(entry.getKey());
			return;
		}
			
	}
	*/
}
