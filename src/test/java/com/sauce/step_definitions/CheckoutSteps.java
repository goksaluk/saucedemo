package com.sauce.step_definitions;

import com.sauce.pages.CheckoutPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CheckoutSteps {

    CheckoutPage checkoutPage = new CheckoutPage();


    @When("test")
    public void ttest() {
        checkoutPage.clickContact();
//        Assert.assertEquals("CHECKOUT: YOUR INFORMATION", checkoutPage.getPageTitle());
//        checkoutPage.enterCredentials();
//        checkoutPage.clickContinueButton();
    }

}
