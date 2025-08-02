package Components;

import Utility.BaseTest;
import Utility.XpathStore;
import com.aventstack.extentreports.Status;
import lombok.NonNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.Objects;
import java.util.TreeMap;

public class GreenKartConfigurations extends BaseTest {

    public static String convertEnumToString(Enum e) {
        return String.valueOf(e);
    }

    /**
     * List of Web Elements for Product(Vegetable) Name and their Add To Cart Text
     * Try to Ignore Text validation
     * Adds Products to the cart
     * @param driver
     * @param listOfVegetables
     */
    public TreeMap<String, Integer> addProductsToCart(WebDriver driver, List<String> listOfVegetables) {
        @NonNull
        String productNameFromDom = "";
        List<WebElement> productNameElement = driver.findElements(XpathStore.getProductNamesByXpath);
        List<WebElement> addToCartElement = driver.findElements(XpathStore.getAddToCartElement);
        List<WebElement> addToCartParentElement = driver.findElements(XpathStore.addToCartByParentElement);

        StringBuilder totalItemsInCart = new StringBuilder();
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        int index = 0;
        for (String s : listOfVegetables) {

            SeleniumTest.log(Status.INFO, "Adding " + s + " into cart");
            for (int j = 0; j < productNameElement.size(); j++) {
                if (productNameElement.get(j).getText().replace(" ", "_").contains(s)) {
                    productNameFromDom = productNameElement.get(j).getText();
                    treeMap.put(productNameFromDom, treeMap.getOrDefault(productNameFromDom, 0) + 1);
                    index = j;
                    break;
                }
            }

            addToCartParentElement.get(index).click();
            Assert.assertTrue(Objects.requireNonNull(driver.getPageSource()).contains("✔ ADDED"), "Unable to validate Text: ✔ ADDED");
            SeleniumTest.log(Status.PASS, "Item Added to Cart: " + textColorOrange(productNameFromDom));
            totalItemsInCart.append(productNameFromDom).append(", ");
        }

//        int totalNumberOfItems = String.valueOf(totalItemsInCart).split(", ").length;
//        Assert.assertEquals(listOfVegetables.size(), totalNumberOfItems, "Basket Size Mismatch");
//        SeleniumTest.log(Status.PASS, "Total Number of Items: " + totalNumberOfItems);
//        SeleniumTest.log(Status.INFO, "Total List Items in cart: " + textColorGreen(String.valueOf(totalItemsInCart)));
        return treeMap;

    }


}
