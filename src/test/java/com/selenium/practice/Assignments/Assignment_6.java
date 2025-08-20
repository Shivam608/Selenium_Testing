package com.selenium.practice.Assignments;

import Utility.BaseTest;
import Utility.FrameworkConstants;
import Utility.XpathStore;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Assignment_6 extends BaseTest {

    @Test
    public void validateTableInformation() {
        SeleniumTest = extentReports.createTest("Validate Specific Table Information");
        SeleniumTest.log(Status.INFO, "Validate Table Rows, Columns and Total Amount. Also print data from 2nd Row.");

        //Initialize Chrome Driver and Navigate to URL
        WebDriver driver = initializeChromeDriverAndNavigateToUrl(FrameworkConstants.rsaAutomationWebsite);
        driver.manage().window().maximize();

        //Scroll Down
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy(0,500)");

        //Calculate the total Amount from Table 1
        int expectedAmount = 0;
        WebElement tableElement = driver.findElement(XpathStore.elementWebTableExample_AutomationPractice);
        List<WebElement> elementsListAmount = tableElement.findElements(XpathStore.getListAmountFromWebTableExample_AutomationPractice);
        for (WebElement e: elementsListAmount) {
            expectedAmount += Integer.parseInt(e.getText());
        }
        System.out.println("Expected Amount=" + expectedAmount);
        Assert.assertEquals(expectedAmount, 235, "Amount Mis-Match");

        //Get the Number of Columns in Table:
        int columnSize = tableElement.findElements(XpathStore.columnsFromWebTableExample_AutomationPractice).size();
        System.out.println("Number of Column: " +columnSize);

        //Get the number of Rows in the Table:
        int rowSize = tableElement.findElements(XpathStore.rowsFromWebTableExample_AutomationPractice).size();
        System.out.println("Number of Rows: " +rowSize);

        //Data from the 2nd Row
        int i = 1;
        Assert.assertTrue(i<(columnSize), "Column Number: " + (i+1) + " exceeded from Max number of Columns: " + columnSize);
        WebElement specificRowDataElement = tableElement.findElement(By.xpath(".//tr["+ (i+1) +"]"));
        List<WebElement> specificRowDataList = specificRowDataElement.findElements(By.xpath("./td"));
        for (WebElement e: specificRowDataList) {
            System.out.println(e.getText());
        }

        //Close Browser
        closeBrowser(driver);

    }
}

/**  Instructors Code
 Complete the Assignment and Post the code here

 import java.util.Iterator;
 import java.util.List;
 import java.util.Set;
 import org.openqa.selenium.By;
 import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.WebElement;
 import org.openqa.selenium.chrome.ChromeDriver;
 public class A3 {
 public static void main(String[] args) {
 // TODO Auto-generated method stub
 System.setProperty("webdriver.chrome.driver", "C://work//chromedriver.exe");
 WebDriver driver=new ChromeDriver();
 driver.get("http://qaclickacademy.com/practice.php");
 WebElement table=driver.findElement(By.id("product"));
 System.out.println(table.findElements(By.tagName("tr")).size());
 System.out.println(table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());
 List<WebElement> secondrow=table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
 System.out.println(secondrow.get(0).getText());
 System.out.println(secondrow.get(1).getText());
 System.out.println(secondrow.get(2).getText());
 }
 }
 */
