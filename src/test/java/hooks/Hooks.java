package hooks;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.DriverManager;
import utils.ExtentManager;

/** One browser per scenario; Extent + Cucumber reports; screenshot on failure in both. */
public class Hooks {

    private static ExtentReports extent;
    private ExtentTest test;

    @BeforeAll
    public static void setupReport() {
        extent = ExtentManager.getInstance();
    }

    @Before
    public void setup(Scenario scenario) {
        test = extent.createTest(scenario.getName()).assignCategory(scenario.getSourceTagNames().toArray(new String[0]));
        DriverManager.start();
    }

    @After
    public void tearDown(Scenario scenario) {
        WebDriver driver = DriverManager.get();
        try {
            if (scenario.isFailed() && driver != null) {
                String base64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
                scenario.attach(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png", scenario.getName());
                test.fail("Scenario failed at " + driver.getCurrentUrl(),
                        MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build());
            } else {
                test.pass("Scenario passed");
            }
        } catch (Exception e) {
            System.err.println("Could not capture failure evidence: " + e.getMessage());
        } finally {
            DriverManager.quit();
        }
    }

    @AfterAll
    public static void tearDownReport() {
        extent.flush();
    }
}
