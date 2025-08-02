package com.selenium.practice.MethodsAndReusables;

import Utility.FrameworkConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LimitingDriverScope {
    private static final WebDriver driver = new ChromeDriver();

    public static void main(String[] args) {

        //Example 1
        LimitingDriverScope scope = new LimitingDriverScope();
//        scope.example1();

        scope.example2();

    }

    private void example1() {
        driver.get(FrameworkConstants.herokuApp);

        List<WebElement> listOfOptions = driver.findElements(By.xpath("//h2[text()='Available Examples']/following::a"));
        for (WebElement e : listOfOptions) {
            if (e.getText().contains("Nested")) {
                e.click();
                break;
            }
        }

        //Limiting Driver scope to be inside Frameset tag in Dom Structure
        WebElement framesetDriver = driver.findElement(By.tagName("frameset"));
        System.out.println(framesetDriver.findElements(By.tagName("frame")).size());
    }

    private void example2() {

        driver.get(FrameworkConstants.rsaAutomationWebsite);
        System.out.println(driver.findElements(By.tagName("a")).size());

        //limiting driver scope to footer
        WebElement footerDriver = driver.findElement(By.xpath("//h1[text()='Practice Page']/following::div[@id='gf-BIG']"));
        System.out.println(footerDriver.findElements(By.tagName("a")).size());

        //Limiting driver scope further to first Column
        //Using descendant or ancestor
        WebElement columnFooter = footerDriver.findElement(By.xpath("//table[@class='gf-t']//descendant::li//a[contains(text(),'Discount')]/ancestor::ul"));
        List<WebElement> listOfFooter1stColumnLinks = columnFooter.findElements(By.tagName("a"));
        System.out.println(listOfFooter1stColumnLinks.size());


        //Option 1
//        Actions cursor = new Actions(driver);
//        for (int i = 1; i < listOfFooter1stColumnLinks.size(); i++) {
//
//           cursor.keyDown(Keys.CONTROL)
//                   .moveToElement(listOfFooter1stColumnLinks.get(i)).click()
//                   .build().perform();
//        }
//
//        //Getting the Title of Each and Every Tab
//        Set<String> listOfWindows = driver.getWindowHandles();
//        Iterator<String> iterator = listOfWindows.iterator();
//        for (Iterator<String> it = iterator; it.hasNext(); ) {
//            String s = it.next();
//            System.out.println(driver.switchTo().window(s).getTitle());
//        }

        //Option: 2
        for (int i = 1; i < listOfFooter1stColumnLinks.size(); i++) {
            String cordedKeys = Keys.chord(Keys.CONTROL, Keys.ENTER);
            listOfFooter1stColumnLinks.get(i).sendKeys(cordedKeys);
        }
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();
        while (it.hasNext()) {
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }
    }
}
