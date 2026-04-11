package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class DashBoardPage {

    private WebDriver driver;

    // Locators (adjust according to your app)
    private By addEmployeeMenu = By.id("addEmployeeMenu"); // menu/button to open Add Employee page
    private By firstNameField = By.id("firstName");
    private By lastNameField = By.id("lastName");
    private By emailField = By.id("email");
    private By saveButton = By.id("saveEmployee");
    private By employeeTableRows = By.cssSelector("#employeeTable tbody tr");

    public DashBoardPage(WebDriver driver) {
        this.driver = driver;
    }

    // Navigate to Add Employee Page
    public void goToAddEmployeePage() {
        driver.findElement(addEmployeeMenu).click();
    }

    // Add new employee
    public void addEmployee(String firstName, String lastName, String email) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(saveButton).click();
    }

    // Verify if employee exists in employee list
    public boolean isEmployeePresent(String fullName) {
        List<WebElement> rows = driver.findElements(employeeTableRows);
        for (WebElement row : rows) {
            if (row.getText().contains(fullName)) {
                return true;
            }
        }
        return false;
    }
}