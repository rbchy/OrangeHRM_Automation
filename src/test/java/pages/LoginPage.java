package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class LoginPage {

    private final WebDriver driver;

    private final By usernameField = By.name("username");
    private final By passwordField = By.name("password");
    private final By loginButton = By.xpath("//button[@type='submit']");
    private final By dashboardHeader = By.xpath("//h6[normalize-space()='Dashboard']");
    private final By errorAlert = By.cssSelector(".oxd-alert-content-text");
    private final By userMenu = By.cssSelector(".oxd-userdropdown-tab");
    private final By logoutLink = By.xpath("//a[normalize-space()='Logout']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String url) {
        driver.get(url);
        WaitUtils.visible(driver, usernameField);
    }

    public void enterCredentials(String username, String password) {
        WaitUtils.visible(driver, usernameField).sendKeys(username);
        WaitUtils.visible(driver, passwordField).sendKeys(password);
    }

    public void submit() {
        WaitUtils.clickable(driver, loginButton).click();
    }

    public boolean isDashboardShown() {
        try {
            return WaitUtils.visible(driver, dashboardHeader).isDisplayed() && driver.getCurrentUrl().contains("dashboard");
        } catch (Exception e) {
            return false;
        }
    }

    public String errorMessage() {
        return WaitUtils.visible(driver, errorAlert).getText().trim();
    }

    public void logout() {
        WaitUtils.clickable(driver, userMenu).click();
        WaitUtils.clickable(driver, logoutLink).click();
    }

    public boolean isLoginFormShown() {
        try {
            WaitUtils.urlContains(driver, "auth/login");
            return WaitUtils.visible(driver, usernameField).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
