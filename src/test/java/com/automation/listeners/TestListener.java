package com.automation.listeners;

import com.automation.base.BaseTest;
import com.automation.utils.LogUtils;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        // Log the start of the test
        LogUtils.info("========== BẮT ĐẦU TEST: " + result.getName() + " ==========");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Log the success of the test
        LogUtils.info("========== KẾT QUẢ [PASS]: " + result.getName() + " ==========");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Log the failure of the test

        String errorMessage = (result.getThrowable() != null) ? result.getThrowable().getMessage() : "Không rõ nguyên nhân";
        LogUtils.error("========== KẾT QUẢ [FAIL]: " + result.getName() + " | Lý do: " + errorMessage + " ==========");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Log the skipped test
        LogUtils.warn("========== KẾT QUẢ [SKIP]: " + result.getName() + " ==========");
    }
}
//public class TestListener implements IHookable {
//
//
//    @Override
//    public void run(IHookCallBack callBack, ITestResult testResult) {
//        // 1. Thực thi phương thức @Test
//        callBack.runTestMethod(testResult);
//
//
//    }
//}

