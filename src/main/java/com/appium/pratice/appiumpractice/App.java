/** Fifth or 3rd Commit on Mater Branch*/

package com.appium.pratice.appiumpractice;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws MalformedURLException
    {
//dsvdf
       DesiredCapabilities desiredCapability = new DesiredCapabilities();
       desiredCapability.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsungs8_API_28"); 
       desiredCapability.setCapability(MobileCapabilityType.APP, "C:\\Appium_Wk\\appiumpractice\\ApiDemos-debug.apk");
       desiredCapability.setCapability("deviceName","Emulator");
       desiredCapability.setCapability("platformName","Android");
       desiredCapability.setCapability("automationName","UiAutomator2");
       AndroidDriver<AndroidElement> driverName = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapability);
      //Object obj =  driverName.executeScript("mobile:deviceInfo");
        driverName.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        System.out.println(driverName.currentActivity());
        System.out.println(driverName.getCurrentPackage()); 
       // Activity activity = new Activity("com.android.documentsui","com.android.documentsui.files.FilesActivity");
        //driverName.startActivity(activity);
         System.out.println(driverName.currentActivity());
         System.out.println(driverName.getCurrentPackage());
       //driverName.runAppInBackground(Duration.ofSeconds(2));
         System.out.println(driverName.isAppInstalled("io.appium.android.apis"));
         driverName.closeApp();
     //  driverName.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
      // driverName.findElementByXPath("//android.widget.TextView[@text='WiFi']/parent::android.widget.RelativeLayout/following-sibling::android.widget.LinearLayout/android.widget.CheckBox").click();   
      // driverName.getStatus();
       // driverName.quit();
       //    System.out.print(driverName.findElement(by));
    }
}
