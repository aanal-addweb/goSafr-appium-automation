package TestCases;

import Pages.InsuranceTest;
import Pages.LoginTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class InsuranceTests extends BaseCase{
    @Test(priority = 1)
    public void addInsurance() throws IOException, InterruptedException {
        logger = extent.createTest("Check if insurance product is added or not");
        InsuranceTest insuranceTest = new InsuranceTest(appiumDriver, logger);
        insuranceTest.AddInsurance();
    }
}
