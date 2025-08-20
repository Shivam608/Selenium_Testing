package Utility;

import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.springframework.util.FileCopyUtils;
import org.testng.Assert;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import static Utility.BaseTest.*;

public class FrameworkUtilities {

    WebDriver driver;

    //get Base URI from Config.properties
    public static String getBaseUri() {
        if (baseUri.isEmpty()) {
            try {
                FileReader reader = new FileReader(System.getProperty("user.dir") + "\\src\\main\\resources\\application.properties");
                Properties prop = new Properties();
                prop.load(reader);
                baseUri = prop.getProperty("RestAssured_BaseURI").replace("\"", "");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            return baseUri;
        }
        return baseUri;
    }

    //get Any Value from Application.properties
    public static String getValueFromProperties(String key) throws IOException {
        FileReader reader = new FileReader(System.getProperty("user.dir") + "\\src\\main\\resources\\application.properties");
        Properties prop = new Properties();
        prop.load(reader);
        String value = prop.getProperty(key);
        Assert.assertNotNull(value, "No Such Key: " + key);
        System.out.println("Key: " + key + ", Value: " + value);
        return (String) value;
    }

    public static boolean isVisible(WebDriver driver, By xpath) {
        List<WebElement> elements = driver.findElements(xpath);
        for (WebElement e : elements) {
            if (e.isDisplayed()) {
                System.out.println("Element Found");
                return true;
            } else System.out.println("Element not found");
        } return false;
    }

    public static WebDriver initializeChromeDriverAndNavigateToUrl(String... url) {
        String baseUri = url.length != 0 ? url[0] : "https://www.google.com/";
        if (SeleniumTest != null && extentReports != null) {
            SeleniumTest.info("Navigating to URL: " + baseUri);
        }
        WebDriver driver = new ChromeDriver();
        driver.get(baseUri);
        return driver;
    }

    public static WebDriver initializeEdgeBrowserAndNavigateToUrl(String... url) {
        String baseUri = url.length != 0 ? url[0] : "https://www.google.com/";
        if (SeleniumTest != null && extentReports != null) {
            SeleniumTest.info("Navigating to URL: " + baseUri);
        }
        WebDriver driver = new EdgeDriver();
        driver.get(baseUri);
        return driver;
    }

    public void clickOnElementFromList(WebDriver driver, By xpathExpression, String searchText) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        List<WebElement> listOfElements = driver.findElements(xpathExpression);
        for(WebElement e : listOfElements) {
            Assert.assertTrue(searchText.length()>1, "Not a valid Input Text");
            Assert.assertTrue(e.getText().length()>1, "Get text returned an empty String");
            if (e.getText().contains(searchText)) {
                e.click();
                break;
            }
        }
    }

    public enum ScreenShotType {
        FULL("FULL"),
        PARTIAL("PARTIAL");

        private ScreenShotType(String text) {
        }
    }

    public static String getScreenShotPath(ScreenShotType screenShotType) {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd_MM_yyyy-HH_mm");
        return System.getProperty("user.dir") + "\\ScreenShots\\" + screenShotType + "_ScreenShot_" +  format.format(date) + ".png";
    }

    public void takeFullScreenShot(WebDriver driver) throws IOException {
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileCopyUtils.copy(src, new File(getScreenShotPath(ScreenShotType.FULL)));
    }

    public void takePartialScreenShot(WebElement element) throws IOException {
        File src = element.getScreenshotAs(OutputType.FILE);
        FileCopyUtils.copy(src, new File(getScreenShotPath(ScreenShotType.PARTIAL)));
    }
}
