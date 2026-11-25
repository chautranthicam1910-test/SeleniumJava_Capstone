package com.automation.utils;

import com.automation.core.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.qameta.allure.Attachment;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtils {


    public static byte[] takeScreenshot(WebDriver driver) {
        if (driver == null) {
            return null;
        }
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public static void saveScreenshot() {

        File screenshot = ((TakesScreenshot) DriverManager.getDriver()) .getScreenshotAs(OutputType.FILE);

        try {

            FileUtils.copyFile(screenshot,new File("screenshots/failure-"+ System.currentTimeMillis() + ".png"));

        } catch (IOException e) {

            throw new RuntimeException(e);
        }
    }

    @Attachment(value = "Failure Screenshot",type = "image/png")
    public static byte[] attachScreenshot() {

        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);

    }
}


