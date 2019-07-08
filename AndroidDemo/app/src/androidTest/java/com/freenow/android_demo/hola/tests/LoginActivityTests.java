package com.freenow.android_demo.hola.tests;

import android.support.test.rule.ActivityTestRule;
import android.support.test.rule.GrantPermissionRule;
import android.support.test.runner.AndroidJUnit4;

import com.freenow.android_demo.activities.AuthenticationActivity;
import com.freenow.android_demo.activities.MainActivity;
import com.freenow.android_demo.hola.pages.Login;
import com.freenow.android_demo.hola.pages.HomePage;
import com.freenow.android_demo.hola.utilities.TestDataUtils;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class LoginActivityTests {
    private Login loginPage = new Login();
    private String incorrectUsername = TestDataUtils.getInstance().getIncorrectUsername();
    private String correctUsername = TestDataUtils.getInstance().getCorrectUsername();
    private String incorrectPassword = TestDataUtils.getInstance().getIncorrectPassword();
    private String correctPassword = TestDataUtils.getInstance().getCorrectPassword();

    @Rule
    public ActivityTestRule<AuthenticationActivity> AuthActivityTestRule = new ActivityTestRule<>(
            AuthenticationActivity.class);
    @Rule
    public ActivityTestRule<MainActivity> MainActivityTestRule = new ActivityTestRule<>(
            MainActivity.class);

    @Rule
    public GrantPermissionRule mGrantPermissionRule = GrantPermissionRule.grant(
            "android.permission.ACCESS_FINE_LOCATION");

    @Test
    public void shouldDisplayLoginFailed_LoginWithEmptyUserName() {
        loginPage.enterPassword(correctPassword);
        loginPage.checkLoginButtonExist();
        loginPage.clickLoginButton();
        loginPage.waitForErrorMessage(2000);
        loginPage.checkLoginFailedErrorMessageIsDisplayed();
    }

    @Test
    public void shouldDisplayLoginFailed_LoginWithEmptyPassword() {
        loginPage.enterUserName(correctUsername);
        loginPage.checkLoginButtonExist();
        loginPage.clickLoginButton();
        loginPage.waitForErrorMessage(2000);
        loginPage.checkLoginFailedErrorMessageIsDisplayed();
    }

    @Test
    public void shouldDisplayLoginFailed_LoginWithEmptyCredentials() {
        loginPage.checkLoginButtonExist();
        loginPage.clickLoginButton();
        loginPage.waitForErrorMessage(1000);
        loginPage.checkLoginFailedErrorMessageIsDisplayed();

    }

    @Test
    public void shouldDisplayLoginFailed_LoginWithInvalidUserName() {
        loginPage.enterUserName(incorrectUsername);
        loginPage.enterPassword(correctPassword);
        loginPage.checkLoginButtonExist();
        loginPage.clickLoginButton();
        loginPage.waitForErrorMessage(2000);
        loginPage.checkLoginFailedErrorMessageIsDisplayed();
    }

    @Test
    public void shouldDisplayLoginFailed_LoginWithInvalidPassword() {
        loginPage.enterUserName(correctUsername);
        loginPage.enterPassword(incorrectPassword);
        loginPage.checkLoginButtonExist();
        loginPage.clickLoginButton();
        loginPage.waitForErrorMessage(2000);
        loginPage.checkLoginFailedErrorMessageIsDisplayed();
    }

    @Test
    public void shouldDisplayLoginFailed_LoginWithInvalidCredentials() {
        loginPage.enterUserName(incorrectUsername);
        loginPage.enterPassword(incorrectPassword);
        loginPage.checkLoginButtonExist();
        loginPage.clickLoginButton();
        loginPage.waitForErrorMessage(2000);
        loginPage.checkLoginFailedErrorMessageIsDisplayed();
    }

    @Test
    public void shouldNavigateToHomePage_LoginWithValidCredentials() {
        loginPage.enterUserName(correctUsername);
        loginPage.enterPassword(correctPassword);
        loginPage.checkLoginButtonExist();
        loginPage.clickLoginButton();
        HomePage.checkAppNameExist();
    }

}
