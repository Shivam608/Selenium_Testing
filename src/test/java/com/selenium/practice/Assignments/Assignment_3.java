package com.selenium.practice.Assignments;

import Components.HerokuAppLinks;
import Utility.FrameworkConstants;
import Utility.XpathStore;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class Assignment_3 extends HerokuAppLinks {
    public static final String url = FrameworkConstants.herokuApp;
    @Test
    public void assignment_3_MultipleWindows() {


        //Create Test Instance and Navigate To URL using Chrome
        SeleniumTest = extentReports.createTest("Assignment 3 -> Practice Multiple Windows");
        SeleniumTest.info("Initializing Chrome and Navigating to URL: " + url);
        WebDriver driver = initializeChromeDriverAndNavigateToUrl(url);

        //Navigate to Multiple Windows Practice Link
        SeleniumTest.info("Select Option: " + Multiple_Windows);
        clickOnElementFromList(driver, XpathStore.allLinksElementList_locator, Multiple_Windows);

        //Validate WebElement for confirmation
        WebElement multipleWindowsTitle = driver.findElement(By.cssSelector("[class='example'] h3"));
        Assert.assertEquals(multipleWindowsTitle.getText(), "Opening a new window", textColorRed("Failed to Locate Text: 'Opening a new window'"));
        SeleniumTest.pass(textColorGreen("Clicked on Option: " + Multiple_Windows));

        //Click on web element to open New Window
        SeleniumTest.info("Opening New Window");
        driver.findElement(By.cssSelector("div[class='example'] a[target='_blank']")).click();

        //Fetching the number of Tabs Open
        SeleniumTest.info("Fetching Window Handles");
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        String parentWindow = iterator.next();
        String childWindow = iterator.next();
        SeleniumTest.info("Total Tabs fetched:  " + windows.size());

        //Switch Driver to Child Window
        driver.switchTo().window(childWindow);
        Assert.assertEquals(driver.getTitle(), "New Window", "Failed To Navigate To Child Window");
        SeleniumTest.pass("Navigated to Child Window, Title Fetched: " + driver.getTitle());

        //Validate Elements in Child Window
        SeleniumTest.info("Fetching Text from Child Window");
        String textFromNewWindow = driver.findElement(By.cssSelector("h3")).getText();
        Assert.assertEquals(textFromNewWindow, "New Window", "Failed to Validate Text form New Window");
        SeleniumTest.pass(textColorGreen("Fetched Text From Child Window: " + textFromNewWindow));

        SeleniumTest.info("Switching back to Parent Window");
        driver.switchTo().window(parentWindow);
        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='example'] h3")).getText(), "Opening a new window", "Failed To Validate Text from Previous Window");
        SeleniumTest.info("Parent Window Text Validation Success");
        SeleniumTest.log(Status.PASS, backgroundColorGreen("TEST SUCCESS"));

        //closing Browser
        closeBrowser(driver);

    }
}
