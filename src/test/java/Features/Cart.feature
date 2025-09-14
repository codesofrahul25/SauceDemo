Feature: Testing cart functionality

  Background: 
    Given user is on Sauce Demo login page
    When user enters valid username standard_user and valid password secret_sauce
    And clicks on login
    Then user should be navigated to home page

  @add_to_cart
  Scenario Outline: Testing the add to cart functionality
    When user finds the product <Product> they are looking for and clicks on add to cart button
    Then the products should get added in the cart

    Examples: 
      | Product                           |
      | Sauce Labs Backpack               |
      | Sauce Labs Bike Light             |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |

  @add_multiple_pdt
  Scenario: Testing the add to cart functionality for multiple products
    When user adds multiple products <products> to the cart then the products should show up in cart
      | Product               |
      | Sauce Labs Backpack   |
      | Sauce Labs Bike Light |

  @remove_from_cart
  Scenario Outline: Testing the remove from cart functionality
    When user finds the product <Product> they are looking for and clicks on add to cart button
    Then the products should get added in the cart
    When user clicks on remove button of the <Product> then the product is removed

    Examples: 
      | Product                           |
      | Sauce Labs Backpack               |
      | Sauce Labs Bike Light             |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |
