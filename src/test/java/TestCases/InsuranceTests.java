package TestCases;

import Pages.InsuranceTest;
import net.sourceforge.tess4j.TesseractException;
import org.testng.annotations.Test;

import java.io.IOException;

public class InsuranceTests extends BaseCase{
    @Test(priority = 1)
    public void addInsurance() throws IOException, InterruptedException, TesseractException {
        logger = extent.createTest("Check if insurance product is added or not");
        InsuranceTest insuranceTest = new InsuranceTest(appiumDriver, logger);
        insuranceTest.AddInsurance();
    }
}
