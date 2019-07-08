package com.freenow.android_demo.hola.pages;


import android.support.test.espresso.matcher.RootMatchers;


import com.freenow.android_demo.R;


import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.equalTo;

public class HomePage {

    public static void checkAppNameExist() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withText(R.string.app_name))
                .check(matches(isDisplayed()));
    }

    public void enterSearchText(String searchKeyword) {
        onView(withId(R.id.textSearch))
                .perform(click())
                .perform(replaceText(searchKeyword));
    }

    public void selectSearchResult(String driverName) {
        onData(equalTo(driverName)).inRoot(RootMatchers.isPlatformPopup()).perform(click());
    }
}
