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

    @FindBy(id = "back-to-products")
    public  WebElement backhomeButton;

    @FindBy(linkText = "Contact us")
    public WebElement contact;

    @FindBy(xpath = "//*[@class='page-subheading']")
    public WebElement logo;

    public void clickContact() {
        BrowserUtils.waitForVisibility(contact,3);
        contact.click();
        BrowserUtils.waitForVisibility(logo,4);
    }



    public void enterCredentials(){
        BrowserUtils.waitForClickablility(firstName,3);
        firstName.sendKeys("John");
        lastName.sendKeys("Walley");
        postCode.sendKeys("M5 5YT");
    }

    public void clickContinueButton(){
        continueButton.click();
    }

    public void clickBackhomeButton(){
        backhomeButton.click();
    }



}
