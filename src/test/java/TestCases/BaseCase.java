package TestCases;

import Reports.ReportClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseCase extends ReportClass {

    static AppiumDriver<MobileElement> appiumDriver;
    @BeforeTest
    public void setup() throws MalformedURLException {
        try {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AC2001");
            //desiredCapabilities.setCapability("deviceName", "AC2001");
            desiredCapabilities.setCapability(MobileCapabilityType.UDID, "372453d0");
            //desiredCapabilities.setCapability("udid", "372453d0");
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            //desiredCapabilities.setCapability("platformName", "Android");
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
            //desiredCapabilities.setCapability("platformVersion", "10");
            desiredCapabilities.setCapability("appPackage", "com.gosafr");
//            desiredCapabilities.setCapability("appPackage", "com.google.android.calculator");
            desiredCapabilities.setCapability("appActivity", "com.gosafr.MainActivity");

            URL url = new URL("http://127.0.0.1:4723/wd/hub");

            appiumDriver = new AppiumDriver<MobileElement>(url, desiredCapabilities);
//            appiumDriver = new AndroidDriver<MobileElement>(url, desiredCapabilities);
//            appiumDriver = new IOSDriver<MobileElement>(url, desiredCapabilities);
            System.out.println("App started .....");

            WebDriverWait wait = new WebDriverWait(appiumDriver, 20);
            wait.until(ExpectedConditions.alertIsPresent());
            appiumDriver.switchTo().alert().accept();

        }catch (Exception e){
            System.out.printf("Cause is: "+e.getCause());
            System.out.printf("Message is: "+e.getMessage());
            e.printStackTrace();
        }
    }

//    @AfterTest
//    public void teardown(){
//        appiumDriver.quit();
//    }
}
