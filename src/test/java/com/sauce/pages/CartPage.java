package com.sauce.pages;

import com.sauce.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

    @FindBy(id = "remove-sauce-labs-backpack")
    public WebElement removeButtonForBackpack;

    @FindBy(css = "[class='cart_item']")
    public List<WebElement> cartIttems;

    @FindBy(id = "continue-shopping")
    public  WebElement continueShoppingButton;

    @FindBy(id = "checkout")
    public  WebElement checkoutButton;


    public void removeAProduct(){
        BrowserUtils.waitForClickablility(removeButtonForBackpack,5);
        removeButtonForBackpack.click();
    }

    public void clickContinueShoppingButton(){
        BrowserUtils.waitForClickablility(continueShoppingButton,3);
        continueShoppingButton.click();
    }

    public void clickCheckoutButton(){
        BrowserUtils.waitForClickablility(checkoutButton,5);
        checkoutButton.click();
    }

    public int getNumberOfProducts(){
        List<WebElement> numberOfProducts= new ArrayList<>();
        for (WebElement item: cartIttems){
            numberOfProducts.add(item);
        }
        return numberOfProducts.size();
    }





}




