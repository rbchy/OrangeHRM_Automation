Feature: Login functionality
  As an HR administrator
  I want to sign in and out of OrangeHRM
  So that only authorised users reach HR data

  @smoke @regression @Login
  Scenario: Valid login opens the dashboard
    Given User is on login page
    When User enters username "Admin" and password "admin123"
    And User clicks on login button
    Then User should see the dashboard

  @regression @Login @negative
  Scenario: Invalid password is rejected
    Given User is on login page
    When User enters username "Admin" and password "wrongPassword1"
    And User clicks on login button
    Then User should see the error "Invalid credentials"

  @smoke @regression @Login
  Scenario: Logout returns to the login page
    Given User is logged in as admin
    When User logs out
    Then User should be back on the login page
