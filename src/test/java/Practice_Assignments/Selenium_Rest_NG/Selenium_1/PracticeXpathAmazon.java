package Practice_Assignments.Selenium_Rest_NG.Selenium_1;

import Utility.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

public class PracticeXpathAmazon extends BaseTest {

    @Test
    public void amazonXpaths() {

        SeleniumTest = extentReports.createTest("Practice Amazon Xpaths");
        SeleniumTest.info("starting Test");
        WebDriver driver = new ChromeDriver();
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5), Duration.ofSeconds(2));

        driver.get("https://www.amazon.com/gp/cart/view.html?ref_=nav_cart");
        boolean isTitle = Objects.requireNonNull(driver.getTitle()).toLowerCase().contains("shopping cart");
        Assert.assertTrue(isTitle, "Title Miss_match");

        WebElement element = driver.findElement(By.xpath("//div[@id='nav-tools']//following-sibling::span[contains(text(), 'Account')]"));
        explicitWait.until(ExpectedConditions.visibilityOf(element));

        driver.findElement(By.xpath("//a[@id='nav-cart']")).click();
        WebElement element1 = driver.findElement(By.xpath("//h3[contains(@class, 'amazon-cart')]"));
        String validationString_1 = "Your Amazon Cart is empty".toLowerCase();
        Assert.assertTrue(Objects.requireNonNull(element1.getText()).toLowerCase().contains(validationString_1));

        List<WebElement> listOfSuggestedItemsElements = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a//div[contains(@class, 'sc-css-line-clamp-1')]")));
        /*for (WebElement e : listOfSuggestedItemsElements) {
            System.out.println(e.getText());
        }*/
        List<String> listOfItems =  listOfSuggestedItemsElements
                .stream().
                map(WebElement::getText)
                .toList();

        for (String listOfItem : listOfItems) {
            System.out.println(listOfItem);
        }

        WebElement SecondItemElement = driver.findElement(By.xpath("//ul[contains(@class, 'a-vertical')]/li[2]//following-sibling::span[contains(text(),'Add to cart')]//preceding-sibling::input"));
        SecondItemElement.click();

        WebElement chartItems = driver.findElement(By.xpath("//span[@id='nav-cart-count']"));
        explicitWait.until(ExpectedConditions.textToBePresentInElement(chartItems, "1"));

        SeleniumTest.pass("Successfully added Cart Item: " + listOfItems.get(1));


    }
}
