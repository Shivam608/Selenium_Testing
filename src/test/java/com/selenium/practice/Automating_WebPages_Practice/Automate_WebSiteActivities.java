package com.selenium.practice.Automating_WebPages_Practice;

import Utility.BaseTest;
import Utility.FrameworkConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Automate_WebSiteActivities extends BaseTest {

    @Test
    public void automate_WebSiteActivities() {
        initializeExtentTest();
        WebDriver driver = new ChromeDriver();

        //Adding Implicit Wait all activities done by WebDriver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        //Perform Website Navigation Activities
        driver.get(FrameworkConstants.rsaSelectorWebsite);
        driver.navigate().to(FrameworkConstants.rsaAutomationWebsite);

        //Perform Back and Forth

        //Closing Driver
        driver.quit();
    }
}
