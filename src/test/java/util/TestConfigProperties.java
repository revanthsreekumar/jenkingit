package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



public class TestConfigProperties {


    public  String testReadConfigProperties(String propertyKey) {
        try {
            // Load the resource file as an input stream
            InputStream inputStream = getClass().getResourceAsStream("/config.properties");

            if (inputStream != null) {
                // Create a Properties object and load the properties from the input stream
                Properties properties = new Properties();
                properties.load(inputStream);
                String propertyValue = properties.getProperty(propertyKey);
                return propertyValue;
                		} else {
                System.err.println("Resource not found.");
                return null;
            }
           
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
		
    }
}
