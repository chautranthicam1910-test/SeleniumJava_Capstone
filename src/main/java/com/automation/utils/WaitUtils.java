package com.automation.utils;

import com.automation.core.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    // Wait for an element to be visible on the page
    public static WebElement waitForVisibility(By locator) {
//
//        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(Integer.parseInt(ConfigReader.get("timeout"))));
//
//        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        WebDriverWait wait = new WebDriverWait(
                DriverManager.getDriver(),
                Duration.ofSeconds(Integer.parseInt(ConfigReader.get("timeout")))
        );
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        // Implement slow motion if configured
        String slowMotion = ConfigReader.get("slow.motion.ms");
        if (slowMotion != null && Integer.parseInt(slowMotion) > 0) {
            try {
                Thread.sleep(Integer.parseInt(slowMotion));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        return element;
    }
}