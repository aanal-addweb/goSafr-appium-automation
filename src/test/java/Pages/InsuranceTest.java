package Pages;

import Action.ActionClass;
import Action.ReadToastMessage;
import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.AppiumDriver;
import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class InsuranceTest {
    ExtentTest extentTest;
    AppiumDriver appiumDriver;

    public InsuranceTest(AppiumDriver appiumDriver, ExtentTest extentTest){
        this.appiumDriver = appiumDriver;
        this.extentTest = extentTest;
    }
    public void AddInsurance() throws IOException, InterruptedException, TesseractException {
        new WebDriverWait(appiumDriver, 60).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='INSURANCES']")));
        appiumDriver.findElement(By.xpath("//*[@text='INSURANCES']")).click();
        ActionClass actionClass = new ActionClass(appiumDriver, extentTest);
        new WebDriverWait(appiumDriver, 60).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Add']")));
        appiumDriver.findElement(By.xpath("//*[@text='Add']")).click();
        new WebDriverWait(appiumDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.widget.ScrollView']]]]]]/*/*[@class='android.widget.ImageView' and ./parent::*[@class='android.view.ViewGroup']])[1]")));
        actionClass.screenCapture("AddInsurance_1");
        appiumDriver.findElement(By.xpath("(//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup' and ./parent::*[@class='android.widget.ScrollView']]]]]]/*/*[@class='android.widget.ImageView' and ./parent::*[@class='android.view.ViewGroup']])[1]")).click();
        new WebDriverWait(appiumDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Add' and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@text='test_product']]]")));
        actionClass.screenCapture("AddInsurance_2");
        appiumDriver.findElement(By.xpath("//*[@text='Add' and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@text='test_product']]]")).click();
        new WebDriverWait(appiumDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.widget.ScrollView']]/*[@class='android.widget.EditText'])[1]")));
        appiumDriver.findElement(By.xpath("(//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.widget.ScrollView']]/*[@class='android.widget.EditText'])[1]")).click();
        appiumDriver.findElement(By.xpath("(//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.widget.ScrollView']]/*[@class='android.widget.EditText'])[1]")).sendKeys("riddhi");
        appiumDriver.findElement(By.xpath("(//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.widget.ScrollView']]/*[@class='android.widget.EditText'])[2]")).click();
        appiumDriver.findElement(By.xpath("(//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.widget.ScrollView']]/*[@class='android.widget.EditText'])[2]")).sendKeys("123");
        actionClass.screenCapture("AddInsurance_3");
        new WebDriverWait(appiumDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Submit']")));
        appiumDriver.findElement(By.xpath("//*[@text='Submit']")).click();
        Thread.sleep(2000);
        ReadToastMessage readToastMessage = new ReadToastMessage(appiumDriver, extentTest);
        readToastMessage.takeScreenShot();
        readToastMessage.readToastMessage("Insurance detail added successfully");
    }
}
