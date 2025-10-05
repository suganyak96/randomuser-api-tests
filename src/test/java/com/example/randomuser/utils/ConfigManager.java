package com.example.randomuser.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigManager {
    private static final Properties props = new Properties();

    static {
        // Build the full path to config.properties at project root
        String configFilePath = Paths.get(System.getProperty("user.dir"), "config.properties").toString();

        try (InputStream input = new FileInputStream(configFilePath)) {
            props.load(input);
            System.out.println("✅ Loaded configuration from: " + configFilePath);
        } catch (IOException e) {
            throw new RuntimeException("❌ Failed to load configuration from: " + configFilePath, e);
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }

    public static int getInt(String key) {
        return Integer.parseInt(props.getProperty(key));
    }
}
