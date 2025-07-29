package com.selenium.practice.MethodsAndReusables;

import Utility.FrameworkConstants;
import Utility.XpathStore;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import java.time.Duration;

//this example of fluent wait uses only CSS and No Xpath's for Practice purpose
public class FluentWaits {

    @Test
    public void fluentWaitExample() {
        WebDriver driver = new ChromeDriver();
        driver.get(FrameworkConstants.herokuAppDynamicLoading);
        driver.findElement(XpathStore.herokuAppClickElement).click();
        System.out.println("Element 'Loading' Image. Before..." + driver.findElement(XpathStore.loadingImgCssElement).isDisplayed());

        Wait<WebDriver> fluentWait_LoadingElement = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(4))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        fluentWait_LoadingElement.until(driver1 ->  {

            WebElement element = driver.findElement(XpathStore.loadingImgCssElement);
                if(element.isDisplayed()) {
                    System.out.println("Element Visible");
                    return element;
                }  else return null;
        });

        System.out.println("Element 'Loading' Image. After..." + driver.findElement(XpathStore.loadingImgCssElement).isDisplayed());
        System.out.println("Element 'Hello World' Text. Before..." + driver.findElement(XpathStore.helloWorldTextElement).isDisplayed());

        Wait<WebDriver> fluentWait_HelloWorldElement = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(6))
                        .pollingEvery(Duration.ofSeconds(2))
                                .ignoring(NoSuchElementException.class);

        fluentWait_HelloWorldElement.until(driver1 -> {
           WebElement element = driver.findElement(XpathStore.helloWorldTextElement);
           if (element.isDisplayed()) {
               return element;
           } else return null;
        });
        System.out.println("Element 'Hello World' Text. Before..." + driver.findElement(XpathStore.helloWorldTextElement).isDisplayed());

    }
}
