package com.selenium.practice.MethodsAndReusables;

import Utility.FrameworkConstants;
import Utility.FrameworkUtilities;
import Utility.XpathStore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Objects;

public class FramesInSelenium {

    @Test
    public void framesPractice() {

        WebDriver driver = FrameworkUtilities.initializeChromeDriverAndNavigateToUrl(FrameworkConstants.jQueryPracticeSite);
        driver.manage().window().maximize();

        //Click on Desired web element
        FrameworkUtilities utils = new FrameworkUtilities();
        utils.clickOnElementFromList(driver, XpathStore.jqueryInteractionsList, "Droppable");

        //List of Frames in Website
        System.out.println(driver.findElements(By.tagName("iFrame")).size());
        driver.switchTo().frame(0); // Switching Frames By Index

        //Validate if Element is visible
        System.out.println(FrameworkUtilities.isVisible(driver, By.id("draggable")));

        //Drag and Drop elements
        WebElement elementDrag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement elementDrop = driver.findElement(By.xpath("//*[@id='droppable']"));

        Actions cursor = new Actions(driver);
        cursor.dragAndDrop(elementDrag, elementDrop).build().perform();
        Assert.assertTrue(Objects.requireNonNull(driver.findElement(By.cssSelector("[id='droppable'] p"))).getText().contains("Dropped!"), "Drag and Drop Failed");
    }
}
