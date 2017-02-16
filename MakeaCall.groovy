@Grab(group='io.appium', module='java-client', version='2.1.0')
//@Grab(group='com.android.support.test.uiautomator', module='uiautomator-v18', version='2.1.2')
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;
import java.util.List;

//https://wiki.saucelabs.com/display/DOCS/Java+Example+Script+for+Android+Mobile+Application+Tests

AppiumDriver driver;


def invoke(){	
	println "Invoking now"
	DesiredCapabilities capabilities = new DesiredCapabilities();

	capabilities.setCapability("deviceName", "Android");
	//capabilities.setCapability("deviceName", "emulator-5556");
	capabilities.setCapability("platformVersion", "7.0");
	capabilities.setCapability("platformName", "Android");

	//list of packages: http://stackoverflow.com/questions/34769002/how-to-fetch-package-name-and-launcher-activity-from-android-apk
	//capabilities.setCapability("androidPackage", "com.android.contacts");
	//capabilities.setCapability("appPackage","com.android.launcher3");
   //capabilities.setCapability("appClass","android.widget.TextView");
	
	
//contacts.apk downloaded here
	capabilities.setCapability("appPackage","com.android.contacts");
	capabilities.setCapability("appActivity","com.android.contacts.common.dialog.CallSubjectDialog");
	
    /*capabilities.setCapability("appActivity","com.android.contacts.activities.PeopleActivity");
    */

    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);//this works
    println "before starting to wait"

   // driver.findElement(By.id("com.android.messaging:id/android.widget.TextView")).click();
    
    driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
    println "done.."
}

invoke()
