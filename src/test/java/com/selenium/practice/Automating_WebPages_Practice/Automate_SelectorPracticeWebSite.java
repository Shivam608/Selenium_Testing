package com.selenium.practice.Automating_WebPages_Practice;

import Utility.BaseTest;
import Utility.FrameworkConstants;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Objects;

/**
 * In this file I am Automating the Login and Resetting of Account using
 * Rahul Shetty Academy Practice portal for Selenium Locators
 */

public class Automate_SelectorPracticeWebSite extends BaseTest {

    @Test
    public void automateSelectorPracticeWebSite() throws InterruptedException {
        SeleniumTest = extentReports.createTest("Practice Set 1- Locator practice");

//        System.setProperty("webdriver.chrome.driver", "\"C:\\Users\\prono\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe\"");
        SeleniumTest.info("Starting Chrome Driver");
        ChromeDriver driver = new ChromeDriver();
        //Providing Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        //Go to URL
        SeleniumTest.info("Navigating to Website: " + FrameworkConstants.rsaSelectorWebsite);
        driver.get(FrameworkConstants.rsaSelectorWebsite);

        //WebElements for Future Use
        SeleniumTest.info("Sending UserName and Password");
        WebElement inputUserName = driver.findElement(By.id("inputUsername"));
        WebElement inputPassword = driver.findElement(By.name("inputPassword"));
        WebElement signInButton = driver.findElement(By.className("signInBtn"));

        String userName = "Pranay Kr";
        String password_Old = "123456790";
        String password_New;

        //Perform Actions
        inputUserName.sendKeys(userName);
        inputPassword.sendKeys(password_Old);
        signInButton.click();

        //CSS Selector for Text -> * Incorrect username or password
        WebElement errorElement = driver.findElement(By.cssSelector("p.error"));
        Assert.assertTrue(errorElement.isDisplayed(), "Unable to Find Web Element after Sending \"Incorrect Credentials\" ");
        String errorElementText = errorElement.getText();
        Assert.assertTrue(errorElementText.contains("Incorrect username"), "Validation Failed as String: \"Incorrect Credentials\" not Found");
        SeleniumTest.pass("Validation Success for Entering Wrong Username and Password");

        driver.findElement(By.linkText("Forgot your password?")).click();
//        String text = driver.findElement(By.cssSelector("a[href='#']")).getText();
//        System.out.println(text);
//        document.querySelectorAll("a[href='#']")   --> use this in dev tools console to get the list of elements

        //Parent to Child Traversing
//        String forgotPasswordString = driver.findElement(By.xpath("//form/h2[contains(text(), 'Forgot')]")).getText();
//        System.out.println(forgotPasswordString);

        //Sending new Name and Email and Phone Number
//        driver.findElement(By.xpath("//input[@type='text' and @placeholder='Name']")).sendKeys("Shivam_Kr");
//        driver.findElement(By.xpath("//input[@type='text' and @placeholder='Email']")).sendKeys("Shivam.Pranay@goole.com");
//        driver.findElement(By.xpath("//input[@type='text' and @placeholder='Phone Number']")).sendKeys("Shivam.Pranay@goole.com");
        // Using CSS Selector
        // driver.findElement(By.cssSelector("input[type='text'][placeholder='Phone Number']")).sendKeys("Shivam.Pranay@goole.com");

        // Alternate way using Parent to Child Traversing and using Contains
        SeleniumTest.log(Status.INFO, "Performing Reset To get new Password");
        driver.findElement(By.xpath("//form/input[@placeholder='Name']")).sendKeys(userName);
        driver.findElement(By.xpath("//form/input[contains(@placeholder , 'Email')]")).sendKeys("bose8092578175@orkut.com");
        driver.findElement(By.xpath("//form/input[3]")).sendKeys(password_Old); //Not recommended to User Index [3] or [2]

        //Click on Reset login and Press Go to LogIn
        Thread.sleep(1000);
        SeleniumTest.info("Click on Reset Password button");
        driver.findElement(By.xpath("//div/button[contains(@class, 'reset-pwd')]")).click();

        //Get the String for Password Reset Success
        SeleniumTest.log(Status.INFO, "Fetching New Password From Success Message String");
        String resetPassword = driver.findElement(By.xpath("//p[@class=\"infoMsg\"]")).getText();
        Assert.assertTrue((resetPassword.contains("password") && resetPassword.contains("to Login.")), "Failed to Match Expected String");
        SeleniumTest.log(Status.PASS, "Reset Password Success. Received Message: " + resetPassword);
        driver.findElement(By.xpath("//div[contains(@class, 'pwd-btn-conainer')]/button[contains(@class, 'go-to-login')]")).click();

        //Extract Password from String
        SeleniumTest.info("Extracting Password from String: " + resetPassword);
        String[] listOfString = resetPassword.split("'");
        password_New = listOfString[1];
        SeleniumTest.pass("Password Successfully Extracted: Password: " + password_New);

        //Enter Correct UserName and Password
        SeleniumTest.info("Sending Username: "+ userName +" & New Password: " + password_New);
        inputUserName.sendKeys(userName);
        inputPassword.sendKeys(password_New);
        Thread.sleep(1000);
        SeleniumTest.log(Status.INFO, "Clicking on SignIn with New Password");
        signInButton.click();

        //Validation For Login Success
        String getLoginSuccessText = driver.findElement(By.xpath("//div[contains(@class, \"login\")]//p[contains(text(), \"logged in.\")]")).getText();
        Assert.assertTrue(Objects.requireNonNull(driver.getPageSource()).contains(userName));
        Assert.assertTrue(getLoginSuccessText.contains("successfully logged"), "Unable to Validate login Success");
        SeleniumTest.pass("Logged in Successfully. Received Message: " + getLoginSuccessText);

        Thread.sleep(5000);
        driver.close();
    }
}
