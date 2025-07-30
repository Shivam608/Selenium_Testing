package com.TempPractice.Other;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Assignment3_Review {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();



        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);



        driver.manage().window().maximize();



        driver.get("https://the-internet.herokuapp.com/");



        Actions a = new Actions(driver);



        a.moveToElement(driver.findElement(By.xpath("//*[text()='Nested Frames']"))).click().build().perform();

        driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-top']")));

        driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-middle']")));



        System.out.println(driver.findElement(By.id("content")).getText());
    }
}
