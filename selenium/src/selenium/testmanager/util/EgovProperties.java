package selenium.testmanager.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EgovProperties {
		
	public static String getPathProperty(String keyName) {
		
		final String GLOBALS_PROPERTIES_FILE = "properties/config.properties";
		String value = "";
		
		FileInputStream fis = null;
		try{
			Properties props = new Properties();
			fis = new FileInputStream(GLOBALS_PROPERTIES_FILE);
			props.load(new java.io.BufferedInputStream(fis));
			if(props.getProperty(keyName) != null){
				value = props.getProperty(keyName);
				value = value.trim();
			}
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return value;
	}
}