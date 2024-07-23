Feature: User Login

  Scenario: Successful Login
    Given navigate to signin page
    When give the valid email and password
    And click the submit button
    Then the user should see a Hello text along with his firstname

	