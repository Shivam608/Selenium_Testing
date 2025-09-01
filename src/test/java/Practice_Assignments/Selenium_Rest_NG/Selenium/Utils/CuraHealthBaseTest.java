package Practice_Assignments.Selenium_Rest_NG.Selenium.Utils;

import Utility.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class CuraHealthBaseTest extends BaseTest {

    protected static WebDriver driver;

    @BeforeTest
    protected void setUpBrowserInstance() {
        SeleniumTest = extentReports.createTest("Navigate To URL and Click on Book Appointment");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
    }

    @Parameters("isBrowserClosed")
    @AfterTest
    protected void closeBrowser(String isBrowserClosed) {
        if (isBrowserClosed.contains("true")) {
            closeBrowser(driver);
        }
    }

    protected static WebDriver getDriver() {
        return driver;
    }

}
