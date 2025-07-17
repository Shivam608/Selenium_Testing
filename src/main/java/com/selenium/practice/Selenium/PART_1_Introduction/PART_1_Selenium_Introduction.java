package com.selenium.practice.Selenium.PART_1_Introduction;

import org.openqa.selenium.edge.EdgeDriver;

public class PART_1_Selenium_Introduction {
    public static void main(String[] args) {

        //Invoking Browser
        //Chrome - ChromeDriver --> Methods
//        System.setProperty("webdriver.chorme.driver", "\"C:\\Users\\prono\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe\"");
//        ChromeDriver driver = new ChromeDriver();

        //FireFox - geckodriver --> Methods
//        FirefoxDriver driver = new FirefoxDriver();

        //Edge Browser -> msedgedriver -> Methods
        EdgeDriver driver = new EdgeDriver();

        driver.get("https://www.amazon.in/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getPageSource());
        driver.close();  //driver.quit();

    }
}
