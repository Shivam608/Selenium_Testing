package com.selenium.practice.MethodsAndReusables;

import Utility.BaseTest;
import Utility.FrameworkConstants;
import org.openqa.selenium.*;
import org.springframework.util.FileCopyUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Test
public class MultipleWindows_Tabs extends BaseTest {

    public void automate_multipleWindows_Tabs() throws IOException {

        SeleniumTest = extentReports.createTest("Automation Practice Multiple Tabs/Windows");
        WebDriver driver = initializeChromeDriverAndNavigateToUrl(FrameworkConstants.rsaAngularPracticePage);
        driver.manage().window().maximize();

        //Switch to new Tab
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(FrameworkConstants.rsaSourceWebSite);

        List<WebElement> courseListElement = driver.findElements(By.xpath("//*[@id='courses-block']//div[@class='lower-content']//a[@href]"));
        List<String> courseList = courseListElement.stream().map(WebElement::getText).toList();

        String getFirstCourse = courseList.getFirst();
        System.out.println("First Course Name: "+ getFirstCourse);

        //Switch to First Window
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        driver.switchTo().window(it.next());

        WebElement nameElement = driver.findElement(By.xpath("//*[contains(@class,'form-control') and @name='name']"));
        nameElement.sendKeys(getFirstCourse);

        Date date = new Date();
        SimpleDateFormat type_1 = new SimpleDateFormat("dd_MM_yyyy-HH_mm");
        File src = nameElement.getScreenshotAs(OutputType.FILE);
        FileCopyUtils.copy(src, new File(FrameworkConstants.ScreenShotPath + "\\PartialScreenShot_" + type_1.format(date) + ".png"));
    }
}
