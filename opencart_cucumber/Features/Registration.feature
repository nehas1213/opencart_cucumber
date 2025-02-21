Feature: Account Registration

  @regression
  Scenario: Successful Account Registration
    Given user navigates to Register Account Page
    When the user enters details into below fields
      | firstName | John     |
      | lastname  | Kenedy   |
      | password  | test@123 |
    And then user selects privacy policy
    And the user clicks on continue button
    Then the user account should get created successfully
