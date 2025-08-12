package com.selenium.practice.Assignments;

import Components.HerokuAppLinks;
import Utility.FrameworkConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment_4 extends HerokuAppLinks {

    static String text = "";
    @Test
    public void nestedFrames() {
        SeleniumTest = extentReports.createTest("Start Test to Validate Nested Frame Concept from: " + FrameworkConstants.herokuApp);

        WebDriver driver = new ChromeDriver();
        driver.get(FrameworkConstants.herokuApp);

        //Click on Nested Frame Options
        this.clickOnElementFromList(driver,  Nested_Frames);


        //Switch To Top Frame
        String frameTop = "frame-top";

        driver.switchTo().frame(frameTop);
        //driver.switchTo().frame("frameset-middle");
        /// for the above code line : Tag name must be having text/name as frame , Tag names like FrameSet is not a frame
        driver.switchTo().frame("frame-left");
//        System.out.println(driver.findElement(By.id("content")).getText());
        text = driver.findElement(By.cssSelector("body")).getText();
        Assert.assertTrue(text.contains("LEFT"));
        System.out.println(text);

        driver.switchTo().defaultContent();
        driver.switchTo().frame(frameTop);
        driver.switchTo().frame("frame-middle");
//        System.out.println(driver.findElement(By.id("content")).getText());
        text = driver.findElement(By.cssSelector("body")).getText();
        Assert.assertTrue(text.contains("MIDDLE"));
        System.out.println(text);

        driver.switchTo().defaultContent();
        driver.switchTo().frame(frameTop);
        driver.switchTo().frame("frame-right");
//        System.out.println(driver.findElement(By.id("content")).getText());
        text = driver.findElement(By.cssSelector("body")).getText();
        Assert.assertTrue(text.contains("RIGHT"));
        System.out.println(text);

        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        text = driver.findElement(By.cssSelector("body")).getText();
        Assert.assertTrue(text.contains("BOTTOM"));
        System.out.println(text);

        //get List of Frames
//        System.out.println(driver.findElements(By.tagName("frame")).size());


//        driver.close();

    }
}
