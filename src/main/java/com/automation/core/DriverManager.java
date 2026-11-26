package com.automation.core;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();// ThreadLocal is used to ensure that each thread has its own instance of WebDriver

    public static void setDriver(WebDriver driver) {

        DRIVER.set(driver);// Set the WebDriver
    }

    public static WebDriver getDriver() {

        return DRIVER.get();// Get the WebDriver

    }

    public static void quitDriver() {

        if (DRIVER.get() != null) {

            DRIVER.get().quit(); // Quit the WebDriver

            DRIVER.remove();// Remove the WebDriver from ThreadLocal to avoid memory leaks
        }
    }


}