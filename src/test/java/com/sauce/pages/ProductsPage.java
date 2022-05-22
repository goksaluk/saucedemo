package com.sauce.pages;

import com.sauce.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage extends BasePage {

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public WebElement sauLabsBackpack;

    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    public WebElement sauceLabsOneise;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    public WebElement sauceLabsBikeLight;

    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    public WebElement sauceLabsFleeceJacket;

    @FindBy(css = "[class='product_sort_container']")
    public WebElement priceSelection;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    public WebElement shoppingCart;



    public void selectPriceRequirements(String priceOptions){
        Select select =new Select(priceSelection);
        select.selectByVisibleText(priceOptions);
    }

    public void addTwoProductsToChart(){
        BrowserUtils.waitForClickablility(sauceLabsOneise,5);
        sauceLabsOneise.click();
        sauLabsBackpack.click();
    }

    public void clickCartIcon() {
        BrowserUtils.waitForClickablility(shoppingCart, 5);
        shoppingCart.click();
    }

    public void addTwoMoreProductsToChart(){
        sauceLabsBikeLight.click();
        sauceLabsFleeceJacket.click();
    }








}
