package com.selenium.practice.Automating_WebPages_Practice;

import Utility.BaseTest;
import Utility.FrameworkConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class Automate_usingStream_GreenKart_VegetableList extends BaseTest {
    private static WebDriver driver;

    @BeforeTest(alwaysRun = true)
    public void beforeTest() {
        SeleniumTest = extentReports.createTest("Before Method");
        SeleniumTest.info("RSA Green Kart Offer Page Automation using Streams");
        driver = initializeChromeDriverAndNavigateToUrl(FrameworkConstants.rsaGreenKart_offers);

        Assert.assertTrue(Objects.requireNonNull(driver.getTitle()).toLowerCase().contains("greenkart"));
        WebElement listSizeElement = driver.findElement(By.id("page-menu"));
        Select selectSize = new Select(listSizeElement);
        selectSize.selectByValue("20");
    }

    @Test
    public void usingSteam_Automate_GK_VegetableList() {

        SeleniumTest = extentReports.createTest("Test Method 1: Sorted/Un-Sorted Items validation");
        SeleniumTest.info("Playing With List of Elements to Get Sorted and UnSorted Data/Items");
        List<String> listOfItems;
        List<String> listOfItemsSorted = null;
        List<WebElement> listOfItemsElement = driver.findElements(By.xpath("//*[(@class='sr-only') and (contains(text(), 'Sorted'))]//following::td"));
        listOfItems = listOfItemsElement.stream().map(WebElement::getText).filter(text ->!text.matches("\\d+")).toList();
        System.out.println("UnSorted List of Items: " + listOfItems);
        if (!listOfItems.stream().sorted().toList().equals(listOfItems)) {
            listOfItemsSorted = listOfItems.stream().sorted().toList();
        }

        Assert.assertNotNull(listOfItemsSorted, "Sorted List is Null");
        System.out.println("Sorted List of Items: " + listOfItemsSorted);

        Actions cursorActions = new Actions(driver);
        WebElement sortedClick = driver.findElement(By.cssSelector("[class='sort-icon sort-descending']"));
        cursorActions.moveToElement(sortedClick).click().build().perform();

        WebElement fistElementIsAlmond = driver.findElement(By.xpath("//*[(@class='sr-only') and (contains(text(), 'Sorted'))]//following::td[1]"));
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        explicitWait.until(ExpectedConditions.textToBePresentInElement(fistElementIsAlmond, "Almond"));

        List<WebElement> sortedListElement = driver.findElements(By.xpath("//table[@class='table table-bordered']//descendant::tBody//td[1]"));
        List<String> newSortedList = sortedListElement.stream().map(WebElement::getText).toList();
        Assert.assertEquals(listOfItemsSorted, newSortedList, "Item Sort Match Validation Failed");

    }

    @Test
    public void automate_UsingStream_getPriceFromItemText() {

        String itemName = "Carrot";
        List<WebElement> listOfItemTextElement = driver.findElements(By.xpath("//table[@class='table table-bordered']//descendant::tBody//td[1]"));
        String price = "";
        /*for (WebElement e: listOfItemTextElement) {
            if (Objects.requireNonNull(e.getText()).equalsIgnoreCase(itemName)) {
                price = e.findElement(By.xpath("./following-sibling::td")).getText();
            }
        }*/


        price = listOfItemTextElement.stream().filter(element -> element.getText().equalsIgnoreCase(itemName))
                        .findFirst()
                                .map(element -> element.findElement(By.xpath("./following-sibling::td")).getText())
                                        .orElse("null");

//        listOfItemTextElement.stream().map(WebElement::getText).filter(text -> text.equals(itemName))
        System.out.println("Price of " + itemName + " is " + price);
    }

    @Test
    public void getPriceUsingPagination() {
        String itemName = "Carrot";
        driver.navigate().refresh();
        String price;
        boolean isTrue = false;
        WebElement nextElement = driver.findElement(By.cssSelector("[aria-label='Next']"));

        do {
            List<WebElement> listOfItemTextElement = driver.findElements(By.xpath("//table[@class='table table-bordered']//descendant::tBody//td[1]"));
            price = listOfItemTextElement.stream().filter(element -> element.getText().equalsIgnoreCase(itemName))
                    .findFirst()
                    .map(element -> element.findElement(By.xpath("./following-sibling::td")).getText())
                    .orElse("null");

            if (price.equals("null")) {
                nextElement.click();
            } else if (price.matches("\\d+")) break;
            isTrue = Objects.requireNonNull(nextElement.getDomAttribute("aria-disabled")).equalsIgnoreCase("true");
        } while (!isTrue);

        Assert.assertNotEquals(price, "null", "Price ");
        System.out.println("Price of " + itemName + " is " + price);

    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        closeBrowser(driver);
    }
}
