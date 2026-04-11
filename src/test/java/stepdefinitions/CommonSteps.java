package stepdefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonSteps {

    public static WebDriver driver;
    public static WebDriver getDriver() {
        return driver;
    }

    @Given("I open the payroll application")
    public void i_open_the_payroll_application() {

        // Setup ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Initialize driver
        driver = new ChromeDriver();

        // Maximize window
        driver.manage().window().maximize();

        // Open application URL
        //driver.get("https://opensource-demo.orangehrmlive.com");
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Reporting
        System.out.println("Application launched");;
        
        
    }
}