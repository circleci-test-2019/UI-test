package com.freenow.android_demo.hola.pages;



import com.freenow.android_demo.R;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;


public class Login {
    public void enterUserName(String userName) {
        onView(withId(R.id.edt_username))
                .perform(typeText(userName), closeSoftKeyboard())
                .check(matches(isDisplayed()));
    }

    public void enterPassword(String password) {
        onView(withId(R.id.edt_password))
                .perform(typeText(password), closeSoftKeyboard())
                .check(matches(isDisplayed()));
    }

    public void checkLoginButtonExist() {
        onView(withId(R.id.btn_login))
                .check(matches(isDisplayed()));
    }

    public void clickLoginButton() {
        onView(withId(R.id.btn_login))
                .perform(click());
    }

    public void waitForErrorMessage(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void checkLoginFailedErrorMessageIsDisplayed() {
        onView(allOf(withId(android.support.design.R.id.snackbar_text), withText(R.string.message_login_fail)))
                .check(matches(isDisplayed()));
    }

    public void loginWithValidCredentials (String userName, String password) {
        this.enterUserName(userName);
        this.enterPassword(password);
        this.clickLoginButton();
    }

}