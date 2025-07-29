package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import static Utility.BaseTest.baseUri;

public class FrameworkUtilities implements CustomizedReportStatements{

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
        WebDriver driver = new ChromeDriver();
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
}
