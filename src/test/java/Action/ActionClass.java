package Action;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ActionClass {

    private static AppiumDriver appiumDriver;
    private static ExtentTest test;
    public String screenshotPath;

    public ActionClass(AppiumDriver appiumDriver, ExtentTest test) {
        this.appiumDriver = appiumDriver;
        this.test = test;
    }

    public Object screenCapture(String testcaseName) throws IOException {
        // report with snapshot
        DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_MM_SS");
        Date date = new Date();
        String datetextName = dateFormat.format(date);
        File sourceFile = ((TakesScreenshot) appiumDriver).getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(System.getProperty("user.dir") + "/test-output/screenshot/" +testcaseName + "_"+datetextName + ".png");
        FileUtils.copyFile(sourceFile,destinationFile);
        String[] relatvePath = destinationFile.toString().split("/test-output");
        screenshotPath = ".." + relatvePath[1];
        test.log(Status.INFO, testcaseName, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        return test;
    }
}
