package com.selenium.practice.MethodsAndReusables;

import Utility.FrameworkConstants;
import Utility.FrameworkUtilities;
import Utility.XpathStore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

public class WindowHandles {

    public static void main(String[] args) {

        //Navigate to URL
        ChromeDriver driver = (ChromeDriver) FrameworkUtilities.initializeChromeDriverAndNavigateToUrl(FrameworkConstants.rsaAssignment2_LoginPagePractice);

        //Perform Click Action
        driver.findElement(XpathStore.blinkingText_loginPage).click();
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> it = windowHandles.iterator();
        String parent = it.next();
        String child = it.next();

        driver.switchTo().window(child);
        String text = driver.findElement(By.xpath("//a[contains(@href, 'mailto')]")).getText();
        System.out.println(text);
    }
}
