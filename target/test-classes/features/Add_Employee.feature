Feature: Add Employee

  Scenario: Add a new employee
    Given I am logged in as "admin" with password "admin123"
    When I add a new employee with first name "John" and last name "Doe"
    Then the employee should be added successfully