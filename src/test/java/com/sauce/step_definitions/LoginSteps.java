package com.sauce.step_definitions;

import com.sauce.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();


    @Given("the user the login page")
    public void the_user_the_login_page() {
        loginPage.loginButton.isDisplayed();
    }

    @When("the user logs in valid {string} and {string}")
    public void the_user_logs_in_valid_standard_user_and_secret_sauce(String username, String password) {
        loginPage.login(username,password);
    }

    @When("the user logs in invalid {string} and {string}")
    public void the_user_logs_in_invalid_locked_out_user_and_secret_sauce(String username, String password) {
        loginPage.login(username,password);
    }

    @Given("the warning message is visible to the user")
    public void the_warning_message_is_visible_to_the_user() {
        Assert.assertEquals("Epic sadface: Sorry, this user has been locked out.", loginPage.getErrorMessage());
    }

    @Given("different warning message is visible to the user")
    public void different_warning_message_is_visible_to_the_user() {
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", loginPage.getErrorMessage());
    }

}
