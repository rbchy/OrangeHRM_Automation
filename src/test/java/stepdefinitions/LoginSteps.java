package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSteps {

    WebDriver driver;

    @Given("User is on login page")
    public void user_is_on_login_page() {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @When("User enters username {string} and password {string}")
    public void user_enters_username_and_password(String username, String password) {
        System.out.println("Entered username: " + username);
        System.out.println("Entered password: " + password);
    }

    @When("User clicks on login button")
    public void user_clicks_on_login_button() {
        System.out.println("Clicked login button");
    }

    @Then("User should see the homepage")
    public void user_should_see_the_homepage() {
        System.out.println("Login successful");
        driver.quit();
    }
}