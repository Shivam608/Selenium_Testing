package com.selenium.practice.MethodsAndReusables;

import Utility.FrameworkUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;

public class ActionsClass {
    static WebDriver driver = new ChromeDriver();

    public static By xpathStore(String key) {
        HashMap<String, String> hashMap= new HashMap<>();
        hashMap.put("continueShopping" , "//button[@type='submit']");
        hashMap.put("signInButton", "//*[@class='nav-line-2 ' and contains(text(), 'Account')]");
        hashMap.put("searchBox", "//*[@id='twotabsearchtextbox']");

        return By.xpath(hashMap.get(key));
    }

    public static void main(String[] args) {
        driver.navigate().to("https://www.amazon.in/");
        if (FrameworkUtilities.isVisible(driver, xpathStore("continueShopping"))) {
            driver.findElement(xpathStore("continueShopping")).click();
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpathStore("signInButton")));

        Actions cursor = new Actions(driver);

        //Performing Single Action || Moves to Specific Element
        cursor.moveToElement(driver.findElement(xpathStore("signInButton"))).build().perform();
        String text = "Nothing phone";
        String text1 = " 3";
        int i = 1;

        //Perform multiple actions
        cursor.moveToElement(driver.findElement(xpathStore("searchBox"))).click()
                .keyDown(Keys.SHIFT).sendKeys(text)
                .keyUp(Keys.SHIFT).sendKeys(text1)
//                .keyDown(Keys.SHIFT).keyDown(Keys.ARROW_LEFT)
                .build().perform();

        while(i<= (text.length() + text1.length())) {
            cursor.keyDown(Keys.SHIFT).keyDown(Keys.ARROW_LEFT).build().perform();
            i++;
        }


        //Right Click
        cursor.moveToElement(driver.findElement(xpathStore("searchBox"))).contextClick().build().perform();

//        closeBrowser();
    }

    public static void closeBrowser() {
        driver.close();
    }
}
