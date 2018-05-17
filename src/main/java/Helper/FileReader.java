package Helper;

import java.util.Enumeration;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.io.InputStream;

public class FileReader {

	

	private static ClassLoader loader = Thread.currentThread()
			.getContextClassLoader();
	
	
	private static final Logger LOGGER = Logger.getLogger(FileReader.class
			.getName());
	

	
	
	/**
	 * 
	 * @param key1
	 * @return
	 */
	
	
	public static String getPropValuesFromFile(String key1) {
		String applPropFilePath = "application.properties";
		String returnValue = null;
		try {
			Properties properties = new Properties();

			InputStream stream = loader
					.getResourceAsStream(applPropFilePath);
			properties.load(stream);
			Enumeration<?> enuKeys = properties.keys();
			while (enuKeys.hasMoreElements()) {
				String key = (String) enuKeys.nextElement();
				String value = properties.getProperty(key);
				if (key.equals(key1)) {
					returnValue = value;
					break;
				}
			}
		} catch (Exception e) {

			LOGGER.log(Level.SEVERE, "Exception occured", e.getMessage());

		}
		return returnValue;
	}
	
	



}
