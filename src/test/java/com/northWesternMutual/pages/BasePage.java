package com.northWesternMutual.pages;

import com.northWesternMutual.utilites.Driver_utilities;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver_utilities.getDriver(), this);
    }
}
