package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.pages.NavigationBar;
import com.automation.pages.RegisterPage;
import com.automation.utils.AssertUtils;
import com.automation.utils.RandomDataUtils;
import com.automation.utils.TestContext;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {
    private final NavigationBar navigationBar = new NavigationBar();
    private final RegisterPage registerPage = new RegisterPage();
    String username = RandomDataUtils.getRandomUsername();
    String email = RandomDataUtils.getRandomEmail();
    String password = RandomDataUtils.getRandomPassword();
    String fullName = RandomDataUtils.getRandomFullName();

    @Test (description = "TC_01: Register with valid credentials")
   // @Step("Register with valid information")
    public void registerSuccessfully() {
        navigationBar.clickRegister();
        registerPage.enterUsername(username);
        registerPage.enterPassword(password);
        registerPage.enterConfirmPassword(password);
        registerPage.enterEmail(email);
        registerPage.enterFullName(fullName);
        registerPage.clickRegister();
        // Add assertions to verify successful registration
        AssertUtils.assertEquals(registerPage.getRegisterSuccessMessage(), "Đăng ký thành công");
        // Save the registered username and password to TestContext for later use
        TestContext.registeredUsername = username;
        TestContext.registeredPassword = password;
        TestContext.registeredEmail = email;

    }

    @Test (dependsOnMethods = "registerSuccessfully", description = "TC_02: Register with existing email")
  //  @Step("Register with existing email")
    public void registerWithExistingEmail() {
        navigationBar.clickRegister();
        registerPage.enterUsername(username);
        registerPage.enterPassword(password);
        registerPage.enterConfirmPassword(password);
        registerPage.enterEmail(TestContext.registeredEmail);
        registerPage.enterFullName(fullName);
        registerPage.clickRegister();
        // Add assertions to verify registration with existing email
        AssertUtils.assertEquals(registerPage.getExistingEmailErrorMessage(), "Email đã tồn tại!");
    }
}