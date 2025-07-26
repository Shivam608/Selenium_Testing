package com.selenium.practice.Assignments;

import Components.LoginPagePractice_Configurations;
import Utility.FrameworkConstants;
import Utility.XpathStore;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Objects;

public class Assignment_2 extends LoginPagePractice_Configurations {

    @Test
    public void loginPagePractice() {

        SeleniumTest = extentReports.createTest("RSA Practice Assignment 2");
        SeleniumTest.info("Starting Test To Automate RSA Login Practice Website as Assignment 2");

        //Launch URL
        WebDriver driver = new ChromeDriver();
        SeleniumTest.info("Opening Browser and Navigating to Website" + FrameworkConstants.rsaAssignment2_LoginPagePractice);
        driver.get(FrameworkConstants.rsaAssignment2_LoginPagePractice);
        driver.manage().window().maximize();
        Assert.assertTrue(Objects.requireNonNull(driver.getTitle()).contains("LoginPage Practise"), "Failed to Validate login Page Title. Title Received: " + driver.getTitle());
        SeleniumTest.pass("Validated WebSite Title Successfully. Title: " + textColorGreen(driver.getTitle()));

        //Get UserName and Password
        SeleniumTest.info("Entering Username and password");
        String text = driver.findElement(XpathStore.getUserNamePasswordString).getText();
        SeleniumTest.info("Extracting Username and Password from Line: " + text);
        String[] credentials = extractUserNameAndPassword(driver, text);
        SeleniumTest.info("Entering Username: " + textColorGreen(credentials[0]) + " and Password: " + textColorGreen(credentials[1]));
        driver.findElement(XpathStore.username_loginPage).sendKeys(credentials[0].trim());
        driver.findElement(XpathStore.password_loginPage).sendKeys(credentials[1]);
        SeleniumTest.pass("Credentials Entered Successfully");

        //Selecting User checkbox
        SeleniumTest.info("Selecting Account Type as User");
        selectAccountType(driver, String.valueOf(userAccountTypes.User));
        WebDriverWait explicWebDriverWait = new WebDriverWait(driver, Duration.ofSeconds(2));
        explicWebDriverWait.until(ExpectedConditions.visibilityOfElementLocated(XpathStore.popupUserType_loginPage));
        driver.findElement(XpathStore.popupOk_loginPage).click();
        SeleniumTest.pass("Successfully Selected Account Type as User");

        //Selecting User Type as Student
        SeleniumTest.info("Selecting User Account Type as Consultant");
        WebElement element = driver.findElement(XpathStore.selectUserType_loginPage);
        Select selectUserType = new Select(element);
        selectUserType.selectByVisibleText(String.valueOf(userTypes.Consultant));
        SeleniumTest.pass("Successfully Selected User Account Type as Consultant");

        //Selecting TOS
        SeleniumTest.info("Accepting TOS and Click on Sign In");
        driver.findElement(XpathStore.checkboxTOS_loginPage).click();

        //Clicking on SignIn
        driver.findElement(XpathStore.signInButton_loginPage).click();
        WebElement alertLoginErrorElement = driver.findElement(By.className("alert-danger"));
        String errorTextStyle = alertLoginErrorElement.getDomAttribute("style");
        String errorText = alertLoginErrorElement.getText();
        Assert.assertNotEquals(errorTextStyle, "display: block;", "Error: " + errorText);
        SeleniumTest.pass("Successfully clicked on Signed In");

        //Adding to cart all available Products
        SeleniumTest.info("Adding all items available into Cart");
        HashMap<String, Integer> listOfItemsAvailable= addAllProductsToCart(driver);
        SeleniumTest.log(Status.INFO, "List of Products: " + listOfItemsAvailable);
        String cartElementText = driver.findElement(XpathStore.intCartItems_loginPage).getText().trim().replaceAll("[^0-9]", "");
        Assert.assertEquals(listOfItemsAvailable.size(), Integer.parseInt(cartElementText), "Mis match in cart Items");
        SeleniumTest.pass("Successfully Added all Items to Cart. Total Items in Cart: " + cartElementText);

        closeBrowser(driver);
    }
}
