Feature: Testing cart functionality

  Background: 
    Given user is on Sauce Demo login page
    When user enters valid username standard_user and valid password secret_sauce
    And clicks on login
    Then user should be navigated to home page

  @sort_price_ascending
  Scenario: Test lowest price sort
    When user clicks on sorting option and selects low to high option
    Then all the products price should be sorted in ascending order

  @sort_price_descending
  Scenario: Test highest price sort
    When user clicks on sorting option and selects high to low option
    Then all the products price should be sorted in descending order
    
     @sort_name_descending
  Scenario: Test highest name sort
    When user clicks on sorting option and selects Z to A option
    Then all the products name should be sorted in descending order
    
    @sort_name_ascending
  Scenario: Test lowest name sort
    When user clicks on sorting option and selects A to Z option
    Then all the products name should be sorted in ascending order
    
    
