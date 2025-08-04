package com.selenium.practice.MethodsAndReusables;

import Utility.BaseTest;
import Utility.FrameworkConstants;
import Utility.XpathStore;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class JavaScriptExecutorPractice extends BaseTest {
    public static void main(String[] args) {

        WebDriver driver = initializeEdgeBrowserAndNavigateToUrl(FrameworkConstants.rsaAutomationWebsite);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        jsExecutor.executeScript("window.scrollBy(0,500)");
        jsExecutor.executeScript("document.querySelector(\"[class='tableFixHead']\").scrollBy(0,500)");
//        driver.findElement(By.cssSelector("[class='tableFixHead']")).click();

        //Get the Sum of all Values from Table Name = tableFixHead (4th Column)
        int expectedAmount = 0;
        List<WebElement> amountListElement = driver.findElements(XpathStore.listOfAmountInWebTableFixedHeader_AutomationPractice);
        for (WebElement e: amountListElement) {
            expectedAmount += Integer.parseInt(e.getText());
        }
        System.out.println("Total Amount: " + expectedAmount );
        String amt = driver.findElement(XpathStore.amountFromFixedHeaderTable_AutomationPractice).getText();
        int actualAmount = Integer.parseInt(driver
                .findElement(XpathStore.amountFromFixedHeaderTable_AutomationPractice)
                .getText().trim()
                .replaceAll("[^0-9]", ""));

        Assert.assertEquals(actualAmount, expectedAmount, "Amount Mis match");

        //closing Browser
        closeBrowser(driver);
    }
}
