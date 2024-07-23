Feature: User Registration

  Scenario: Successful Registration
    Given navigate to registration page
    When give the below valid details
      | firstname | Test                  |
      | lastname  | QA                    |
      | password  | Kcqateam@12           |
    And give the baby birthdetilas
    And Check the 2  checkboxes
    And Submit the registration form
    Then Verify user is registerted Successfully
