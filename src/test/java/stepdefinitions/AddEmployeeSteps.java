package stepdefinitions;

import io.cucumber.java.en.*;

public class AddEmployeeSteps {

    @Given("I am logged in as {string} with password {string}")
    public void i_am_logged_in_as_with_password(String username, String password) {
        System.out.println("Logged in with: " + username);
    }

    @When("I add a new employee with first name {string} and last name {string}")
    public void i_add_a_new_employee_with_first_name_and_last_name(String firstName, String lastName) {
        System.out.println("Adding employee: " + firstName + " " + lastName);
    }

    @Then("the employee should be added successfully")
    public void the_employee_should_be_added_successfully() {
        System.out.println("Employee added successfully");
    }
}