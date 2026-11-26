package com.automation.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();// Properties object to hold the configuration key-value pairs

    static {

        try (
                InputStream input =
                        ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")// Load the configuration file as an input stream
        ) {

            properties.load(input);// Load the properties from the input stream

        } catch (IOException e) {

            throw new RuntimeException(e);// Throw a runtime exception if there is an error loading the properties file
        }
    }

    public static String get(String key) {

        return properties.getProperty(key);// Get the value associated with the specified key from the properties object
    }
}