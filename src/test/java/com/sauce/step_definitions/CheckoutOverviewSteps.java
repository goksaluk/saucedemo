package com.sauce.step_definitions;

import com.sauce.pages.CheckoutOverview;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class CheckoutOverviewSteps {

    CheckoutOverview checkoutOverview = new CheckoutOverview();



    @Then("the true payment information and {} items are visible to the user")
    public void the_products_purchased_and_the_payment_information_are_visible_to_the_user(int numberOfProducts) {
        Assert.assertEquals("CHECKOUT: OVERVIEW",checkoutOverview.getPageTitle() );
        Assert.assertEquals(numberOfProducts, checkoutOverview.getNumberOfProducts());
        int totalPrice= checkoutOverview.getFirstProductFigure()+checkoutOverview.getSecondProductFigure()+checkoutOverview.getThirdProductFigure();
        Assert.assertEquals(6797,totalPrice);
    }

    @Then("the user clicks the finish button")
    public void the_user_clicks_finish_button() {
        checkoutOverview.clickFinishButton();
    }

}
