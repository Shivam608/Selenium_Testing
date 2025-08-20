package com.TestNG.Practice.IntroductionToTestNG;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PersonalLoan {

    @Test
    @Parameters("key")
    public void WebLoginPersonalLoan(String key) {
        System.out.println("Web Login Personal Loan" + " Key: " + key);
    }

    @Test
    public void MobileLoginPersonalLoan() {
        System.out.println("Mobile Login Personal Loan");
    }

    @Test
    public void MobileLogoutPersonalLoan() {
        System.out.println("Mobile Logout Personal Loan");
    }

    @Test
    public void MobileSignInPersonalLoan() {
        System.out.println("Mobile SignIn Personal Loan");
    }

    @Test(groups = "Smoke", enabled = false)
    public void APILoginPersonalLoan() {
        System.out.println("API Login Personal Loan");
    }

    @BeforeSuite(groups = "Smoke", timeOut = 40000)
    public void BeforeSuitePersonalLoan() {
        System.out.println("Before Suite inside Personal Loan Class");
    }

    @AfterSuite
    public void AfterSuitePersonalLoan() {
        System.out.println("After Suite inside Personal Loan Class");
    }
}
