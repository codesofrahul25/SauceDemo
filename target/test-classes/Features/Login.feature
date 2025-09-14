Feature: Testing of login functionality
	@positive
  Scenario Outline: Valid login
    Given user is on Sauce Demo login page
    When user enters valid username <user> and valid password <pwd>
    And clicks on login
    Then user should be navigated to home page

    Examples: 
      | user          |  | pwd          |
      | standard_user |  | secret_sauce |
      | problem_user  |  | secret_sauce |

	@negative
  Scenario: Invalid login
    Given user is on Sauce Demo login page
    When user enters valid username "standard_user" and invalid password "ram"
    And clicks on login
    Then user should get error message
