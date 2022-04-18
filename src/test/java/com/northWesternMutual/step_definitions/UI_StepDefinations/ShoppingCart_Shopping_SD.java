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

public class ShoppingCart_Shopping_SD {
    ShoppingCart_Shopping_Page shoppingPage = new ShoppingCart_Shopping_Page();
    ShoppingCart_Login_Page loginPage = new ShoppingCart_Login_Page();

    @Given("user on SwagLabs home page")
    public void userOnSwagLabsHomePage() {

        String url = ConfigurationReader.getProperty("sauceDemoUrl");
        Driver_utilities.getDriver().get(url);

        loginPage.login(ConfigurationReader.getProperty("username"),
                ConfigurationReader.getProperty("password"));

    }


    @And("user sorts the items lowest price to highest price")
    public void userSortsTheItemsLowestPriceToHighestPrice() {

        Browser_utilities.selectDropdown(shoppingPage.productSortContainer, "Price (low to high)");
    }


    @And("user adds two or more items to the shopping cart")
    public void user_adds_two_or_more_items_to_the_shopping_cart() {
        shoppingPage.itemOnesie.click();
        shoppingPage.itemBackPack.click();
        shoppingPage.itemTShirtRed.click();
        shoppingPage.itemBikeLight.click();

    }

    @When("user visits the shopping cart")
    public void user_visits_the_shopping_cart() {
        shoppingPage.shoppingCart.click();

        assertTrue(shoppingPage.oneSieSC.isDisplayed());
        assertTrue(shoppingPage.backpackSC.isDisplayed());
        assertTrue(shoppingPage.tShirtRedSC.isDisplayed());
        assertTrue(shoppingPage.bikeLightSC.isDisplayed());
    }

    @Then("user should be able to remove item from shopping cart")
    public void user_should_be_able_to_remove_item_from_shopping_cart() {
        shoppingPage.removeBackPack.click();

    }

    @Then("user should be able to continue shopping")
    public void user_should_be_able_to_continue_shopping() {
        shoppingPage.ContinueShopping.click();
    }

    @Then("user should be able to add another item to shopping cart")
    public void user_should_be_able_to_add_another_item_to_shopping_cart() {
        shoppingPage.itemTShirtBlack.click();
        shoppingPage.shoppingCart.click();
    }

    @Then("user should be able to checkout")
    public void user_should_be_able_to_checkout() {
        shoppingPage.checkout.click();

        shoppingPage.checkOutToFinish("Zehra", "Atmaca", "10547");
        shoppingPage.continueBtn.click();

        assertTrue(shoppingPage.oneSieSC.isDisplayed());
        assertTrue(shoppingPage.bikeLightSC.isDisplayed());
        assertTrue(shoppingPage.tShirtRedSC.isDisplayed());
        assertTrue(shoppingPage.tShirtSC.isDisplayed());

        shoppingPage.totalPrice.getAttribute("value");
        System.out.println("shoppingPage.totalPrice.getAttribute(\"value\") = " + shoppingPage.totalPrice.getAttribute("value"));



    }


}






