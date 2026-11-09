package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.AddEmployeePage;
import utils.DriverManager;

public class AddEmployeeSteps {

    private String firstName;
    private String lastName;

    private AddEmployeePage page() {
        return new AddEmployeePage(DriverManager.get());
    }

    /** A unique last name per run, so runs on the shared demo never collide. */
    private static String unique(String base) {
        return base + System.currentTimeMillis() % 1_000_000;
    }

    @When("User adds a new employee with first name {string} and last name {string}")
    public void user_adds_a_new_employee(String first, String last) {
        firstName = first;
        lastName = last.isEmpty() ? "" : unique(last);
        page().open();
        page().fill(firstName, lastName);
        page().save();
    }

    @Then("the new employee's profile should open with their name")
    public void the_new_employees_profile_should_open() {
        String shown = page().savedEmployeeName();
        Assert.assertEquals(shown, firstName + " " + lastName, "Name on the Personal Details page");
    }

    @Then("the form should show {string} and not save")
    public void the_form_should_show_and_not_save(String message) {
        Assert.assertEquals(page().fieldError(), message, "Field validation message");
        Assert.assertTrue(page().stillOnAddEmployee(), "The employee was saved without a last name");
    }
}
