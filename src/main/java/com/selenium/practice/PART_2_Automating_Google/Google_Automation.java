package com.selenium.practice.PART_2_Automating_Google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.util.Assert;

import java.time.Duration;

public class Google_Automation {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chorme.driver", "\"C:\\Users\\prono\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe\"");
        ChromeDriver driver = new ChromeDriver();
        //Providing Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Go to URL
        driver.get("http://www.rahulshettyacademy.com/locatorspractice/");

        //WebElements for Future Use
        WebElement inputUserName = driver.findElement(By.id("inputUsername"));
        WebElement inputPassword = driver.findElement(By.name("inputPassword"));
        WebElement signInButton = driver.findElement(By.className("signInBtn"));

        //Perform Actions
        inputUserName.sendKeys("Kumar");
        inputPassword.sendKeys("123456");
        signInButton.click();

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

        //Parent to Child Traversing
        String forgotPasswordString = driver.findElement(By.xpath("//form/h2[contains(text(), 'Forgot')]")).getText();
        System.out.println(forgotPasswordString);

        //Sending new Name and Email and Phone Number
//        driver.findElement(By.xpath("//input[@type='text' and @placeholder='Name']")).sendKeys("Shivam_Kr");
//        driver.findElement(By.xpath("//input[@type='text' and @placeholder='Email']")).sendKeys("Shivam.Pranay@goole.com");
//        driver.findElement(By.xpath("//input[@type='text' and @placeholder='Phone Number']")).sendKeys("Shivam.Pranay@goole.com");
        // Using CSS Selector
        // driver.findElement(By.cssSelector("input[type='text'][placeholder='Phone Number']")).sendKeys("Shivam.Pranay@goole.com");

        // Alternate way using Parent to Child Traversing and using Contains
        driver.findElement(By.xpath("//form/input[@placeholder='Name']")).sendKeys("Text Name Field");
        driver.findElement(By.xpath("//form/input[contains(@placeholder , 'Email')]")).sendKeys("Text Email Field");
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("Text PhoneNumber Field"); //Not recommended

        //Click on Reset login and Press Go to LogIn
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[contains(@class, 'pwd-btn-conainer')]/button[contains(@class, 'go-to-login')]")).click();
        driver.findElement(By.xpath("//div/button[contains(@class, 'reset-pwd')]")).click();

        //Get the String for Password Reset Success
        String resetPassword = driver.findElement(By.xpath("//p[@class=\"infoMsg\"]")).getText();
        Assert.isTrue((resetPassword.contains("password") && resetPassword.contains("to Login.")), "Failed to Match Expected String");

        //Extract Password from String
        String[] listOfString = resetPassword.split("'");
        resetPassword = listOfString[1];

        //Enter Correct UserName and Password
        inputUserName.sendKeys("PK");
        inputPassword.sendKeys(resetPassword);
        Thread.sleep(1000);
        signInButton.click();

//        driver.close();
    }
}
