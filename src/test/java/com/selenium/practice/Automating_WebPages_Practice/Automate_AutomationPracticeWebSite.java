package com.selenium.practice.Automating_WebPages_Practice;

import Utility.BaseTest;
import Utility.FrameworkConstants;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Objects;

public class Automate_AutomationPracticeWebSite extends BaseTest {

    @Test(description = "", groups = "TestNG")
    public void automate_AutomationPracticeWebsite() throws InterruptedException {

        SeleniumTest = extentReports.createTest("Practice Set 2- Automate Website practice");

        //Setting up WebDriver
        WebDriver driver = new ChromeDriver();

        //Set Implicit wait of 5 Seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Navigating to WebSite
        SeleniumTest.log(Status.INFO, "Navigating To WebSite: " + FrameworkConstants.rsaAutomationWebsite);
        driver.get(FrameworkConstants.rsaAutomationWebsite);
        Assert.assertTrue(Objects.requireNonNull(driver.getTitle()).contains("Practice"), "Website Title Not Matched. Received Title: "+ driver.getTitle());
        SeleniumTest.log(Status.PASS, "Navigation to Website Success: " + driver.getTitle());

        //Navigate to Log in Button and Click
        WebElement loginElement = driver.findElement(By.xpath("//div/button[contains(text(), 'Practice')]/following-sibling::button[text()='Login']"));
        String loginText = loginElement.getText();
        Assert.assertEquals(loginText, "Login", "Unable to Match. Received Text: " + loginText);
        SeleniumTest.log(Status.PASS, "Login Text/Button Validated Successfully. Received Text: " + textColor("pappu", loginText));

        SeleniumTest.log(Status.INFO, "Get Blinking Text from WebSite");
        WebElement blinkingTextElement = driver.findElement(By.xpath("//button[contains(text(),'Practice')]//parent::div//parent::header/a[contains(@class,'blinking')]"));
        String blikingText = blinkingTextElement.getText();
        Assert.assertTrue(Objects.requireNonNull(blikingText).contains("Free Access to Interview"));
        SeleniumTest.log(Status.PASS, "Blinking Text validated Successfully. Received Text: " + textColorGreen(blikingText));

        Thread.sleep(5000);
        driver.close();

    }
}
