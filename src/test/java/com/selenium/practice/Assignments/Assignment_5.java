package com.selenium.practice.Assignments;

import Utility.BaseTest;
import Utility.FrameworkConstants;
import Utility.XpathStore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Assignment_5 extends BaseTest {
    public static final String input = "4";
    String optionSelected = "";
    @Test
    public void automate_CheckBoxes_dropDowns_Alerts() throws InterruptedException {

        SeleniumTest = extentReports.createTest("Validate CheckBoxes Drop Downs & Alerts");
        WebDriver driver = initializeChromeDriverAndNavigateToUrl(FrameworkConstants.rsaAutomationWebsite);
        driver.manage().window().maximize();

        //Find Elements for CheckBoxes
        SeleniumTest.info("Setting the List of CheckBox Elements");
        List<WebElement> listOfCheckBoxElements = driver.findElements(XpathStore.checkBoxList_AutomationPractice);
        SeleniumTest.info("Total Number of Options Available: " + listOfCheckBoxElements.size());
        boolean isElementSelected = false;
        for (int i = 0; i < listOfCheckBoxElements.size(); i++) {
            String s = listOfCheckBoxElements.get(i).getDomAttribute("value");
            Assert.assertNotNull(s, "Dom Attribute is null from CheckBox Elements");
            if (s.contains(input)) {
                listOfCheckBoxElements.get(i).click();
                optionSelected = s;
                SeleniumTest.pass("Clicked on Option as Per Input Provided");
                isElementSelected = true;
                break;
            }
        }

        if (!isElementSelected) {
            SeleniumTest.fail(textColorRed("Provided Input: " + input + " dose not match any available Option in CheckBox"));
            throw new AssertionError("Unable to perform Click Action");
        }
        
        //Select Option from rop Down List
        SeleniumTest.info("Selecting the Desired Option from Drop Down List");
        WebElement optionElement = driver.findElement(XpathStore.selectOptions_AutomationPractice);
        Select selectOption = new Select(optionElement);
        selectOption.selectByValue(optionSelected);
        String optionSelectedFromDropDownList = optionElement.findElement(By.xpath("//option[@value='" + optionSelected + "']")).getText();
        Assert.assertEquals(optionSelectedFromDropDownList.toLowerCase(), optionSelected, "Failed To match Values.");
        SeleniumTest.pass("Selected " + textColorGreen(optionSelectedFromDropDownList) + " from Drop Down List");

        //Send text and click on Alert
        SeleniumTest.info("Sending Required Text to Text Box");
        driver.findElement(By.id("name")).sendKeys(optionSelected);

        SeleniumTest.info("Click on Alert and Validate Text in Alert Box. Finally Accept Alert");
        driver.findElement(By.id("alertbtn")).click();
        Thread.sleep(2000L);
       /* Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(4))
                .ignoring(NoSuchElementException.class);

        fluentWait.until(driver1 -> {
            String alertBoxText = driver.switchTo().alert().getText();
            if (alertBoxText.contains(optionSelected)) {
                return alertBoxText;
            }
            return null;
        });*/
        String alertBoxText = driver.switchTo().alert().getText();
        Assert.assertTrue(alertBoxText.contains(optionSelected), "Alert Message: " + alertBoxText + ", Dose not contain String: " + optionSelected);
        SeleniumTest.pass("Validated Alert message Successfully. Message: " + textColorGreen(alertBoxText));
        driver.switchTo().alert().accept();

        //Close Browser on Successful completion
        closeBrowser(driver);



    }
}
