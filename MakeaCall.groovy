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


def eml_contacts(){	
	println "Invoking Emulator device now"
	DesiredCapabilities capabilities = new DesiredCapabilities();

	capabilities.setCapability("deviceName", "Android");
	//capabilities.setCapability("deviceName", "emulator-5556");
	capabilities.setCapability("platformVersion", "7.0");
	capabilities.setCapability("platformName", "Android");

	capabilities.setCapability("appPackage","com.android.contacts");
	//capabilities.setCapability("appActivity","com.android.contacts.common.dialog.CallSubjectDialog");
    capabilities.setCapability("appActivity","com.android.contacts.activities.PeopleActivity");
   
    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);//this works
    println "before starting to wait"

    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    println "done.."
}
//invoke()
   
def mp_contacts(){	
	println "Invoking mobilephone now"
	DesiredCapabilities capabilities = new DesiredCapabilities();

	capabilities.setCapability("deviceName", "Android")
	capabilities.setCapability("platformVersion", "4.4.2")
	capabilities.setCapability("platformName", "Android")

    capabilities.setCapability("appPackage","com.asus.contacts")
    capabilities.setCapability("appActivity","com.android.contacts.activities.PeopleActivity");

    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);//this works
    println "before starting to wait"
   
    WebElement frameLayout = driver.findElement(By.className("android.widget.FrameLayout"));
    println "Got a Frame layout @@@@@@"
    println "Size is : " + frameLayout.getSize().toString()

    WebElement horizontalScrollView = frameLayout.findElement(By.className("android.widget.HorizontalScrollView"))
    println "Got a horizontalScrollView @@@@@@"
    println "Size is : " + horizontalScrollView?.getSize().toString()


    def linearLayout = horizontalScrollView.findElements(By.className("android.widget.LinearLayout"))
    println linearLayout.class.name + "!!!!!!!!!"
    linearLayout.each{ oneTab ->
    	println oneTab.class.name + "----" + oneTab.getSize().toString()
    	println oneTab.class.name + "----" + oneTab.getLocation().toString()

    }
  
    linearLayout[1].click();
    
    println "clicking Tab"

    WebElement linearLayout1 = driver.findElement(By.id("com.asus.contacts:id/dialpad_container"))
    println "Got a linearLayout1 #####"
    println "Size is: " + linearLayout1.getSize().toString()

    ['nine','five','nine'].each{
    	linearLayout1.findElement(By.id("com.asus.contacts:id/"+it)).click()	
    }
    /*linearLayout1.findElement(By.id("com.asus.contacts:id/nine")).click()
    linearLayout1.findElement(By.id("com.asus.contacts:id/eight")).click()
    linearLayout1.findElement(By.id("com.asus.contacts:id/four")).click()
    linearLayout1.findElement(By.id("com.asus.contacts:id/five")).click()
    linearLayout1.findElement(By.id("com.asus.contacts:id/one")).click()
    linearLayout1.findElement(By.id("com.asus.contacts:id/four")).click()
    linearLayout1.findElement(By.id("com.asus.contacts:id/eight")).click()
    linearLayout1.findElement(By.id("com.asus.contacts:id/three")).click()
    linearLayout1.findElement(By.id("com.asus.contacts:id/five")).click()
    linearLayout1.findElement(By.id("com.asus.contacts:id/one")).click()*/
   // linearLayout1.sendKeys('Rahul vivasa').click()

    driver.findElement(By.id("com.asus.contacts:id/dialButtonSim1")).click()

    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    println "done.."
}

def mp_settings(){	
	println "Invoking mobile settings now"
	DesiredCapabilities capabilities = new DesiredCapabilities();

	capabilities.setCapability("deviceName", "Android");
	capabilities.setCapability("platformVersion", "4.4.2");
	capabilities.setCapability("platformName", "Android");

    capabilities.setCapability("appPackage","com.facebook.katana")
    capabilities.setCapability("appActivity","com.facebook.katana.LoginActivity");

    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);//this works
    println "before starting to wait"
   
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    println "done.."
}

//eml_contacts()
//mp_contacts()
mp_settings()
