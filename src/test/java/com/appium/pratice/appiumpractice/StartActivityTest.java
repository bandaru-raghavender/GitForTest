package com.appium.pratice.appiumpractice;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class StartActivityTest extends BaseAndriodTest{

    @Before public void setUp() {
        Activity activity = new Activity("io.appium.android.apis", ".ApiDemos");
        driver.startActivity(activity);
    }

    @Test public void startActivityInThisAppTestCase() {
        Activity activity = new Activity("io.appium.android.apis",
            ".accessibility.AccessibilityNodeProviderActivity");
        driver.startActivity(activity);
        assertEquals(driver.currentActivity(),
            ".accessibility.AccessibilityNodeProviderActivity");
    }
    
    @Test public void startActivityWithWaitingAppTestCase() {
        final Activity activity = new Activity("io.appium.android.apis",
            ".accessibility.AccessibilityNodeProviderActivity")
                .setAppWaitPackage("io.appium.android.apis")
                .setAppWaitActivity(".accessibility.AccessibilityNodeProviderActivity");
        driver.startActivity(activity);
        assertEquals(driver.currentActivity(),
            ".accessibility.AccessibilityNodeProviderActivity");
    }
    
    @Test public void startActivityInNewAppTestCase() {
        Activity activity = new Activity("com.android.settings", ".Settings");
        driver.startActivity(activity);
        assertEquals(driver.currentActivity(), ".Settings");
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        assertEquals(driver.currentActivity(), ".ApiDemos");
    }

    @Test public void startActivityInNewAppTestCaseWithoutClosingApp() {
        Activity activity = new Activity("io.appium.android.apis",
            ".accessibility.AccessibilityNodeProviderActivity");
        driver.startActivity(activity);
        assertEquals(driver.currentActivity(), ".accessibility.AccessibilityNodeProviderActivity");

        Activity newActivity = new Activity("com.android.settings", ".Settings")
                .setAppWaitPackage("com.android.settings")
                .setAppWaitActivity(".Settings")
                .setStopApp(false);
        driver.startActivity(newActivity);
        assertEquals(driver.currentActivity(), ".Settings");
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        assertEquals(driver.currentActivity(), ".accessibility.AccessibilityNodeProviderActivity");
    }

}
