package com.selenium.practice.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class Assignment_1 {

    @Test
    public void assessment_1() {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.manage().window().maximize();

        //Validating Title
        Assert.assertEquals(driver.getTitle(), "ProtoCommerce", "Title Mismatch");

        //Sending Name, Email and Password
        driver.findElement(By.xpath("//label[text()='Name']/following-sibling::input[@name='name']")).sendKeys("Rahul Shetty");
        driver.findElement(By.xpath("//label[text()='Email']/following-sibling::input[@name='email']")).sendKeys("mentor@rahulshettyacademy.com");
        driver.findElement(By.xpath("//label[text()='Password']/following-sibling::input[@type='password']")).sendKeys("rsa@12233");

        // Selecting CheckBox
        WebElement checkBox_1 = driver.findElement(By.cssSelector("div[class='form-check'] input[type='checkbox']"));
        if (!checkBox_1.isSelected()) checkBox_1.click();

        //Selecting Gender
        WebElement selectGenderElement = driver.findElement(By.id("exampleFormControlSelect1"));
        Select selectGender = new Select(selectGenderElement);
        selectGender.getFirstSelectedOption().click();

        //Selecting Employment Status
        List<WebElement> listOfRadioButton = driver.findElements(By.xpath("//label[text()='Employment Status: ']/following-sibling::div/input[@type='radio']"));
        System.out.println(listOfRadioButton.size());
        for (WebElement e : listOfRadioButton) {
            if (Objects.requireNonNull(e.getDomAttribute("value")).contains("option2")) {
                e.click();
            }
        }

        //Sending Date of Birth
        driver.findElement(By.xpath("//label[text()='Date of Birth']/following-sibling::input[@type='date']")).sendKeys("2020-02-02");

        //Clicking on Success
        driver.findElement(By.className("btn-success")).click();

        //Validating Success Message
        WebElement successElement = driver.findElement(By.xpath("//div[contains(@class,'alert-success')]/strong"));
        Assert.assertEquals(successElement.getText(), "Success!", "Validation Failed for Submit Success");

        //Closing the Browser after 10 seconds
        try{
            Thread.sleep(10000);
        }catch (Exception e) {
            e.printStackTrace();
        }
        driver.close();
    }
}
