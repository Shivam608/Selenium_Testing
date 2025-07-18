package Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public abstract class BaseTest {
    public static ExtentSparkReporter sparkReporter;
    public static ExtentReports extentReports;
    public static ExtentTest SeleniumTest;

    @BeforeSuite(alwaysRun = true)
    public void extentReport() {
        if (extentReports == null) {
            extentReports = createInstance();
        }
    }

    public ExtentReports createInstance() {
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("d MMM uuuu")).replace(" ", "_");
        String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH mm ss")).replace(" ", "_");

        String ReportFileLocation = System.getProperty("user.dir") + "/Reports/SeleniumReports_" + date + "_IST_" + time + ".html";
        sparkReporter = new ExtentSparkReporter(ReportFileLocation);
        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setDocumentTitle("Selenium/TestNG Automation");
        sparkReporter.config().setEncoding("utf-8");
        sparkReporter.config().setReportName("Selenium/TestNG Automation");

        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        extentReports.setSystemInfo("Selenium/TestNG", "Pranay_Kr_Bose");
        return extentReports;
    }

    @AfterSuite(alwaysRun = true)
    public void tearDownExtentReport() {
        if (extentReports != null) {
            extentReports.flush();
        }
    }


}
