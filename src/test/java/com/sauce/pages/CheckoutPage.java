package com.sauce.pages;

import com.sauce.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    @FindBy(id = "first-name")
    public WebElement firstName;

    @FindBy(id = "last-name")
    public  WebElement lastName;

    @FindBy(id = "postal-code")
    public  WebElement postCode;

    @FindBy(id = "continue")
    public  WebElement continueButton;



    public void enterCredentials(){
        BrowserUtils.waitForClickablility(firstName,3);
        firstName.sendKeys("John");
        lastName.sendKeys("Walley");
        postCode.sendKeys("M5 5YT");
    }

    public void clickContinueButton(){
        continueButton.click();
    }



}
