package com.sauce.pages;

import com.sauce.utilities.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CheckoutOverview extends BasePage{

    @FindBy(css = "[class='cart_item']")
    public List<WebElement> myCartItems;

    @FindBy(xpath = "(//div[@class='inventory_item_price'])[1]")
    public WebElement firstItem;

    @FindBy(xpath = "(//div[@class='inventory_item_price'])[2]")
    public WebElement secondItem;

    @FindBy(xpath = "(//div[@class='inventory_item_price'])[3]")
    public WebElement thirdItem;

    @FindBy(xpath = "(//*[contains(@class,'Payment Information:")
    public WebElement paymentInformation;

    @FindBy(xpath = "(//*[contains(@class,'Shipping Information:")
    public WebElement shippingInformation;

    @FindBy(css = "[class='summary_total_label']")
    public WebElement totalPayment;

    @FindBy(id = "finish")
    public  WebElement finishButton;

    @FindBy(id = "cancel")
    public  WebElement cancelButton;


    public int getNumberOfProducts(){
        List<WebElement> numberOfProducts= new ArrayList<>();
        for (WebElement item: myCartItems){
            numberOfProducts.add(item);
        }
        return numberOfProducts.size();
    }

    public int getPrice(String price) {
        int priceFigure= Integer.valueOf(price.substring(1,price.length()).replace(".",""));
        return priceFigure;
    }

    public int getFirstProductFigure(){
        return getPrice(firstItem.getText());
    }

    public int getSecondProductFigure(){
        return getPrice(secondItem.getText());
    };

    public int getThirdProductFigure(){
        return getPrice(thirdItem.getText());
    };

    public void clickFinishButton(){
        BrowserUtils.waitForClickablility(finishButton,3);
        finishButton.click();
    }







}
