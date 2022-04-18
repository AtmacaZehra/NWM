package com.northWesternMutual.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ShoppingCart_Login_Page extends BasePage{


    @FindBy(id = "user-name")
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "login-button")
    public WebElement loginButton;

    public void login(String username, String pswd){
        userName.sendKeys(username);
        password.sendKeys(pswd);
        loginButton.click();
    }

}
