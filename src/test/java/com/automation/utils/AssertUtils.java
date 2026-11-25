package com.automation.utils;


// Step common


import io.qameta.allure.Step;
import org.testng.Assert;

public class AssertUtils {

    //Verify displayed message
    @Step("Verify message hiển thị: Expected [{expected}] - Actual [{actual}]")
    public static void assertEquals(Object actual, Object expected) {
        LogUtils.info("Asserting equals -> Expected: [" + expected + "], Actual: [" + actual + "]");
        Assert.assertEquals(actual, expected);
    }

    @Step("Verify condition is True: {message}")
    public static void assertTrue(boolean condition, String message) {
        LogUtils.info("Asserting true -> " + message);
        Assert.assertTrue(condition, message);
    }
}

