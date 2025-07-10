package Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop = new Properties();

    // Load properties file based on environment
    public static void loadProperties(String fileName) {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/" + fileName);
            prop.load(fis);
            fis.close();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file: " + fileName, e);
        }
    }

    // Read a value
    public static String getProperty(String key) {
        return prop.getProperty(key);
    }

    // Write or update a value
    public static void setProperty(String key, String value, String fileName) {
        try {
            prop.setProperty(key, value);
            FileOutputStream fos = new FileOutputStream("src/test/resources/" + fileName);
            prop.store(fos, "Updated by Automation");
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException("Failed to write to properties file: " + fileName, e);
        }
    }
}
