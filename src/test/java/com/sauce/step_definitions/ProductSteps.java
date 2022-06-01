package com.sauce.step_definitions;

import com.sauce.pages.CartPage;
import com.sauce.pages.ProductsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductSteps {

    ProductsPage productsPage = new ProductsPage();
    CartPage cartPage = new CartPage();


    @Then("the user is on the product page")
    public void the_user_is_on_the_product_page() {
        productsPage.getPageTitle();
        Assert.assertEquals("PRODUCTS", productsPage.getPageTitle());
    }

    @Then("the user arranges the page according to the {string}")
    public void the_user_arranges_the_page_according_to_the_Name_A_to_Z(String priceRequirement) {
        productsPage.selectPriceRequirements(priceRequirement);

    }

    @Then("the user adds some products to the cart")
    public void the_user_adds_some_products_to_the_chart() {
        productsPage.addTwoProductsToChart();
    }

    @Then("the user continues to shop by adding two more products")
    public void the_user_continues_to_shopping_by_adding_two_more_products() {
        cartPage.clickContinueShoppingButton();
        Assert.assertEquals("PRODUCTS", productsPage.getPageTitle());
        productsPage.addTwoMoreProductsToChart();
        productsPage.clickCartIcon();
    }



}
