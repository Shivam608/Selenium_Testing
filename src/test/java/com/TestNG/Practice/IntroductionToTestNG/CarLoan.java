package com.TestNG.Practice.IntroductionToTestNG;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CarLoan {

    @BeforeTest
    public void beforeTestCarLoan() {
        System.out.println("Before Test inside Car Laon Class");
    }

    @AfterTest
    public void AfterTestCarLoan() {
        System.out.println("After Test inside Car Laon Class");
    }

    @Test(groups = "Smoke")
    public void WebLoginCarLoan() {
        System.out.println("Web Login Car Loan");
    }

    @Test
    public void MobileLoginCarLoan() {
        System.out.println("Mobile Login Car Loan");
    }

    @Test(groups = "Smoke", dependsOnMethods = "WebLoginCarLoan")
    public void APILoginCarLoan() {
        System.out.println("API Login Car Loan");
    }
}
