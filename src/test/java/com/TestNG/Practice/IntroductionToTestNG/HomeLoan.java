package com.TestNG.Practice.IntroductionToTestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomeLoan{

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method 2");
    }

    @BeforeMethod
    public void BeforeMethodHomeLoan() {
        System.out.println("Before Method inside Home Loan");
    }

    @AfterMethod
    public void AfterMethodHomeLoan() {
        System.out.println("After Method inside Home Loan");
    }

    @Test
    @Parameters("key")
    public void WebLoginHomeLoan(String key) {
        System.out.println("Web Login Home Loan" + " Key: " + key);
    }

    @Test(groups = "Smoke")
    @Parameters("key")
    public void MobileLoginHomeLoan(String key) {
        System.out.println("Mobile Login Home Loan" + " Key: " + key);
    }

    @Test
    public void APILoginHomeLoan() {
        System.out.println("API Login Home Loan");
    }

    @Test
    @Parameters("key")
    public void SystemLoginHomeLoan(String key) {
        System.out.println("System Log In inside Home Loan" + " Key: " + key);
    }


}
