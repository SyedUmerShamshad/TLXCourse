Feature: Demo Login

  Scenario Outline: Training website login screen
    Given User loads test data at index <index>
    Given User opens URL
    When User enters username and password from JSON
    And User clicks "login-Button"
    And User clicks on "Menu-Button"
    And User clicks at "Logout-Button"

    Examples:
      | index |
      | 0     |
      | 1     |
