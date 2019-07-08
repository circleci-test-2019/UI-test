package com.freenow.android_demo.hola.pages;

import android.support.test.espresso.DataInteraction;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.matcher.RootMatchers;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.freenow.android_demo.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.pressKey;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsMapContaining.hasEntry;
import static org.hamcrest.core.StringStartsWith.startsWith;

public class MainPage {

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
                .perform(typeText(searchKeyword));

//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        onView(withText("Your field name"))
//                .inRoot(withDecorView(not(is(getActivity().getWindow().getDecorView()))))
//                .perform(click());
//        onView(withText("Sarah Scott"))
//                .inRoot(RootMatchers.isPlatformPopup())
//                .perform(click());

//        onData(equalTo("Sarah Scott")).inRoot(RootMatchers.isPlatformPopup()).perform(click());

    }

    public void selectSearchResult(String driverName) {
//        DataInteraction appCompatTextView = onData(anything())
//                .inAdapterView(childAtPosition(
//                        withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),
//                        0))
//                .atPosition(1);
//        appCompatTextView.perform(click());
//        onData(hasEntry(equalTo(ListViewActivity.ROW_TEXT),is("List item: 25")))
//                .onChildView(withId(R.id.rowTextView)).perform(click());
        onData(equalTo(driverName)).inRoot(RootMatchers.isPlatformPopup()).perform(click());


    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
