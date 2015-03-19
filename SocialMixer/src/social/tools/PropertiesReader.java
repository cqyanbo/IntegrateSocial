package social.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

public class PropertiesReader {
	private static Properties property;
	private static String propertyFile = "resources/credential.properties";
	
	private static void generateProperty() throws IOException{
		property = new Properties();
		InputStream inputStream = new FileInputStream(new File(propertyFile));
		property.load(inputStream);
	}
	
	public static Enumeration<?> getProperties() throws IOException{
		if(property == null){
			PropertiesReader.generateProperty();
		}
		return property.propertyNames();
	}
	
	public static String getProperty(String key) throws IOException{
		if(property == null){
			PropertiesReader.generateProperty();
		}
		
		return property.getProperty(key);
	}
	
	public static String getProperty(String key, String defaultValue) throws IOException{
		if(property == null){
			PropertiesReader.generateProperty();
		}
		
		return property.getProperty(key, defaultValue);
	}
	
	
	
}
