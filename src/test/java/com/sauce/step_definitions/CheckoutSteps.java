package com.sauce.step_definitions;

import com.sauce.pages.CheckoutPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CheckoutSteps {

    CheckoutPage checkoutPage = new CheckoutPage();


    @When("the user enters their name and post code on the information page")
    public void the_user_enters_his_her_name_and_post_code_on_the_information_page() {
        Assert.assertEquals("CHECKOUT: YOUR INFORMATION", checkoutPage.getPageTitle());
        checkoutPage.enterCredentials();
        checkoutPage.clickContinueButton();
    }

}
