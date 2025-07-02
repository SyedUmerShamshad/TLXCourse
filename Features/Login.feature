Feature: Demo Login

  Scenario Outline: Training website login screen
    Given User opens URL
    When User enters <Username> and <Password>
    And User clicks "login-Button"
    And User clicks on "Menu-Button"
    And User clicks at "Logout-Button"

    Examples:
   | Username | Password |
   | standard_user | secret_sauce |