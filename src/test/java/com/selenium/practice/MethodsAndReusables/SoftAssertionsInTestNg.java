package com.selenium.practice.MethodsAndReusables;

import Utility.BaseTest;
import Utility.FrameworkConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class SoftAssertionsInTestNg extends BaseTest {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get(FrameworkConstants.rsaAutomationWebsite);

        List<WebElement> element = driver.findElements(By.tagName("a"));
        System.out.println(element.size());

        SoftAssert softAssert = new SoftAssert();
        for (WebElement e: element) {
            String url = e.getDomAttribute("href");
            assert (url != null);
            System.out.println("URL: " + url);
            softAssert.assertTrue(url.toLowerCase().contains("https"), "Flaky URL: " + url);
        }

        softAssert.assertAll();
        driver.quit();
    }
}
