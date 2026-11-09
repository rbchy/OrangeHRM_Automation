package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

/** PIM › Add Employee, and the Personal Details page that opens after a save. */
public class AddEmployeePage {

    private final WebDriver driver;

    private final By pimMenu = By.xpath("//span[normalize-space()='PIM']");
    private final By addEmployeeLink = By.xpath("//a[normalize-space()='Add Employee']");
    private final By firstName = By.name("firstName");
    private final By lastName = By.name("lastName");
    private final By saveButton = By.xpath("//button[@type='submit']");
    private final By requiredError = By.cssSelector(".oxd-input-field-error-message");
    private final By profileName = By.cssSelector(".orangehrm-edit-employee-name h6");

    public AddEmployeePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        WaitUtils.clickable(driver, pimMenu).click();
        WaitUtils.clickable(driver, addEmployeeLink).click();
        WaitUtils.urlContains(driver, "pim/addEmployee");
        WaitUtils.visible(driver, firstName);
        WaitUtils.loaderGone(driver);
    }

    public void fill(String first, String last) {
        WaitUtils.visible(driver, firstName).sendKeys(first);
        WaitUtils.visible(driver, lastName).sendKeys(last);
    }

    public void save() {
        WaitUtils.clickable(driver, saveButton).click();
    }

    /** After a successful save OrangeHRM opens the new employee's Personal Details page. */
    public String savedEmployeeName() {
        WaitUtils.urlContains(driver, "pim/viewPersonalDetails/empNumber/");
        WaitUtils.loaderGone(driver);
        return WaitUtils.visible(driver, profileName).getText().trim();
    }

    public String fieldError() {
        return WaitUtils.visible(driver, requiredError).getText().trim();
    }

    public boolean stillOnAddEmployee() {
        return driver.getCurrentUrl().contains("pim/addEmployee");
    }
}
