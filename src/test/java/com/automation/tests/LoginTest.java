package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.constants.TestData;
import com.automation.core.DriverManager;
import com.automation.flows.LoginFlow;
import com.automation.pages.LoginPage;
import com.automation.pages.NavigationBar;
import com.automation.utils.AssertUtils;
import com.automation.utils.TestContext;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private final NavigationBar navigationBar = new NavigationBar();
    private final LoginPage loginPage = new LoginPage();
    private final LoginFlow loginFlow = new LoginFlow();

    @Test (description = "Login_01: Login with valid credentials")
    public void loginWithValidCredentials() {
        String username = (TestContext.registeredUsername != null) ?
                TestContext.registeredUsername : TestData.VALID_USERNAME;
        String password = (TestContext.registeredPassword != null) ?
                TestContext.registeredPassword : TestData.VALID_PASSWORD;
        navigationBar.clickLogin();
        loginFlow.loginAsValidUser(username, password);
        // verify login success message
        AssertUtils.assertEquals(loginPage.getLoginSuccessMessage(), "Đăng nhập thành công");
    }

    @Test (description = "Login_02: Login with invalid credentials")
    public void loginWithInvalidCredentials() {
        navigationBar.clickLogin();
        loginFlow.loginAsInvalidUser();
        //verify login error message
        AssertUtils.assertEquals(loginPage.getLoginErrorMessage(), "Tài khoản hoặc mật khẩu không đúng");
    }


    @Test (description = "Login_03: Login with empty username")
    public void loginWithEmptyUsername() {
        navigationBar.clickLogin();
        loginFlow.loginWithEmptyUsername();
        //verify username error message
        AssertUtils.assertEquals(loginPage.getUsernameErrorMessage(), "Đây là trường bắt buộc !");
    }


    @Test (description = "Login_04: Login with empty password")
    public void loginWithEmptyPassword() {

        navigationBar.clickLogin();
        loginFlow.loginWithEmptyPassword();
        //verify password error message
        AssertUtils.assertEquals(loginPage.getPasswordErrorMessage(), "Đây là trường bắt buộc !");
    }
}