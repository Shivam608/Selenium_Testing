package com.selenium.practice.MethodsAndReusables;

import Utility.BaseTest;
import Utility.FrameworkConstants;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CaptureScreenShots extends BaseTest {

    public static void main(String[] args) throws IOException {

        //get date Time to Create unique Path
        Date date = new Date();
        SimpleDateFormat dateTime = new SimpleDateFormat("dd_MM_yyyy_HH_mm");

        //Create Output Directory Path
        String outPutFilePath = System.getProperty("user.dir") + "\\ScreenShots\\FullScreenShot_"+dateTime.format(date);
        System.out.println(outPutFilePath);

        //Navigate to URL
        WebDriver driver = initializeChromeDriverAndNavigateToUrl(FrameworkConstants.rsaGreenKart);

        //Take ScreenShot
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileCopyUtils.copy(src, new File(outPutFilePath+".png"));
    }
}
