package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;
import utils.ConfigReader;
import utils.DriverManager;

public class LoginSteps {

    private LoginPage login() {
        return new LoginPage(DriverManager.get());
    }

    @Given("User is on login page")
    public void user_is_on_login_page() {
        login().open(ConfigReader.get("base.url"));
    }

    @When("User enters username {string} and password {string}")
    public void user_enters_username_and_password(String username, String password) {
        login().enterCredentials(username, password);
    }

    @When("User clicks on login button")
    public void user_clicks_on_login_button() {
        login().submit();
    }

    @Then("User should see the dashboard")
    public void user_should_see_the_dashboard() {
        Assert.assertTrue(login().isDashboardShown(), "Dashboard did not load after login");
    }

    @Then("User should see the error {string}")
    public void user_should_see_the_error(String expected) {
        Assert.assertEquals(login().errorMessage(), expected, "Login error message");
    }

    @Given("User is logged in as admin")
    public void user_is_logged_in_as_admin() {
        login().open(ConfigReader.get("base.url"));
        login().enterCredentials(ConfigReader.get("admin.username"), ConfigReader.get("admin.password"));
        login().submit();
        Assert.assertTrue(login().isDashboardShown(), "Could not log in as admin");
    }

    @When("User logs out")
    public void user_logs_out() {
        login().logout();
    }

    @Then("User should be back on the login page")
    public void user_should_be_back_on_the_login_page() {
        Assert.assertTrue(login().isLoginFormShown(), "Login form did not return after logout");
    }
}
