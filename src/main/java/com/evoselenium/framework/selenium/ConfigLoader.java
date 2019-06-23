package com.evoselenium.framework.selenium;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.jetbrains.annotations.NotNull;

public enum ConfigLoader {

    INSTANCE;

    private final Properties properties;

    @NotNull
    public static ConfigLoader get() {
        return INSTANCE;
    }

    ConfigLoader() {
        properties = new Properties();

        try (final InputStream stream = getClass().getClassLoader().getResourceAsStream("test.properties")) {
            properties.load(stream);
        } catch (IOException ex) {
            System.out.println("Unable to read properties from 'test.properties' file");
            System.out.println(ex); //todo: change to normal logging
        }
    }

    public String getSeleniumDriver() {
        return properties.getProperty("selenium.driver");
    }

    public String getHostNameUrl() {
        return properties.getProperty("host.name.url");
    }

    public String getDriverStayAlive() {
        return properties.getProperty("driver.stay.alive");
    }
}
