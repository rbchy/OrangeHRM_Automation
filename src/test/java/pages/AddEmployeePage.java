package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddEmployeePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public AddEmployeePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // ✅ NEW LOCATORS (UPDATED FOR ORANGEHRM UI)
    private By pimMenu = By.xpath("//span[text()='PIM']");
    private By addEmployeeBtn = By.xpath("//a[text()='Add Employee']");
    private By firstName = By.name("firstName");
    private By lastName = By.name("lastName");
    private By saveButton = By.xpath("//button[@type='submit']");

    // ✅ NAVIGATION FIXED
    public void navigateToAddEmployee() {

        // Wait dashboard fully loaded
        wait.until(ExpectedConditions.visibilityOfElementLocated(pimMenu));

        // Click PIM
        WebElement pim = wait.until(ExpectedConditions.elementToBeClickable(pimMenu));
        pim.click();

        System.out.println("Clicked PIM menu");

        // Wait Add Employee button visible
        WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(addEmployeeBtn));
        addBtn.click();

        System.out.println("Clicked Add Employee");
    }

    // ✅ ADD EMPLOYEE
    public void addEmployee(String fName, String lName) {

        navigateToAddEmployee();

        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys(fName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastName)).sendKeys(lName);

        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();

        System.out.println("Employee added successfully!");
    }
}