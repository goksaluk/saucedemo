@login
Feature: Shopping successfully
  Background:
    Given the user the login page

  Scenario Outline: Shopping with valid credentials (positive)
    When the user logs in valid "<username>" and "<password>"
    Then the user is on the product page
    And the user arranges the page according to the "<priceRequirement>"
    And the user adds some products to the cart
    When the user is on the cart page
    Then the user removes a product from the cart
    And the user continues to shop by adding two more products
    And the user is on the cart page
    And the user clicks the checkout button and sees 3 products on the page and click the checkout button
    When the user enters their name and post code on the information page
    Then the true payment information and 3 items are visible to the user
    And the user clicks the finish button
    And the complete page is visible to the user and the user clicks the backhome button
    Then the user is on the product page

    Examples:
    |    username     |   password   | priceRequirement    |
    | standard_user   | secret_sauce | Name (A to Z)       |
    | standard_user   | secret_sauce | Name (Z to A)       |
    | standard_user   | secret_sauce | Price (low to high) |
    | standard_user   | secret_sauce | Price (high to low) |
    | locked_out_user | secret_sauce | Name (A to Z)       |
    | locked_out_user | secret_sauce | Name (Z to A)       |
    | locked_out_user | secret_sauce | Price (low to high) |
    | locked_out_user | secret_sauce | Price (high to low) |


  Scenario: Logging with invalid username (negative)
    When the user logs in invalid "locked_out_user" and "secret_sauce"
    And  the warning message is visible to the user

  Scenario: Logging with invalid password (negative)
    When the user logs in invalid "standard_user" and "drt43_9iok7"
    And different warning message is visible to the user

