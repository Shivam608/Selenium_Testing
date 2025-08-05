package com.selenium.practice.MethodsAndReusables;

import Utility.BaseTest;
import Utility.FrameworkConstants;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;


public class CheckBrokenLinks extends BaseTest {
    public static String errorMessage = "";

    @Test
    public void validateFooterBrokenLinks() throws IOException {

        SeleniumTest = extentReports.createTest("Validate Broken Links");
        WebDriver driver = initializeChromeDriverAndNavigateToUrl(FrameworkConstants.rsaAutomationWebsite);
        driver.manage().window().maximize();

        //Practice 1 Valid Link
        String url = driver.findElement(By.cssSelector("[id='gf-BIG'] a[href*='soapui']")).getDomAttribute("href");
        assert url != null;
//        url = url.replace("http", "https");
        SeleniumTest.info("Test Link: " + textColorGreen(url));
        System.out.println("URL Fetched: " + url);
        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        int responseCode = conn.getResponseCode();
        System.out.println("Response Code: " + responseCode);
        SeleniumTest.pass("Test Link Response Code: " + responseCode);

        //Get all links from footer and Validate all Links
        List<WebElement> allFooterLinksElement =driver.findElements(By.cssSelector("[id='gf-BIG'] li a"));
        SeleniumTest.info("----------------------------------------------");
        //Xpath: //*[@id='gf-BIG']//descendant::li/a[@href]
        for (WebElement e : allFooterLinksElement) {
            url = e.getDomAttribute("href");
            System.out.println("Link Fetched: " + url);
            assert url != null;
            SeleniumTest.info("Linked Text: " + e.getText());
            SeleniumTest.info("URL Fetched: " + url);
            HttpURLConnection connection;
            //Building URL Connection Properties
            if (url.toLowerCase().contains("https")) {
                connection = (HttpURLConnection) new URL(url).openConnection();
                connection.setRequestMethod("HEAD");
                connection.connect();
                responseCode = connection.getResponseCode();
                System.out.println(responseCode);
                checkFor200StatusCode(responseCode);
                SeleniumTest.info("----------------------------------------------");
            } else if (url.toLowerCase().contains("http")) {
                connection = (HttpURLConnection) new URL(url).openConnection();
                connection.setRequestMethod("HEAD");
                responseCode = connectAndGetResponseCode(connection);
                if (responseCode == -1) SeleniumTest.warning(textColorOrange("(Link has http Protocol) Response Code: " + textColorOrange(String.valueOf(responseCode)) + "Error Message: " + errorMessage));
                SeleniumTest.info("----------------------------------------------");
            } else {
                System.out.println("URL has no Link: " + url + "Skipping...");
                SeleniumTest.log(Status.WARNING, textColorOrange("URL has no Link: " + url + "Skipping..."));
                SeleniumTest.info("----------------------------------------------");
            }
        }

        //Close Current Browser
        driver.quit();

    }

    public int connectAndGetResponseCode(HttpURLConnection conn) {
        try{
            conn.connect();
            return conn.getResponseCode();
        } catch (IOException e) {
            errorMessage = e.getMessage();
            return -1;
        }
    }

    public void checkFor200StatusCode(int statusCode) {
        if (statusCode != 200) {
            SeleniumTest.fail(textColorRed("StatusCode: " + statusCode));
        } else SeleniumTest.pass("Response Status Code: " + textColorGreen(String.valueOf(statusCode)));

    }
}
