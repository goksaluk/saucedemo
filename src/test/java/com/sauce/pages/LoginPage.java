package com.sauce.pages;

import com.sauce.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    public WebElement usernameElement;

    @FindBy(id = "password")
    public WebElement passwordElement;

    @FindBy(id = "login-button")
    public  WebElement loginButton;

    @FindBy(css = "[data-test='error']")
    public WebElement errorMessage;


    public void login(String username, String password) {
        BrowserUtils.waitForVisibility(usernameElement,5);
        usernameElement.sendKeys(username);
        passwordElement.sendKeys(password);
        BrowserUtils.waitForClickablility(loginButton,3);
        loginButton.click();
   }

   public String getErrorMessage() {
        BrowserUtils.waitForVisibility(errorMessage,3);
        return errorMessage.getText();
   }

}
