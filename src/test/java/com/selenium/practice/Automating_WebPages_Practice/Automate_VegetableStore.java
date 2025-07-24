package com.selenium.practice.Automating_WebPages_Practice;

import Components.GreenKartConfigurations;
import Components.GreenKartProducts;
import Utility.FrameworkConstants;
import com.aventstack.extentreports.Status;
import lombok.NonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Automate_VegetableStore extends GreenKartConfigurations {

    @Test
    public void automate_VegetableMarket() {

        SeleniumTest = extentReports.createTest("Add Vegetables to Cart and perform Checkout");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        SeleniumTest.log(Status.INFO, "Navigating to Browser: " + FrameworkConstants.rsaGreenKart);
        driver.get(FrameworkConstants.rsaGreenKart);
        Assert.assertEquals(driver.getTitle(), "GreenKart - veg and fruits kart", textColorRed("Failed to Validate Page Title"));
        SeleniumTest.pass("Title Validation Success" + textColorGreen(driver.getTitle()));
        driver.manage().window().maximize();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("document.body.style.zoom = '0.2'");

        //List of Web Elements for Product(Vegetable) Name and their Add To Cart Text
        //Try to Ignore Text validation
        @NonNull
        String productNameFromDom = "";
        List<WebElement> productNameElement = driver.findElements(By.xpath("//div[@class='products']//h4[@class='product-name']"));
        List<WebElement> addToCartElement = driver.findElements(By.xpath("//div[@class='products']//button[text()='ADD TO CART']"));
        List<WebElement> addToCartParentElement = driver.findElements(By.xpath("//*[@class='product-action']/button"));

        List<String> list = listOfVegetables();
        StringBuilder totalItemsInCart = new StringBuilder();
        int index = 0;
        for (String s : list) {

            SeleniumTest.log(Status.INFO, "Adding " + s + " into cart");
            for (int j = 0; j < productNameElement.size(); j++) {
                    if (productNameElement.get(j).getText().replace(" ", "_").contains(s)) {
                    productNameFromDom = productNameElement.get(j).getText();
                    index = j;
                    break;
                }
            }

            addToCartParentElement.get(index).click();
            Assert.assertTrue(Objects.requireNonNull(driver.getPageSource()).contains("✔ ADDED"), "Unable to validate Text: ✔ ADDED");
            SeleniumTest.log(Status.PASS, "Item Added to Cart: " + textColorOrange(productNameFromDom));
            totalItemsInCart.append(productNameFromDom).append(", ");
        }

        int totalNumberOfItems = String.valueOf(totalItemsInCart).split(", ").length;
        Assert.assertEquals(list.size(), totalNumberOfItems, "Basket Size Mismatch");
        SeleniumTest.log(Status.PASS, "Total Number of Items: " + totalNumberOfItems);
        SeleniumTest.log(Status.INFO, "Total List Items in cart: " + textColorGreen(String.valueOf(totalItemsInCart)));
    }
}
