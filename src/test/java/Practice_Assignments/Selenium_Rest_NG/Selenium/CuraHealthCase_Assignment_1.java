package Practice_Assignments.Selenium_Rest_NG.Selenium;

import Practice_Assignments.Selenium_Rest_NG.Selenium.Utils.CuraHealthBaseTest;
import Practice_Assignments.Selenium_Rest_NG.Selenium.Utils.FrameWorkConstants_Cura;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class CuraHealthCase_Assignment_1 extends CuraHealthBaseTest {

    @FindBy(id = "btn-make-appointment")
    WebElement clickOnMakeAppointment;

    public CuraHealthCase_Assignment_1() {
        PageFactory.initElements(driver, this);
    }

    @Test
    public void selectBookAppointment() {
        final String url = FrameWorkConstants_Cura.cura_Url;
        SeleniumTest.info("Navigate to URL: " + textColorGreen(url));
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        CuraHealthCase_Assignment_1 cura = new CuraHealthCase_Assignment_1();
        cura.clickOnMakeAppointment.click();
    }

    @Test(dependsOnMethods = "selectBookAppointment")
    public void LogIn() {
        SeleniumTest.info("Login to Demo Account");

        String userName = driver.findElement(FrameWorkConstants_Cura.getUserName_demo).getDomAttribute("value");
        String password = driver.findElement(FrameWorkConstants_Cura.getPassword_demo).getDomAttribute("value");
        Assert.assertNotNull(userName);
        Assert.assertNotNull(password);
        SeleniumTest.info("UserName: " + textColorGreen(userName) + " and Password: "+ textColorGreen(password) + " Fetched.");

        driver.findElement(FrameWorkConstants_Cura.setUserName_demo).sendKeys(userName);
        driver.findElement(FrameWorkConstants_Cura.setPassword_demo).sendKeys(password);

        SeleniumTest.info("Click on Login");
        driver.findElement(FrameWorkConstants_Cura.Login).click();

        try {
            driver.switchTo().alert().accept();
        } catch (NoAlertPresentException e) {
            System.out.println("No Alert Found");
        }
    }

    @Parameters("Value_1")
    @Test(dependsOnMethods = "LogIn")
    public void createAppointment(String Value_1) {
        SeleniumTest.info("Select value=\"" + Value_1 + "\"");
        Select select = new Select(driver.findElement(By.id("combo_facility")));
        select.selectByValue(Value_1);

        WebElement textCheckBox = driver.findElement(FrameWorkConstants_Cura.CheckBoxElement);
        System.out.println(textCheckBox.getText());
        if (textCheckBox.getText().toLowerCase().contains("readmission")) textCheckBox.findElement(FrameWorkConstants_Cura.CheckBoxElement).click();
    }

}
