package com.cybertek.utilities;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class ConfigurationReader {
    private static Properties properties;
    static{
        try {
            //reads file in java, we need to pass the path of the file
            FileInputStream fis = new FileInputStream("configuration.properties");
            //initialize the file
            properties = new Properties();
            //load contents of the file to the properties object
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //try with resource, try/catch block can take a parameter, AutoCloseable

    public static String getProperty(String key){
        return properties.getProperty(key);

    }
}
