package com.automation.pages;

import com.automation.core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private final By txtUsername = By.id("taiKhoan");
    private final By txtPassword = By.id("matKhau");
    private final By chkRememberMe = By.xpath("//input[@name='remember']");
    private final By btnTogglePassword = By.xpath("//input[@id='matKhau']/ancestor::div[contains(@class,'MuiOutlinedInput-root')]//button");
    private final By btnLogin = By.xpath("//button[.//span[text()='Đăng nhập']]");
    private final By lnkRegister = By.xpath("//a[@href='/sign-up']");
    private final By msgLoginSuccess = By.xpath("//h2[text()='Đăng nhập thành công']");
    private final By msgInvalidCredentials = By.xpath("//div[@class='MuiAlert-message']");
    private final By msgUsernameError = By.id("taiKhoan-helper-text");
    private final By msgPasswordError = By.id("matKhau-helper-text");

    @Step("Enter username: {username}")
    public void enterUsername(String username) {
        type(txtUsername, username);
    }

    @Step("Enter password")
    public void enterPassword(String password) {
        type(txtPassword, password);
    }

    @Step("Click Login")
    public void clickLogin() {
        click(btnLogin);
    }

    @Step("Click Remember Me")
    public void clickRememberMe() {
        click(chkRememberMe);
    }

    public void clickTogglePassword() {
        click(btnTogglePassword);
    }


    public void clickRegisterLink() {
        click(lnkRegister);
    }



    @Step("Get login success message")
    public String getLoginSuccessMessage() {
        return getText(msgLoginSuccess);
    }

    @Step("Get login error message")
    public String getLoginErrorMessage() {
        return getText(msgInvalidCredentials);
    }

    @Step("Get username error message")
    public String getUsernameErrorMessage() {
        return getText(msgUsernameError);
    }

    @Step("Get password error message")
    public String getPasswordErrorMessage() {
        return getText(msgPasswordError);
    }
}
