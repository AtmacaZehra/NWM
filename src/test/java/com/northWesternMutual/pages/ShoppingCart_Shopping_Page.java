package com.northWesternMutual.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCart_Shopping_Page extends BasePage {

    @FindBy(xpath = "//title[.='Swag Labs']")
    public WebElement pageTitle;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    public WebElement productSortContainer;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-onesie']")
    public WebElement itemOnesie;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']")
    public WebElement itemBikeLight;


    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")
    public WebElement itemTShirtBlack;

    @FindBy(xpath = "//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")
    public WebElement itemTShirtRed;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    public WebElement itemBackPack;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-fleece-jacket']")
    public WebElement itemJacket;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    public WebElement shoppingCart;

    @FindBy(xpath = "//div[.='Sauce Labs Onesie']")
    public WebElement oneSieSC;

    @FindBy(xpath = "//div[.='Test.allTheThings() T-Shirt (Red)']")
    public WebElement tShirtRedSC;

    @FindBy(xpath = "//div[.='Sauce Labs Bike Light']")
    public WebElement bikeLightSC;

    @FindBy(xpath = "//div[.='Sauce Labs Bolt T-Shirt']")
    public WebElement tShirtSC;

    @FindBy(xpath = "//div[.='Sauce Labs Backpack']")
    public WebElement backpackSC;

    @FindBy(xpath = "//div[.='Sauce Labs Fleece Jacket']")
    public WebElement fleecejacketSC;

    @FindBy(id = "remove-sauce-labs-onesie")
    public WebElement removeOnesie;

    @FindBy(id = "remove-sauce-labs-bike-light")
    public WebElement removeBikeLight;

    @FindBy(id = "remove-sauce-labs-bolt-t-shirt")
    public WebElement removeBlackTShirt;

    @FindBy(id = "remove-test.allthethings()-t-shirt-(red)")
    public WebElement removeRedTShirt;

    @FindBy(id = "remove-sauce-labs-backpack")
    public WebElement removeBackPack;

    @FindBy(id = "remove-sauce-labs-fleece-jacket")
    public WebElement removeJacket;

    @FindBy(id = "continue-shopping")
    public WebElement ContinueShopping;

    @FindBy(xpath = "//button[@id='checkout']")
    public WebElement checkout;

    @FindBy(id = "continue")
    public WebElement continueToCheckOut;

    @FindBy(id = "first-name")
    public WebElement firstName;

    @FindBy(id = "last-name")
    public WebElement lastName;

    @FindBy(id = "postal-code")
    public WebElement postalCode;

    @FindBy(xpath = "//div[@class='summary_total_label']")
    public WebElement totalPrice;


    @FindBy(id = "continue")
    public WebElement continueBtn;

    public void checkOutToFinish(String username, String lastname, String zipNo) {
        firstName.sendKeys(username);
        lastName.sendKeys(lastname);
        postalCode.sendKeys(zipNo);


    }
}