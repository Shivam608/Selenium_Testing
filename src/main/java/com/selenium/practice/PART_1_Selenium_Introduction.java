package com.selenium.practice;

import org.openqa.selenium.chrome.ChromeDriver;

public class PART_1_Selenium_Introduction {
    public static void main(String[] args) {

        //Invoking Browser
        //Chrome - ChromeDriver --> Methods
        System.setProperty("webdriver.chorme.driver", "\"C:\\Users\\prono\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe\"");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.close();  //driver.quit();

    }
}
