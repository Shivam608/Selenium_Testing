package com.TempPractice;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public class Temp_5 {
    public static void main(String[] args) {
        String xyz = LocalDate.now().format(DateTimeFormatter.ofPattern("d MMM uuuu")).replace(" ", "_");
        System.out.println(System.getProperty("user.dir") + "/Reports/SeleniumTestReports_" + xyz + ".html");
        String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH mm ss")).replace(" ", "_");
        System.out.println(time);

        WebDriver driver = new ChromeDriver();

        /// Explicit Waits
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("expression")));

        /// Implicit Waits
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        /// Select Class
        WebElement element =driver.findElement(By.xpath("//*select[@class='className']"));
        Select select = new Select(element);
        select.getFirstSelectedOption();

        /// Action Class
        Actions actions = new Actions(driver);
        actions.moveToElement(element);

        /// Alerts
        driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();

        /// FluentWaits
        Wait<WebDriver> wait1 = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        wait1.until(driver1 -> {
            WebElement e = driver.findElement(By.xpath("expression"));
            if(e.isDisplayed()) {
                System.out.print("Element is Visible");
                return e;
            } else return null;
        });

        /// Window Handles
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        String parent = iterator.next();
        String child = iterator.next();

        driver.switchTo().window(parent);

        /// Frames
        int noOfFrames = driver.findElements(By.tagName("iFrame")).size();
        driver.switchTo().frame(0);

        driver.switchTo().frame("FrameName/ID");
        driver.switchTo().defaultContent(); //Navigates back to default content

        /// ScreenShots
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileCopyUtils.copy(src, new File(System.getProperty("user.dir")+"\\screenShot.png"));
        }catch (Exception e) {
            e.fillInStackTrace();
        }


    }
}
