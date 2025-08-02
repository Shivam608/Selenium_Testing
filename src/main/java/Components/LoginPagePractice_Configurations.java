package Components;

import Utility.BaseTest;
import Utility.XpathStore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class LoginPagePractice_Configurations extends BaseTest {

    public enum userAccountTypes {
        Admin,
        User;

        userAccountTypes() {}
    }

    public enum userTypes {
        Student,
        Teacher,
        Consultant;

        userTypes() {}
    }

    public String[] extractUserNameAndPassword(WebDriver driver, String text) {
        List<WebElement> elements =  driver.findElements(XpathStore.userNamePasswordLocator_loginPage);
//        System.out.println(elements.size());
//        System.out.println(elements.getFirst().getText());
//        System.out.println(elements.getLast().getText());
        Assert.assertEquals(elements.size(), 2, "Failed to fetch username and Password");
        String[] credentials = new String[elements.size()];
        credentials[0] = elements.getFirst().getText();
        credentials[1] = elements.get(1).getText();
        return credentials;
    }

    public void selectAccountType(WebDriver driver, String elementName) {
        List<WebElement> checkboxes_Elements = driver.findElements(XpathStore.radioButtonClass_loginPage);
        for (WebElement e : checkboxes_Elements) {
            if (e.getText().trim().equalsIgnoreCase(elementName)) {
                e.click();
                break;
            }
        }
    }

    public HashMap<String, Integer> addAllProductsToCart(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(XpathStore.listOfProducts_loginPage));
        List<WebElement> allProducts = driver.findElements(XpathStore.listOfProducts_loginPage);
        HashMap<String, Integer> listOfProducts = new HashMap<>();
        for (WebElement e : allProducts) {
            String elementText = e.getText();
            System.out.println(elementText);
            listOfProducts.put(elementText, listOfProducts.getOrDefault(elementText, 0)+1);
        }

        List<WebElement> elements = driver.findElements(By.className("btn-info"));
        for (WebElement element : elements) {
            element.click();
        }
        return listOfProducts;
    }

}
