Feature: Add Employee (PIM)
  As an HR administrator
  I want to add employees in PIM
  So that new hires appear in the HR system

  Background:
    Given User is logged in as admin

  @smoke @regression @PIM
  Scenario: Add a new employee
    When User adds a new employee with first name "John" and last name "Doe"
    Then the new employee's profile should open with their name

  @regression @PIM @negative
  Scenario: Last name is required
    When User adds a new employee with first name "John" and last name ""
    Then the form should show "Required" and not save
