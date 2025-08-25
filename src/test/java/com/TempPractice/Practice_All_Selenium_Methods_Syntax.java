package com.TempPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;

public class Practice_All_Selenium_Methods_Syntax {

    public void getProp(String value) throws IOException {
        Properties properties = new Properties();
        FileInputStream fs = new FileInputStream("path");
        properties.load(fs);
        System.out.println(properties.get("key"));
    }

    public Object[][] getData() throws IOException{
        List<Object[]> list = new ArrayList<>();

        InputStream stream = new FileInputStream("path");
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

        String l;
        while ((l=reader.readLine()) != null) {
            String[] str = l.split(",");
            list.add(str);
        }

        return list.toArray(new Object[list.size()][]);
    }

    public void pracFluentWait() {
        WebDriver driver = new ChromeDriver();
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(2))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        fluentWait.until(driver1 -> {
            WebElement e = driver.findElement(By.cssSelector(" "));
            if (e.isDisplayed()) {
                return true;
            } return false;
        });

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5), Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(" ")));

        List<WebElement> e = driver.findElements(By.tagName("iframes"));

        driver.switchTo().frame(" ");

    }
    public void mouseActions() {
        WebDriver driver = new ChromeDriver();
        WebElement e = driver.findElement(By.tagName(" "));
        WebElement e1 = e;
        Actions actions = new Actions(driver);
        actions.contextClick();
        actions.dragAndDrop(e, e1);
    }


}
