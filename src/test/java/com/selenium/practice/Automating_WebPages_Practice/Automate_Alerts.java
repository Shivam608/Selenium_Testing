package com.selenium.practice.Automating_WebPages_Practice;

import Utility.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Automate_Alerts extends BaseTest {

    @Test
    public void practiceSeleniumAlerts() {

        initializeExtentTest();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.id("name")).sendKeys("PranayKr");
        driver.findElement(By.id("alertbtn")).click();

        //Switch to Alert popUp Box
        //Alerts are not html elements and selenium can't handel other than html, Alerts are JavaScript alerts
        //Thus, Selenium provided a Class with specific Methods to Handel alerts
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        driver.findElement(By.id("name")).sendKeys("PranayKr");
        driver.findElement(By.id("confirmbtn")).click();

        //Switch to Confirm PopUp
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();

    }

}
