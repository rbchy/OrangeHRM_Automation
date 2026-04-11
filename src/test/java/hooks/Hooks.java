package hooks;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import stepdefinitions.CommonSteps;

public class Hooks {

    public static ExtentReports extent;
    public static ExtentTest test;

    @BeforeAll
    public static void setupReport() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("target/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
    }

    @Before
    public void setup(Scenario scenario) {

        // Start test report
        test = extent.createTest(scenario.getName());

        // Setup browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Store driver globally
        CommonSteps.driver = driver;
    }

    @After
    public void tearDown() {
        if (CommonSteps.driver != null) {
            CommonSteps.driver.quit();
        }
    }

    @AfterAll
    public static void tearDownReport() {
        extent.flush();
    }
}