package com.selenium.practice.MethodsAndReusables;

import Utility.FrameworkConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AutoSuggestiveDropDowns {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get(FrameworkConstants.rsaDropDownPractice);

        driver.findElement(By.id("autosuggest")).sendKeys("Ind");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id='ui-id-1'] li")));

        List<WebElement> element_1 = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li/a"));
        Actions cursor = new Actions(driver);
        for (WebElement e : element_1) {
            if (e.getText().equalsIgnoreCase("India")) {
//                cursor.click(e).build().perform();
                e.click();
                break;
            }
        }

        driver.quit();
    }


}