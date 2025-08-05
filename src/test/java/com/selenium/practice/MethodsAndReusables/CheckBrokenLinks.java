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
        int responseCode = connectAndGetResponseCode(conn);
        if (responseCode == -1) throw new IOException(errorMessage);
        System.out.println("Response Code: " + responseCode);
        SeleniumTest.pass("Test Link Response Code: " + responseCode);

        //Get all links from footer and Validate all Links
        List<WebElement> allFooterLinksElement =driver.findElements(By.cssSelector("[id='gf-BIG'] li a"));
        //Xpath: //*[@id='gf-BIG']//descendant::li/a[@href]
        for (WebElement e : allFooterLinksElement) {
            SeleniumTest.info("----------------------------------------------");
            url = e.getDomAttribute("href");
            System.out.println("Link Fetched: " + url);
            assert url != null;
            SeleniumTest.info("Linked Text: " + e.getText());
            SeleniumTest.info("URL Fetched: " + url);
            if (url.toLowerCase().contains("https")) {
                HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                connection.setRequestMethod("HEAD");
                connection.connect();
                responseCode = connection.getResponseCode();
                System.out.println(responseCode);
                SeleniumTest.pass("Response Status Code: " + textColorGreen(String.valueOf(responseCode)));
                SeleniumTest.info("----------------------------------------------");
            } else if (url.toLowerCase().contains("http")) {
                responseCode = connectAndGetResponseCode(conn);
                System.out.println();
                SeleniumTest.info(textColorOrange("(Link has http Protocol) Response Code: " + textColorOrange(String.valueOf(responseCode))));
                SeleniumTest.info("----------------------------------------------");
            } else {
                System.out.println("URL has no Link: " + url + "Skipping...");
                SeleniumTest.log(Status.INFO, textColorOrange("URL has no Link: " + url + "Skipping..."));
                SeleniumTest.info("----------------------------------------------");
            }
        }

        closeBrowser(driver);

    }

    public static int connectAndGetResponseCode(HttpURLConnection conn) {
        try{
            conn.connect();
            return conn.getResponseCode();
        } catch (IOException e) {
            errorMessage = e.getMessage();
            return -1;
        }
    }
}
