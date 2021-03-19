package Pages;

import Action.ActionClass;
import Action.ReadToastMessage;
import Action.VerificationClass;
import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import net.sourceforge.tess4j.TesseractException;
import org.aspectj.weaver.ast.And;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class LoginTest {
    ExtentTest extentTest;
    AppiumDriver appiumDriver;
    AndroidDriver driver;

    public LoginTest(AppiumDriver appiumDriver, ExtentTest extentTest){
        this.appiumDriver = appiumDriver;
        this.extentTest = extentTest;
//        this.driver = driver;
    }

    public void CheckSignUpPage() throws IOException {
        new WebDriverWait(appiumDriver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='GET STARTED']")));
        appiumDriver.findElement(By.xpath("//*[@text='GET STARTED']")).click();
        new WebDriverWait(appiumDriver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='SIGN UP WITH PHONE']")));
        String bodyText = appiumDriver.findElement(By.xpath("//*[@text='SIGN UP WITH PHONE']")).getText();
        VerificationClass verificationClass = new VerificationClass(appiumDriver, extentTest);
        verificationClass.CompareString(bodyText, "SIGN UP WITH PHONE");
        ActionClass actionClass = new ActionClass(appiumDriver, extentTest);
        actionClass.screenCapture("Sign_Up_Page");
    }

    public void LoginValidation() throws IOException {
        new WebDriverWait(appiumDriver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Sign Up']")));
//        appiumDriver.findElement(By.xpath("//*[@text='GET STARTED']")).click();
        new WebDriverWait(appiumDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Sign Up']")));
        appiumDriver.findElement(By.xpath("//*[@text='Sign Up']")).click();
        new WebDriverWait(appiumDriver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Phone number is a required field']")));
        String validation1 = appiumDriver.findElement(By.xpath("//*[@text='Phone number is a required field']")).getText();
        System.out.println(validation1);
        VerificationClass verificationClass = new VerificationClass(appiumDriver, extentTest);
        verificationClass.CompareString(validation1, "Phone number is a required field");
        new WebDriverWait(appiumDriver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Password is a required field']")));
        String validation2 = appiumDriver.findElement(By.xpath("//*[@text='Password is a required field']")).getText();
        System.out.println(validation2);
        verificationClass.CompareString(validation2, "Password is a required field");
        ActionClass actionClass = new ActionClass(appiumDriver, extentTest);
        actionClass.screenCapture("Sign_Up_Validation");
    }

    public void VerifyToastMessage() throws TesseractException, InterruptedException {
        new WebDriverWait(appiumDriver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("((//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup'] and (./preceding-sibling::* | ./following-sibling::*)[@class='android.view.ViewGroup']]]]]]]/*[@class='android.view.ViewGroup'])[2]/*[@class='android.widget.EditText'])[1]")));
        appiumDriver.findElement(By.xpath("((//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup'] and (./preceding-sibling::* | ./following-sibling::*)[@class='android.view.ViewGroup']]]]]]]/*[@class='android.view.ViewGroup'])[2]/*[@class='android.widget.EditText'])[1]")).sendKeys("123456");
        new WebDriverWait(appiumDriver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("((//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup'] and (./preceding-sibling::* | ./following-sibling::*)[@class='android.view.ViewGroup']]]]]]]/*[@class='android.view.ViewGroup'])[2]/*[@class='android.widget.EditText'])[2]")));
        appiumDriver.findElement(By.xpath("((//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup'] and (./preceding-sibling::* | ./following-sibling::*)[@class='android.view.ViewGroup']]]]]]]/*[@class='android.view.ViewGroup'])[2]/*[@class='android.widget.EditText'])[2]")).sendKeys("yodudg");
        new WebDriverWait(appiumDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Sign Up']")));
        appiumDriver.findElement(By.xpath("//*[@text='Sign Up']")).click();
        Thread.sleep(2000);
        ReadToastMessage readToastMessage = new ReadToastMessage(appiumDriver, extentTest);
        readToastMessage.takeScreenShot();
        readToastMessage.readToastMessage("Password did not confirm with policy");
    }

    public void ReadOTP() throws InterruptedException {
        new WebDriverWait(appiumDriver, 40).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='android.widget.EditText' and (./preceding-sibling::* | ./following-sibling::*)[./*[@text='Phone']]]")));
        appiumDriver.findElement(By.xpath("//*[@class='android.widget.EditText' and (./preceding-sibling::* | ./following-sibling::*)[./*[@text='Phone']]]")).clear();
        appiumDriver.findElement(By.xpath("//*[@class='android.widget.EditText' and (./preceding-sibling::* | ./following-sibling::*)[./*[@text='Phone']]]")).sendKeys("8347225834");
        new WebDriverWait(appiumDriver, 40).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='android.widget.EditText' and (./preceding-sibling::* | ./following-sibling::*)[./*[@text='Select your new password']]]")));
        appiumDriver.findElement(By.xpath("//*[@class='android.widget.EditText' and (./preceding-sibling::* | ./following-sibling::*)[./*[@text='Select your new password']]]")).clear();
        appiumDriver.findElement(By.xpath("//*[@class='android.widget.EditText' and (./preceding-sibling::* | ./following-sibling::*)[./*[@text='Select your new password']]]")).sendKeys("addweb123");
        new WebDriverWait(appiumDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Sign Up']")));
        appiumDriver.findElement(By.xpath("//*[@text='Sign Up']")).click();
        Thread.sleep(5000);
        appiumDriver.executeScript("mobile: getNotifications");
        Map<String, Object> res = (Map<String, Object>)appiumDriver.executeScript("mobile: getNotifications");
        List<Map<String, Object>> notifications = (List<Map<String, Object>>)res.get("statusBarNotifications");
        for (Map<String, Object> notification : notifications) {
            Map<String, String> innerNotification = (Map<String, String>)notification.get("notification");
            if (innerNotification.get("bigTitle") != null) {
                System.out.println(innerNotification.get("bigTitle"));
            } else {
                System.out.println(innerNotification.get("title"));
            }
            if (innerNotification.get("bigText") != null) {
                System.out.println(innerNotification.get("bigText"));
            } else {
                System.out.println(innerNotification.get("text"));
            }
        }
    }

    public void CheckLogin() throws IOException {
        new WebDriverWait(appiumDriver, 40).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='android.widget.EditText' and (./preceding-sibling::* | ./following-sibling::*)[./*[@text='Phone']]]")));
        appiumDriver.findElement(By.xpath("//*[@class='android.widget.EditText' and (./preceding-sibling::* | ./following-sibling::*)[./*[@text='Phone']]]")).clear();
        appiumDriver.findElement(By.xpath("//*[@class='android.widget.EditText' and (./preceding-sibling::* | ./following-sibling::*)[./*[@text='Phone']]]")).sendKeys("9978123516");
        new WebDriverWait(appiumDriver, 40).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='android.widget.EditText' and (./preceding-sibling::* | ./following-sibling::*)[./*[@text='Select your new password']]]")));
        appiumDriver.findElement(By.xpath("//*[@class='android.widget.EditText' and (./preceding-sibling::* | ./following-sibling::*)[./*[@text='Select your new password']]]")).clear();
        appiumDriver.findElement(By.xpath("//*[@class='android.widget.EditText' and (./preceding-sibling::* | ./following-sibling::*)[./*[@text='Select your new password']]]")).sendKeys("@1239998");
        new WebDriverWait(appiumDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Sign Up']")));
        appiumDriver.findElement(By.xpath("//*[@text='Sign Up']")).click();
        new WebDriverWait(appiumDriver, 60).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='MY JOURNEYS']")));
        String journeys = appiumDriver.findElement(By.xpath("//*[@text='MY JOURNEYS']")).getText();
        VerificationClass verificationClass = new VerificationClass(appiumDriver, extentTest);
        verificationClass.CompareString(journeys, "MY JOURNEYS");
        ActionClass actionClass = new ActionClass(appiumDriver, extentTest);
        actionClass.screenCapture("Login_Page");
    }
}