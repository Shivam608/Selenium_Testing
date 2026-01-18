package Practice_Assignments.Selenium_Rest_NG.Selenium_1;

import Utility.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class PracticeXpathsAmazon_1 extends BaseTest {

    WebDriver driver;
    @BeforeClass
    @Parameters("Driver")
    public void beforeTest(@Optional("chrome") String Driver) {

        switch (Driver.toLowerCase()) {
            case "chrome" : driver = new ChromeDriver();
            break;

            case "edge" : driver = new EdgeDriver();
            break;

            case "safari" : driver = new SafariDriver();
            break;

            default: driver = new ChromeDriver();
        }
    }

    @Test
    public void Test_1() {

        SeleniumTest = extentReports.createTest("Test 2");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(2));

        driver.get("https://www.amazon.in/");
        WebElement searchBoxElement = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='twotabsearchtextbox']")));

        Actions actions = new Actions(driver);
        actions.moveToElement(searchBoxElement).click().sendKeys("MacBooks with Intel").build().perform();
        actions.sendKeys(Keys.ENTER).build().perform();


    }
}
