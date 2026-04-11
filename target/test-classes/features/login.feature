Feature: Login functionality

  Scenario: Valid login

    Given User is on login page
    When User enters username "admin" and password "admin123"
    And User clicks on login button
    Then User should see the homepage