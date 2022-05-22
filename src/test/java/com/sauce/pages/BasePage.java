package com.sauce.pages;

import com.sauce.utilities.BrowserUtils;
import com.sauce.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public abstract class BasePage {

    public BasePage() { PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[class='title']")
    public WebElement title;

    public String getPageTitle(){
        BrowserUtils.waitForVisibility(title, 5);
        return title.getText();
    }






}
