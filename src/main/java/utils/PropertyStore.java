package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by nikita on 23.02.2017.
 */
public class PropertyStore {

    private static volatile PropertyStore propertyStore = null;
    private String browserName;

    private PropertyStore() {
        Properties envProps = getProperties();
        browserName = envProps.getProperty("browser.name");
    }

    public static PropertyStore getInstance() {
        if (propertyStore == null)
            synchronized (PropertyStore.class) {
                if (propertyStore == null)
                    propertyStore = new PropertyStore();
            }
        return propertyStore;
    }


    public String getBrowserName() {
        return browserName;
    }

    private static Properties getProperties() {
        String propertiesFile = "target/classes/startup.properties";
        FileInputStream fileInput = null;
        Properties properties = null;
        try {
            File file = new File(propertiesFile);
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
