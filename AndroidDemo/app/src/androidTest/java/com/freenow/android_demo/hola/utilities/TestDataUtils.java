package com.freenow.android_demo.hola.utilities;

import android.content.Context;
import android.content.res.Resources;
import android.support.test.InstrumentationRegistry;

import com.freenow.android_demo.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.Scanner;

public class TestDataUtils {
    private static TestDataUtils instance;
    private static final Object lock = new Object();

    private static String searchKeyword;
    private static String IncorrectUsername;
    private static String IncorrectPassword;
    private static String loginUsername;
    private static String loginPassword;
    private static String driverName;

    public static TestDataUtils getInstance() {
        if (instance == null) {
            synchronized (lock) {
                instance = new TestDataUtils();
                instance.loadJSONFromAsset();
            }
        }
        return instance;
    }

    private void loadJSONFromAsset() {
        Context appContext = InstrumentationRegistry.getTargetContext();
        Resources res = appContext.getResources();
        InputStream is = res.openRawResource(R.raw.testdata);
        Scanner scanner = new Scanner(is);
        StringBuilder builder = new StringBuilder();
        while (scanner.hasNextLine()) {
            builder.append(scanner.nextLine());
        }
        try {

            JSONObject testData = new JSONObject(builder.toString());
            searchKeyword = testData.get("searchKeyword").toString();
            loginUsername = testData.get("loginUsername").toString();
            loginPassword = testData.get("loginPassword").toString();
            IncorrectUsername = testData.get("IncorrectUsername").toString();
            IncorrectPassword = testData.get("IncorrectPassword").toString();
            driverName = testData.get("driverName").toString();

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getSearchKeyword() {
        return searchKeyword;
    }

    public String getIncorrectUsername() {
        return IncorrectUsername;
    }

    public String getIncorrectPassword() {
        return IncorrectPassword;
    }

    public String getCorrectUsername() {
        return loginUsername;
    }

    public String getCorrectPassword() {
        return loginPassword;
    }
    public String getDriverName() {
        return driverName;
    }
}



