package com.freenow.android_demo.hola.tests;

import android.support.test.rule.ActivityTestRule;
import android.support.test.rule.GrantPermissionRule;

import com.freenow.android_demo.activities.AuthenticationActivity;
import com.freenow.android_demo.activities.DriverProfileActivity;
import com.freenow.android_demo.activities.MainActivity;
import com.freenow.android_demo.hola.pages.DriverProfile;
import com.freenow.android_demo.hola.pages.Login;
import com.freenow.android_demo.hola.pages.HomePage;
import com.freenow.android_demo.hola.utilities.TestDataUtils;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;

public class HomePageTests {
    private HomePage homePage = new HomePage();
    private Login loginPage = new Login();
    private DriverProfile driverProfile = new DriverProfile();
    private String searchKeyword = TestDataUtils.getInstance().getSearchKeyword();
    private String correctUsername = TestDataUtils.getInstance().getCorrectUsername();
    private String correctPassword = TestDataUtils.getInstance().getCorrectPassword();
    private String driverName = TestDataUtils.getInstance().getDriverName();

    @Rule
    public ActivityTestRule<MainActivity> MainActivityTestRule = new ActivityTestRule<>(
            MainActivity.class);
    @Rule
    public ActivityTestRule<DriverProfileActivity> ProfileActivityTestRule = new ActivityTestRule<>(
            DriverProfileActivity.class, true, false);
    @Rule
    public GrantPermissionRule mGrantPermissionRule =
            GrantPermissionRule.grant(
                    "android.permission.ACCESS_FINE_LOCATION");

    @Test
    public void shouldDisplayDriverProfile_searchAndSelectDriverName() {
        loginPage.loginWithValidCredentials(correctUsername, correctPassword);
        HomePage.checkAppNameExist();
        homePage.enterSearchText(searchKeyword);

//        mainPage.selectSearchResult(driverName);
//        driverProfile.checkDriverNameExist(driverName);
//        driverProfile.clickDialButton();
    }
}
