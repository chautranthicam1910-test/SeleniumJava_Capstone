package com.automation.utils;

import io.qameta.allure.Allure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtils {

    private static final Logger logger = LoggerFactory.getLogger(LogUtils.class);

    public static void info(String message) {
        logger.info(message);
    }

    public static void warn(String message) {
        logger.warn(message);
    }

    public static void error(String message) {
        logger.error(message);
    }

    // Ghi log đồng thời hiển thị lên giao diện Allure Report
    public static void stepLog(String message) {
        logger.info(message);
        Allure.step(message);
    }
}
