package Utility;

import org.openqa.selenium.By;

public interface XpathStore {

    //Xpath/Css Locators from Green Kart -> Vegetable Store
    By getProductNamesByXpath = By.xpath("//div[@class='products']//h4[@class='product-name']");
    By getAddToCartElement = By.xpath("//div[@class='products']//button[text()='ADD TO CART']");
    By addToCartByParentElement = By.xpath("//*[@class='product-action']/button");
    By cartElementVegetableSore = By.cssSelector("a[class='cart-icon'] img");
    By getTotalNumberOfItemsElement = By.xpath("//div[@class='cart-info']//td[text()='Items']/following-sibling::td/strong");
    By proceedToCheckOutElement = By.xpath("//*[text()='PROCEED TO CHECKOUT']");
    By enterPromoCodeElement = By.cssSelector("div[class='promoWrapper']  input");
    By discountedAmountLocator = By.xpath("//*[contains(text(), 'Total After Discount')]/following-sibling::span[@class='discountAmt']");
    By promoInfoElementLocator = By.xpath("//button[@class='promoBtn' and text()='Apply']/following-sibling::span[@class='promoInfo']");


}
