Feature: Testing Check Out functionality

  Background: 
    Given user is on Sauce Demo login page
    When user enters valid username standard_user and valid password secret_sauce
    And clicks on login
    Then user should be navigated to home page

  @checkout
  Scenario: Validation of checkout feature
    When user adds multiple products <products> to the cart then the products should show up in cart
      | Product                  |
      | Sauce Labs Backpack      |
      | Sauce Labs Bike Light    |
      | Sauce Labs Fleece Jacket |
    Then user navigates to Checkout page
    And user enters firstname, lastname and zipcode
    And clicks on continue and navigated to overview page
    And user validates whether the price total and total product price are equal
    And user clicks on finish button
