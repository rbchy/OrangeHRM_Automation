package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.AddEmployeePage;

import java.time.Duration;

public class AddEmployeeTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private AddEmployeePage addEmployeePage;

    @BeforeClass
    public void setUp() {
        // ChromeDriver setup
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--remote-allow-origins=*"); // Fix CORS issues
        driver = new ChromeDriver(options);

        // Timeouts
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

        // Open login page
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Initialize pages
        loginPage = new LoginPage(driver);
        addEmployeePage = new AddEmployeePage(driver);

        // Login
        loginPage.login("admin", "admin123");
    }

    @Test(priority = 1)
    public void testAddEmployee() {
        addEmployeePage.addEmployee("John", "Doe");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed successfully.");
        }
    }
}