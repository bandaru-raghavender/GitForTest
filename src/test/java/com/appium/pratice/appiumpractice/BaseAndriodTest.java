/** Second Commit on Master */

package com.appium.pratice.appiumpractice;

import java.net.URL;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;

public class BaseAndriodTest {

	private static AppiumDriverLocalService appiumDefaultService;

	protected static AndroidDriver<AndroidElement> driver;

	@BeforeClass
	public static void beforeClass() {
		appiumDefaultService = AppiumDriverLocalService.buildDefaultService();
		appiumDefaultService.start();
		if (appiumDefaultService == null || !appiumDefaultService.isRunning()) {
			throw new AppiumServerHasNotBeenStartedLocallyException("It seems local service has not been started");
		}
		DesiredCapabilities desiredCapability = new DesiredCapabilities();
		desiredCapability.setCapability(MobileCapabilityType.APP, "C:\\Appium_Wk\\appiumpractice\\ApiDemos-debug.apk");
		desiredCapability.setCapability(MobileCapabilityType.DEVICE_NAME, "Emulator");
		desiredCapability.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		desiredCapability.setCapability("eventTimings", true);
		desiredCapability.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		driver = new AndroidDriver<AndroidElement>(appiumDefaultService.getUrl(), desiredCapability);
	}

	@AfterClass
	public static void afterClass() {
		if (driver != null) {
			driver.close();
		}
		if (appiumDefaultService != null) {
			appiumDefaultService.stop();
		}
	}
}
