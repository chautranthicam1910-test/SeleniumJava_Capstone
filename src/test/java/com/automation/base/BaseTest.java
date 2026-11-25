package com.automation.base;

import com.automation.core.DriverManager;
import com.automation.listeners.TestListener;
import com.automation.utils.ConfigReader;
import com.automation.utils.ScreenshotUtils;
import io.qameta.allure.Attachment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)

public class BaseTest {

    protected WebDriver driver;

    // Giữ lại hàm này để AllureStepListener gọi, bên trong lấy từ DriverManager
    public static WebDriver getStaticDriver() {
        return DriverManager.getDriver();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        DriverManager.setDriver(driver);
        DriverManager.getDriver().get(ConfigReader.get("base.url"));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}