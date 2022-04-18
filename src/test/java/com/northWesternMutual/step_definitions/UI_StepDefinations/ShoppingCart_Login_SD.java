package com.northWesternMutual.step_definitions.UI_StepDefinations;

import com.northWesternMutual.pages.ShoppingCart_Login_Page;
import com.northWesternMutual.pages.ShoppingCart_Shopping_Page;
import com.northWesternMutual.utilites.Browser_utilities;
import com.northWesternMutual.utilites.ConfigurationReader;
import com.northWesternMutual.utilites.Driver_utilities;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static org.junit.Assert.assertTrue;

public class ShoppingCart_Login_SD {

    ShoppingCart_Login_Page loginPage = new ShoppingCart_Login_Page();
    ShoppingCart_Shopping_Page shoppingPage = new ShoppingCart_Shopping_Page();

    @Given("user is on SwagLabs login page")
    public void user_is_on_SwagLabs_login_page() {
        String url = ConfigurationReader.getProperty("sauceDemoUrl");
        Driver_utilities.getDriver().get(url);

    }

    @When("user logs in with valid credentials")
    public void user_logs_in_with_valid_credentials() {

     loginPage.login(ConfigurationReader.getProperty("username"),
             ConfigurationReader.getProperty("password"));
    }

    @Then("user should see SwagLabs home page")
    public void user_should_see_SwagLabs_home_page() {

        Browser_utilities.assertTitle("Swag Labs");
    }


}
