package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerSetup {

    public static WebDriver driver;

    // Initialize the driver
    public static void setupDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    // Close the driver
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}