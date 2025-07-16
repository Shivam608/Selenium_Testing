package com.selenium.practice.PART_2_Automating_Google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Google_Automation {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chorme.driver", "\"C:\\Users\\prono\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe\"");
        ChromeDriver driver = new ChromeDriver();
        //Providing Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Go to URL
        driver.get("http://www.rahulshettyacademy.com/locatorspractice/");

        //Perform Actions
        driver.findElement(By.id("inputUsername")).sendKeys("Kumar");
        driver.findElement(By.name("inputPassword")).sendKeys("123456");
        driver.findElement(By.className("signInBtn")).click();

        //CSS Selector for Text -> * Incorrect username or password
        WebElement errorElement = driver.findElement(By.cssSelector("p.error"));
        boolean isErrorDisplayed = errorElement.isDisplayed();
        if (isErrorDisplayed) {
            String errorElementText = errorElement.getText();
            if (!errorElementText.contains("Incorrect username")) {
                throw new AssertionError("Unable to get Incorrect Username... string. Got: " + errorElementText);
            }
        }
        driver.findElement(By.linkText("Forgot your password?")).click();
//        String text = driver.findElement(By.cssSelector("a[href='#']")).getText();
//        System.out.println(text);
//        document.querySelectorAll("a[href='#']")   --> use this in dev tools console to get the list of elements

        //Sending new Name and Email and Phone Number
        driver.findElement(By.xpath("//input[@type='text' and @placeholder='Name']")).sendKeys("Shivam_Kr");
        driver.findElement(By.xpath("//input[@type='text' and @placeholder='Email']")).sendKeys("Shivam.Pranay@goole.com");
        driver.findElement(By.cssSelector("input[type='text'][placeholder='Phone Number']")).sendKeys("Shivam.Pranay@goole.com");

        driver.close();
    }
}
