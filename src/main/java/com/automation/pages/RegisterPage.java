package com.automation.pages;

import com.automation.core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class RegisterPage extends BasePage {

    private final By lblRegisterTitle = By.xpath("//h1[contains(text(),'Đăng ký')]");
    private final By txtUsername = By.id("taiKhoan");
    private final By txtPassword = By.id("matKhau");
    private final By txtConfirmPassword = By.id("confirmPassWord");
    private final By txtFullName = By.id("hoTen");
    private final By txtEmail = By.id("email");
    private final By btnRegister = By.xpath("//button[.//span[text()='Đăng ký']]");
    private final By lnkLogin = By.xpath("//a[@href='/sign-in']");
    private final By msgRegisterSuccess = By.xpath("//h2[text()='Đăng ký thành công']");
    private final By msgUsernameError = By.id("taiKhoan-helper-text");
    private final By msgPasswordError = By.id("matKhau-helper-text");
    private final By msgConfirmPasswordError = By.id("confirmPassWord-helper-text");
    private final By msgFullNameError = By.id("hoTen-helper-text");
    private final By msgEmailError = By.id("email-helper-text");
    private final By msgExistingEmail = By.xpath("//div[@class='MuiAlert-message']");

    @Step("Enter username")
    public void enterUsername(String username) {
        type(txtUsername, username);
    }

    @Step("Enter password")
    public void enterPassword(String password) {
        type(txtPassword, password);
    }
    @Step("Enter confirm password")
    public void enterConfirmPassword(String confirmPassword) {
        type(txtConfirmPassword, confirmPassword);
    }
    @Step("Enter full name")
    public void enterFullName(String fullName) {
        type(txtFullName, fullName);
    }
    @Step("Enter email")
    public void enterEmail(String email) {
        type(txtEmail, email);
    }
    @Step("Click register button")
    public void clickRegister() {
        click(btnRegister);
    }
    @Step("Click login link")
    public void clickLoginLink() {
        click(lnkLogin);
    }
    @Step("Get register success message")
    public String getRegisterSuccessMessage() {
        return getText(msgRegisterSuccess);
    }
    @Step("Get username error message")
    public String getUsernameErrorMessage() {
        return getText(msgUsernameError);
    }
    @Step("Get password error message")
    public String getPasswordErrorMessage() {
        return getText(msgPasswordError);
    }
    @Step("Get confirm password error message")
    public String getConfirmPasswordErrorMessage() {
        return getText(msgConfirmPasswordError);
    }
    @Step("Get full name error message")
    public String getFullNameErrorMessage() {
        return getText(msgFullNameError);
    }
    @Step("Get email error message")
    public String getEmailErrorMessage() {
        return getText(msgEmailError);
    }
    @Step ("Get existing email error message")
    public String getExistingEmailErrorMessage() {
        return getText(msgExistingEmail);
    }
}
