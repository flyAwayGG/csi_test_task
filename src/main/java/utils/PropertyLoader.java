package utils;

/**
 * Created by root on 22.02.17.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


/**
 * Class that read properties from the properties file.
 * Thread-safe singleton
 */
public class PropertyLoader {

    private static final String PROPERTIES_FILE = "target/classes/startup.properties";

    private static volatile Properties properties = null;


    private PropertyLoader() {
    }


    public static Properties getProperties(){
        if(properties == null)
            synchronized (PropertyLoader.class){
                if(properties == null)
                    properties = loadProperties();
            }

        return properties;
    }

    private static Properties loadProperties() {
        FileInputStream fileInput = null;
        Properties properties = null;
        try {
            File file = new File(PROPERTIES_FILE);
            fileInput = new FileInputStream(file);
            properties = new Properties();
            properties.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInput != null) {
                    fileInput.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties;
    }



}