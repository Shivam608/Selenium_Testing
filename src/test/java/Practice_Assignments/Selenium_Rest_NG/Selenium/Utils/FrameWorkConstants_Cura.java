package Practice_Assignments.Selenium_Rest_NG.Selenium.Utils;

import org.openqa.selenium.By;

public interface FrameWorkConstants_Cura {
    /// WebLinks
    String cura_Url = "https://katalon-demo-cura.herokuapp.com/";

    /// Xpaths
    By makeAppointment_Button = By.id("btn-make-appointment");
    By getUserName_demo = By.xpath("//input[@placeholder='Username']");
    By getPassword_demo = By.xpath("//input[@placeholder='Password']");

    By setUserName_demo = By.id("txt-username");
    By setPassword_demo = By.id("txt-password");

    By Login = By.xpath("//button[@id='btn-login']");

    By CheckBoxElement = By.xpath("//input[@id='chk_hospotal_readmission']");




}
