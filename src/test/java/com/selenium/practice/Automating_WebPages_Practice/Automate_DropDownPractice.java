package com.selenium.practice.Automating_WebPages_Practice;

import Utility.BaseTest;
import Utility.FrameworkConstants;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Objects;

public class Automate_DropDownPractice extends BaseTest {

    @Test
    public void automate_DropDownPractice() throws InterruptedException {
        SeleniumTest = extentReports.createTest("Practice Set: 3 DropDown Locators Practice");

        //Initializing Chrome Driver using webDriver Interface
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Navigating to the Selected Page
        SeleniumTest.log(Status.INFO, "Navigating to Website: " + FrameworkConstants.rsaDropDownPractice);
        driver.get(FrameworkConstants.rsaDropDownPractice);
        Assert.assertTrue(Objects.requireNonNull(driver.getTitle()).contains("QAClickJet"));
        SeleniumTest.log(Status.PASS, textColorGreen("Navigated to WebSite: " + driver.getTitle() + " Successfully"));

        //Practice DropDown List and their Elements
        //Static Drop Down Elements
        SeleniumTest.log(Status.INFO, "Setting Currency to AED");
        WebElement currencyList = driver.findElement(By.xpath("//div[@class = 'currency-dropdown']/select[contains(@name, 'DropDownListCurrency')]"));
        Select dropdown = new Select(currencyList);
        //dropdown.selectByIndex(2); // Option 1 (less Recommended)
        dropdown.selectByVisibleText("AED"); //Option 2
        //dropdown.selectByValue("AED"); //Option 3 (should have attribute as Value)
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "AED", "Text From Currency Tab Nt Matched");
        SeleniumTest.log(Status.PASS, textColorGreen("Currency Set to " + dropdown.getFirstSelectedOption().getText() + " Successfully"));

        //Selecting Number of Adults from drop down list as 5 and validating same
        SeleniumTest.log(Status.INFO, "Adding Total Number of Adults as 5");
        driver.findElement(By.xpath("//*[@id= 'divpaxinfo']")).click();
        Thread.sleep(5000);
        int addAdults;
        WebElement noOfAdults = driver.findElement(By.xpath("//div[contains(@id, 'Adult')]/div[@class = 'ad-row-right']/span[@id ='spanAudlt']"));
        do {
            addAdults = Integer.parseInt(noOfAdults.getText());
            driver.findElement(By.xpath("//div[contains(@class, 'adult-popup')]//div[@class='ad-row-right']/span[contains(@id,'IncAdt')]")).click();
        } while (addAdults<4);
        addAdults = Integer.parseInt(noOfAdults.getText());
        Assert.assertEquals(addAdults, 5, "Expected Number of Adults to be added not Matched");
        driver.findElement(By.xpath("//input[@class = 'buttonN' and @value='Done']")).click();
        SeleniumTest.log(Status.PASS, textColorGreen("Total Number of Adults added: " + addAdults));


        SeleniumTest.log(Status.INFO, "Closing Browser");
        driver.close();







    }
}
