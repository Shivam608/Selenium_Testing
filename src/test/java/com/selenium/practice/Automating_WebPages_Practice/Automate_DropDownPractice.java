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

import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class Automate_DropDownPractice extends BaseTest {

    @Test
    public void automate_DropDownPractice() throws InterruptedException {
        SeleniumTest = extentReports.createTest("Practice Set: 3 DropDown Locators Practice");

        //Initializing Chrome Driver using webDriver Interface
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Navigating to the Selected Page
        SeleniumTest.log(Status.INFO, "Navigating to Website: " + FrameworkConstants.rsaDropDownPractice);
        driver.get(FrameworkConstants.rsaDropDownPractice);
        Assert.assertTrue(Objects.requireNonNull(driver.getTitle()).contains("QAClickJet"));
        SeleniumTest.log(Status.PASS, textColorGreen("Navigated to WebSite: " + driver.getTitle() + " Successfully"));

        // Practice Static DropDown List and their Elements
        //Static Drop Down Elements
        SeleniumTest.log(Status.INFO, "Setting Currency to AED");
        WebElement currencyList = driver.findElement(By.xpath("//div[@class = 'currency-dropdown']/select[contains(@name, 'DropDownListCurrency')]"));
        Select dropdown = new Select(currencyList);
        //dropdown.selectByIndex(2); // Option 1 (less Recommended)
        dropdown.selectByVisibleText("AED"); //Option 2
        //dropdown.selectByValue("AED"); //Option 3 (should have attribute as Value)
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "AED", "Text From Currency Tab Nt Matched");
        SeleniumTest.log(Status.PASS, textColorGreen("Currency Set to " + dropdown.getFirstSelectedOption().getText() + " Successfully"));

        //Selecting the Number of Adults from a drop-down list as 5 and validating same
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


        //Practice Dynamic DropDown List and their Elements
        //Click On Departure Option to generate the drop Down List
        driver.findElement(By.xpath("//div[@id='marketCityPair_1']//input[contains(@value, 'Departure City')]")).click();
        SeleniumTest.log(Status.INFO, "Selecting Departure City from Drop Down List");
        driver.findElement(By.xpath("//div[@id='marketCityPair_1']//a[text()=' Hyderabad (HYD)']")).click();
//        WebElement setFromCityNameElement = driver.findElement(By.xpath("(//*[@id='ctl00_mainContent_ddl_originStation1_CTXT'])[1]"));
//        Thread.sleep(1000);
//        Assert.assertTrue(setFromCityNameElement.getText().contains("HYD"), "Failed to Set Departure City. Expected: Hyderabad (HYD), Actual: " + setFromCityNameElement.getText());
//        SeleniumTest.pass(textColorGreen("Departure City Set Successfully to :" + setFromCityNameElement.getText()));

        SeleniumTest.log(Status.INFO, "Selecting Arrival City from Drop Down list");
        driver.findElement(By.xpath("//div[@id='marketCityPair_1']//div[@class='right1']//a[contains(text(), ' Mumbai (BOM)')]")).click();
//        WebElement setToCityNameElement = driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT"));
//        Thread.sleep(1000);
//        Assert.assertTrue(setToCityNameElement.getText().contains("BOM"), "Failed to Set Arrival City. Expected: Mumbai (BOM), Actual: " + setToCityNameElement.getText());
//        SeleniumTest.pass(textColorGreen("Actual City Set Successfully to :" + setToCityNameElement.getText()));

        SeleniumTest.log(Status.INFO, "Selected Date of travel From Calendar");
        driver.findElement(By.cssSelector("td[class=' ui-datepicker-week-end  ui-datepicker-current-day'] a")).click();

        //Practice Auto Suggestive  DropDown List and their Elements
        SeleniumTest.log(Status.INFO, "Selecting Country India from Auto Suggestive Drop-Down List");
        WebElement autoSuggestTextBoxElement = driver.findElement(By.xpath("//legend/following-sibling::input[@id='autosuggest']"));
        autoSuggestTextBoxElement.sendKeys("Ind");
        List<WebElement> autoSuggestElements = driver.findElements(By.xpath("//ul[contains(@id,'ui-id-1')]/li"));
        for (WebElement e : autoSuggestElements) {
            if (e.getText().equalsIgnoreCase("india")) {
                e.click();
                break;
            }
        }

        //Practice Working with checkboxes
        SeleniumTest.log(Status.INFO, "Validate Check Boxes");
        WebElement studentCheckBoxElement = driver.findElement(By.cssSelector("input[id*='chk_StudentDiscount']"));
        studentCheckBoxElement.click();
        Assert.assertTrue(studentCheckBoxElement.isSelected(), "Student CheckBox Element is not Selected");
        SeleniumTest.pass(textColorGreen("Check Box is Selected for Student Category"));

        List<WebElement> checkboxElements = driver.findElements(By.xpath("//*[@type='checkbox']"));
        System.out.println("Number of Checkboxes: "+ checkboxElements.size());
        SeleniumTest.log(Status.INFO, textColorGreen("Number of Checkboxes: "+ checkboxElements.size()));


        //Practicing Element is Enabled or Not using .isEnabled()
        SeleniumTest.log(Status.INFO, "Clicking on One Way Trip CheckBox is Not Selected");
        List<WebElement> elementListTripCheckbox = driver.findElements(By.xpath("//input[@name='ctl00$mainContent$rbtnl_Trip' and @type='radio']"));
        WebElement oneWayCheckBoxElement = driver.findElement(By.xpath("//table[@class='tblTrip']//input[@value='OneWay']"));
        if(!elementListTripCheckbox.getFirst().isSelected()){
            elementListTripCheckbox.getFirst().click();
        }
        WebElement returnDateElement = driver.findElement(By.cssSelector("input[id*='ctl00_mainContent_view_date2']"));
        //The below code always gives True as .isEnabled is not working such cases
//        System.out.println("Return Date Enabled?Disabled Status: " + returnDateElement.isEnabled());
        //Alternate Code -> Noticed that Attribute Style changes its Opacity when return calendar is blocked/unblocked
        SeleniumTest.log(Status.INFO, "Validating Style Opacity is 0.5 for Return Trip Calendar");
        String returnCalenderStyleOpacityText = driver.findElement(By.id("Div1")).getDomAttribute("style");
        Assert.assertNotNull(returnCalenderStyleOpacityText, textColorRed("Received Null Data for Variable: returnCalenderStyleOpacityText"));
        Assert.assertTrue(returnCalenderStyleOpacityText.contains("0.5"), textColorRed("Return Trip Calender is Enabled, Received: " + returnCalenderStyleOpacityText));
        SeleniumTest.pass("Style Opacity Validated as 0.5 for Return Trip Calender,Received Value:" + textColorGreen(returnCalenderStyleOpacityText));
        SeleniumTest.log(Status.INFO, "Validating Style Opacity is 1 for Return Trip Calendar");
        elementListTripCheckbox.get(1).click();
        returnCalenderStyleOpacityText = driver.findElement(By.id("Div1")).getDomAttribute("style");
        Assert.assertNotNull(returnCalenderStyleOpacityText);
        Assert.assertTrue(returnCalenderStyleOpacityText.contains("1"), textColorRed("Return Trip Calender is Disabled, Received: " + returnCalenderStyleOpacityText));
        SeleniumTest.pass("Style Opacity Validated as 1 for Return Trip Calender, Received Value:" + textColorGreen(returnCalenderStyleOpacityText));

        SeleniumTest.log(Status.INFO, "Closing Browser");
        driver.close();







    }
}
