package com.sauce.pages;

import com.sauce.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompletePage extends BasePage {

    @FindBy(id = "back-to-products")
    public  WebElement backHomeButton;

    public void clickBackHomeButton(){
        BrowserUtils.waitForClickablility(backHomeButton,3);
        backHomeButton.click();
    }




}
