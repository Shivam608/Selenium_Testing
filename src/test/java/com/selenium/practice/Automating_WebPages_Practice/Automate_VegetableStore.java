package com.selenium.practice.Automating_WebPages_Practice;

import Components.GreenKartConfigurations;
import Components.GreenKartProducts;
import Utility.FrameworkConstants;
import Utility.XpathStore;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.*;

public class Automate_VegetableStore extends GreenKartConfigurations {
    public static final String promoCode = "rahulshettyacademy";

    @Test
    public void automate_VegetableMarket() {

        SeleniumTest = extentReports.createTest("Add Vegetables to Cart and perform Checkout");

        //Create Web Driver Instance
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0)); //Implicit wait
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5)); //Explicit Wait

        //Navigating to Browser and Verifying Title Text
        SeleniumTest.log(Status.INFO, "Navigating to Browser: " + FrameworkConstants.rsaGreenKart);
        driver.get(FrameworkConstants.rsaGreenKart);
        Assert.assertEquals(driver.getTitle(), "GreenKart - veg and fruits kart", textColorRed("Failed to Validate Page Title"));
        SeleniumTest.pass("Title Validation Success" + textColorGreen(driver.getTitle()));
        driver.manage().window().maximize();

        //Zooming Out the Page to get all Elements Together in one Screen
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("document.body.style.zoom = '0.2'");

        //Consolidating List of Products to be added into a List<String> getList
        List<String> list = getList();
        TreeMap<String, Integer> listOfItemsInCart = addProductsToCart(driver, list);
        SeleniumTest.log(Status.INFO, "List of Items in Cart: " + listOfItemsInCart);
        Assert.assertEquals(driver.findElement(XpathStore.getTotalNumberOfItemsElement).getText(), String.valueOf(listOfItemsInCart.size()), "Mis Match in Total Items added in Cart");
        SeleniumTest.log(Status.PASS, textColorGreen("Successfully added all Products into Cart. Total Items: " + textColorOrange(String.valueOf(listOfItemsInCart.size()))));

        //Navigate to Checkout
        SeleniumTest.info("Navigating to Checkout");
        driver.findElement(XpathStore.cartElementVegetableSore).click();
        driver.findElement(XpathStore.proceedToCheckOutElement).click();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(XpathStore.discountedAmountLocator));
        int amtBeforeDiscount = Integer.parseInt(driver.findElement(XpathStore.discountedAmountLocator).getText());

        //Adding Explicit Waits
        SeleniumTest.log(Status.INFO, "Applying Promo Code: " + promoCode);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(XpathStore.enterPromoCodeElement));
        driver.findElement(XpathStore.enterPromoCodeElement).sendKeys(promoCode);
        driver.findElement(By.className("promoBtn")).click();

        //Wait until Promo Code is Applied Successfully and Discount is Calculated
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(XpathStore.promoInfoElementLocator));
        Assert.assertTrue(driver.findElement(XpathStore.promoInfoElementLocator).getText().contains("Code applied"), "Failed to Apply Promo Code: " + promoCode);
        int amtAfterDiscount = Integer.parseInt(driver.findElement(XpathStore.discountedAmountLocator).getText());
        Assert.assertNotEquals(amtAfterDiscount, amtBeforeDiscount, "Amount Remains Same after Applying promoCode");
        SeleniumTest.log(Status.INFO, "Amount Before Discount: " + amtBeforeDiscount + "<br>Amount After Discount: " + amtAfterDiscount);
        SeleniumTest.pass(textColorGreen("Promo Code Applied Successfully. Discounted Amount: " + (amtBeforeDiscount - amtAfterDiscount)));




        driver.quit();
    }

    private static List<String> getList() {
        List<String> list = new ArrayList<>();
        list.add(convertEnumToString(GreenKartProducts.Beans));
        list.add(convertEnumToString(GreenKartProducts.Almonds));
        list.add(convertEnumToString(GreenKartProducts.Strawberry));
        list.add(convertEnumToString(GreenKartProducts.Walnuts));
        list.add(convertEnumToString(GreenKartProducts.Mango));
        list.add(convertEnumToString(GreenKartProducts.Corn));
        list.add(convertEnumToString(GreenKartProducts.Cashews));
        list.add(convertEnumToString(GreenKartProducts.Cucumber));
        list.add(convertEnumToString(GreenKartProducts.Mango));
        list.add(convertEnumToString(GreenKartProducts.Water_Melon));
        list.add(convertEnumToString(GreenKartProducts.Beans));
        list.add(convertEnumToString(GreenKartProducts.Pumpkin));
        list.add(convertEnumToString(GreenKartProducts.Beetroot));
        list.add(convertEnumToString(GreenKartProducts.Pears));
        list.add(convertEnumToString(GreenKartProducts.Onion));
        list.add(convertEnumToString(GreenKartProducts.Tomato));
        return list;
    }
}
