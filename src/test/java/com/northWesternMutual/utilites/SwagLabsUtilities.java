package com.northWesternMutual.utilites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SwagLabsUtilities {

    public static void loginToSwagLabs(WebDriver driver){

        WebElement inputUsername = driver.findElement(By.xpath("//input[@id='user-name']"));
        inputUsername.sendKeys("standard_user");

        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='password']"));
        inputPassword.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.xpath("//button[@id='login-button']"));
        loginButton.click();
    }
}
