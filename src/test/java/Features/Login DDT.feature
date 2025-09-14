Feature: login using exceel data

  @ddt
  Scenario Outline: Validation of login using excel data
    Given user is on Sauce Demo login page
    Then user passes credentials from excel <rows> and clicks on login button
    Then user should be navigated to home page

    Examples: 
      | rows |
      |    1 |
      |    2 |
      |    3 |
      |    4 |
      |    5 |
      
