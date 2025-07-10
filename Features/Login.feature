Feature: Demo Login

  Scenario Outline: Training website login screen
    Given User opens URL
    When User enters invalid User and Pass
    Given User loads test data at index <index>
    When User enters username and password from JSON
    And User clicks "login-Button"
    And User clicks on "Menu-Button"
    And User clicks at "Logout-Button"

    Examples:
      | index |
      | 0     |
      | 1     |
