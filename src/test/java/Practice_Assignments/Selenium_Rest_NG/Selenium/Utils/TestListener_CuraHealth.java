package Practice_Assignments.Selenium_Rest_NG.Selenium.Utils;

import Utility.FrameworkUtilities;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class TestListener_CuraHealth extends CuraHealthBaseTest implements ITestListener{

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        try {
            FrameworkUtilities.takeFullScreenShot(driver);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
