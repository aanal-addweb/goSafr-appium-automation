package Action;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;

public class VerificationClass {

    private static AppiumDriver appiumDriver;
    private static ExtentTest test;

    public VerificationClass(AppiumDriver appiumDriver, ExtentTest test) {
        this.appiumDriver = appiumDriver;
        this.test = test;
    }

    public void CompareString(String s, String s1)
    {
        try {
            s.trim();
            s1.trim();
            if(s.equals(s1)==true)
            {
                test.log(Status.INFO, "Expected text: " + s + " matches with actual text: " + s1);
                System.out.println("Expected text: " + s + " matches with actual text: " + s1);
            }
            else
            {
                System.out.println("Expected text: " + s + " does not match with actual text: " + s1);
                test.log(Status.FAIL, "Expected text: " + s + " does not match with actual text: " + s1);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            test.log(Status.FAIL,e.getMessage());
        }
    }
}
