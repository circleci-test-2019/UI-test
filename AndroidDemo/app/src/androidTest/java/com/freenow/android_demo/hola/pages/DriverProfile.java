package com.freenow.android_demo.hola.pages;

import com.freenow.android_demo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class DriverProfile {

    public void checkDriverNameExist(String driverName) {
        onView(withText(driverName))
                .check(matches(isDisplayed()));
    }

    public void clickDialButton() {
        onView(withId(R.id.fab))
                .perform(click());
    }
}
