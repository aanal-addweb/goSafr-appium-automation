package TestCases;

import Pages.LoginTest;
import net.sourceforge.tess4j.TesseractException;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTests extends BaseCase {

    @Test(priority = 1)
    public void checkSignUpPage() throws IOException, InterruptedException {
        logger = extent.createTest("Check if it redirects to Sign Up Page");
        LoginTest loginTest = new LoginTest(appiumDriver, logger);
        loginTest.CheckSignUpPage();
    }

    @Test(priority = 2)
    public void loginValidation() throws IOException, InterruptedException {
        logger = extent.createTest("Check if mandatory validations are thrown or not ");
        LoginTest loginTest = new LoginTest(appiumDriver, logger);
        loginTest.LoginValidation();
    }

    @Test(priority = 2)
    public void verifyToastMessage() throws IOException, InterruptedException, TesseractException {
        logger = extent.createTest("Check if ");
        LoginTest loginTest = new LoginTest(appiumDriver, logger);
        loginTest.VerifyToastMessage();
    }

    @Test(priority = 4)
    public void checkLogin() throws IOException, InterruptedException {
        logger = extent.createTest("Check if admin is logged in");
        LoginTest loginTest = new LoginTest(appiumDriver, logger);
        loginTest.CheckLogin();
    }
}
