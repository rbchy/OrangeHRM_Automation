package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Automatically setup ChromeDriver for your OS
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver
        driver = new ChromeDriver();

        // Maximize browser window
        driver.manage().window().maximize();

        // Set implicit wait if needed
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open your application URL
        //driver.get("https://opensource-demo.orangehrmlive.com"); // <-- replace with your app URL
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}