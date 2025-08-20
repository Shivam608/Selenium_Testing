package com.selenium.practice.Assignments;

import Utility.BaseTest;
import Utility.FrameworkConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Assignment_7 extends BaseTest {
    private static final String country_Name_1 = "India";
    private static final String country_Name_2 = "United Arab Emirates";

    @Test
    public void autoSuggestiveDropDowns() {
        SeleniumTest = extentReports.createTest("Validate Auto-Suggestive Drop-down Lists");

        //Initialize WebDriver
        WebDriver driver = initializeChromeDriverAndNavigateToUrl(FrameworkConstants.rsaAutomationWebsite);

        //Select India from Drop down List by typing only ind
        driver.findElement(By.id("autocomplete")).sendKeys("ind");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id='ui-id-1'] li")));

        Actions cursor = new Actions(driver); ///Perform Actions
        cursor.moveToElement(driver.findElement(By.xpath("//*[@id='ui-id-1']//div[text()='"+ country_Name_1 + "']"))).click().build().perform();

        //Select United Arab Emeritus from Drop down List by typing only united
        driver.findElement(By.id("autocomplete")).clear();
        driver.findElement(By.id("autocomplete")).sendKeys("united");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id='ui-id-1'] li")));
        ///Perform Actions
        cursor.moveToElement(driver.findElement(By.xpath("//*[@id='ui-id-1']//div[text()='"+ country_Name_2 + "']"))).click().build().perform();

    }
}
