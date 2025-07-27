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

    //Xpath/Css Locators from Assignment 2 -> RSA Login Page Practice
    By getUserNamePasswordString = By.xpath("//*[@class='text-center text-white']");
    By userNamePasswordLocator_loginPage = By.xpath("//p[@class='text-center text-white']/b");
    By username_loginPage = By.id("username");
    By password_loginPage = By.id("password");
    By radioButtonClass_loginPage = By.className("radiotextsty");
    By radioButtons_loginPage = By.xpath("//input[@type='radio']/following-sibling::span");
    By selectUserType_loginPage = By.xpath("//select[@class='form-control']");
    By checkboxTOS_loginPage = By.cssSelector("[id='terms']");
    By signInButton_loginPage = By.id("signInBtn");
    By popupUserType_loginPage = By.xpath("//div[@id='myModal' and @class='modal fade show']");
    By popupOk_loginPage = By.id("okayBtn");
    By listOfProducts_loginPage = By.xpath("//app-card-list[@class='row']//h4[@class='card-title']");
    By intCartItems_loginPage = By.xpath("//*[@id='navbarResponsive']//li[@class='nav-item active']//a");

    //Xpath/css locators from HerokuApp
    By herokuAppClickElement = By.cssSelector("div[id='start'] button");
    String loadingTextXpath = "//div[@id='loading']/text()";
    By loadingImgCssElement = By.cssSelector("div[id='loading'] img");
    By helloWorldTextElement = By.cssSelector("div[Id='finish'] h4");
}
