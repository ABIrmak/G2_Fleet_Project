package com.G2_fleet_project.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    /*
    Create the Properties object.
    - Make it "private" so it can't be accessed directly through the class.
    - Make it "static" to make sure it's created and loaded before everything else using the "static block".
     */
    private static Properties properties = new Properties();

    static{
        try {
            // Open the file using FileInputStream.
            FileInputStream file = new FileInputStream("configuration.properties");

            // Load the "properties" object with the "file" (load properties).
            properties.load(file);

            // Close the file
            file.close();
        }
        catch (IOException e) {
            System.out.println("FILE NOT FOUND WITH THE GIVEN PATH!");
            e.printStackTrace();
        }
    }

    /**
     * Returns the value of the specified property.
     * @param keyword Property keyword.
     * @return Value of the specified property.
     */
    public static String getProperty(String keyword){
        return properties.getProperty(keyword);
    }
}
