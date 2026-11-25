package com.automation.flows;

import com.automation.constants.TestData;
import com.automation.pages.LoginPage;
import io.qameta.allure.Step;



public class LoginFlow {

    private final LoginPage loginPage = new LoginPage();

    @Step("Perform login with username: {0}")
    public void login(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    @Step("Login with valid credentials")
    public void loginAsValidUser(String username, String password) {
        login(username, password);
    }

    @Step ("Login with invalid credentials")
    public void loginAsInvalidUser() {
        login(TestData.INVALID_USERNAME, TestData.INVALID_PASSWORD);
    }

    @Step ("Login with valid credentials but empty password")
    public void loginWithEmptyPassword() {
        login(TestData.VALID_USERNAME, "");
    }

    @Step ("Login with valid credentials but empty username")
    public void loginWithEmptyUsername() {
        login("", TestData.VALID_PASSWORD);
    }



}