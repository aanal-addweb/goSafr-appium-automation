package Pages;

import Action.ActionClass;
import Action.VerificationClass;
import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;

public class LoginTest {
    ExtentTest extentTest;
    AppiumDriver appiumDriver;

    public LoginTest(AppiumDriver appiumDriver, ExtentTest extentTest){
        this.appiumDriver = appiumDriver;
        this.extentTest = extentTest;
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

    public void CheckLogin() throws IOException {
        new WebDriverWait(appiumDriver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("((//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup'] and (./preceding-sibling::* | ./following-sibling::*)[@class='android.view.ViewGroup']]]]]]]/*[@class='android.view.ViewGroup'])[2]/*[@class='android.widget.EditText'])[1]")));
        appiumDriver.findElement(By.xpath("((//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup'] and (./preceding-sibling::* | ./following-sibling::*)[@class='android.view.ViewGroup']]]]]]]/*[@class='android.view.ViewGroup'])[2]/*[@class='android.widget.EditText'])[1]")).sendKeys("9978123516");
        new WebDriverWait(appiumDriver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("((//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup'] and (./preceding-sibling::* | ./following-sibling::*)[@class='android.view.ViewGroup']]]]]]]/*[@class='android.view.ViewGroup'])[2]/*[@class='android.widget.EditText'])[2]")));
        appiumDriver.findElement(By.xpath("((//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup'] and (./preceding-sibling::* | ./following-sibling::*)[@class='android.view.ViewGroup']]]]]]]/*[@class='android.view.ViewGroup'])[2]/*[@class='android.widget.EditText'])[2]")).sendKeys("@1239998");
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
