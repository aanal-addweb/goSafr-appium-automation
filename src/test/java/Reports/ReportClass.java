package Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.io.IOException;
import java.sql.SQLException;

public class ReportClass {
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest logger;

    @BeforeSuite
    public void initReport() throws SQLException
    {
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/report/goSafr_Report.html");
        extent = new ExtentReports ();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "goSafr");
        extent.setSystemInfo("Environment", "goSafr Automation");
        extent.setSystemInfo("User Name", "Aanal");
        htmlReporter.config().setDocumentTitle("goSafr Testcase");
        htmlReporter.config().setReportName("goSafr Test Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);
    }

    @AfterSuite
    public void tearDown() throws IOException {
        extent.flush();
    }
}
