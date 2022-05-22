package com.sauce.step_definitions;

import com.sauce.pages.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CartSteps {
    CartPage cartPage = new CartPage();
    ProductsPage productsPage = new ProductsPage();
    CompletePage completePage = new CompletePage();


    @When("the user is on the cart page")
    public void the_user_on_the_chart_page() {
        productsPage.clickCartIcon();
        Assert.assertEquals("Your Cart", cartPage.getPageTitle());
    }

    @Then("the user removes a product from the cart")
    public void the_user_removes_a_product_from_the_chart() {
        cartPage.removeAProduct();
    }

    @Then("the user continues to shop by adding two more products")
    public void the_user_continues_to_shopping_by_adding_two_more_products() {
        cartPage.clickContinueShoppingButton();
        Assert.assertEquals("Products", productsPage.getPageTitle());
        productsPage.addTwoMoreProductsToChart();
        productsPage.clickCartIcon();
    }

    @Then("the user clicks the checkout button and sees {} products on the page and click the checkout button")
    public void the_user_clicks_to_checkout_button(int numberOfProducts) {
        Assert.assertEquals("Your Cart", cartPage.getPageTitle());
        Assert.assertEquals(numberOfProducts, cartPage.getNumberOfProducts());
        cartPage.clickCheckoutButton();
    }

    @Then("the complete page is visible to the user and the user clicks the backhome button")
    public void complete_page_is_visible_to_the_user_the_user_clicks_the_backhome_button() {
        Assert.assertEquals("Checkout: Complete!", completePage.getClass());
    }

}
