package com.automation.listeners;


import com.automation.base.BaseTest;
import com.automation.utils.ScreenshotUtils;
import io.qameta.allure.Allure;
import io.qameta.allure.listener.StepLifecycleListener;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;

public class AllureStepListener implements StepLifecycleListener {

    @Override
    public void beforeStepStop(StepResult result) {

        if (result.getStatus() == Status.FAILED || result.getStatus() == Status.BROKEN) {


            WebDriver driver = BaseTest.getStaticDriver();

            if (driver != null) {
                byte[] screenshot = ScreenshotUtils.takeScreenshot(driver);
                if (screenshot != null) {
                    Allure.addAttachment("Step Failure Screenshot","image/png",new ByteArrayInputStream(screenshot), ".png");
                }
            }
        }
    }
}
