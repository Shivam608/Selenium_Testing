package com.selenium.practice.MethodsAndReusables;

import Utility.BaseTest;
import Utility.FrameworkConstants;
import Utility.XpathStore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CalenderAutomation extends BaseTest {

    private static final String year = "2025";
    private static final String month = "05";
    private static final String date = "29";
    public static String[] expectedValues = {year, month, date};

    @Test
    public void calendarUiAutomation() {
        SeleniumTest = extentReports.createTest("Calendar UI Automation");
        WebDriver driver = new ChromeDriver();
        driver.get(FrameworkConstants.RSA_CalendarUiAutomation);

        //Click to Open Calendar
        SeleniumTest.info("Click to Open Calendar");
        driver.findElement(XpathStore.calendarUiOpenCalendarElement).click();

        //Click on calendar Header Element until required Text is Found
        SeleniumTest.info("Click on calendar Header Element until required Text is Found");
        WebElement calendarHeaderElement = driver.findElement(XpathStore.calendarUiHeaderElement);
        int i = 1;
        do {
            calendarHeaderElement.click();
            if (calendarHeaderElement.getText().contains("2021 – 2030")) {
                break;
            }
            i++;
        } while (i < 3);


        //Click until @Year is selected
        SeleniumTest.info("Click until @Year:"+ year+ " is selected");
        List<WebElement> calendarYearElements = driver.findElements(XpathStore.calendarUiGetListOfYearElements);
        for (WebElement e : calendarYearElements) {
            if (e.getText().contains(year)) {
                e.click();
                break;
            }
        }

        //Click for @month is selected
        SeleniumTest.info("Click for @month:" + month + " is selected");
        List<WebElement> calendarMonthElements = driver.findElements(XpathStore.calendarUiGetListOfMonthElements);
        calendarMonthElements.get(Integer.parseInt(month)-1).click();

        //Click until @date is selected
        SeleniumTest.info("lick until @date:"+ date+"  is selected");
        List<WebElement> calendarDateElements = driver.findElements(XpathStore.calendarUiGetListOfDateElements);
        for (WebElement e: calendarDateElements){
            String dateText = e.findElement(By.tagName("abbr")).getText();
            if (dateText.equals(date)) {
                e.click();
                break;
            }
        }

        String finalDate = driver.findElement(By.cssSelector("div[class='react-date-picker__inputGroup'] input[name='date']")).getDomAttribute("value");
        System.out.println(finalDate);
        assert finalDate != null;
        String[] actualValues = finalDate.split("-");
        Assert.assertEquals(actualValues, expectedValues, "Mismatch in Calendar Final Date Selected: " + finalDate);
        SeleniumTest.pass(textColorGreen("Successfully Selected Date Month and Year. Final Date: " + finalDate));
        driver.quit();
    }
}
