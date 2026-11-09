package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/** Explicit waits used by every page object (no Thread.sleep anywhere). */
public final class WaitUtils {

    private WaitUtils() {
    }

    private static WebDriverWait waitFor(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.getInt("explicit.wait")));
    }

    public static WebElement visible(WebDriver driver, By locator) {
        return waitFor(driver).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement clickable(WebDriver driver, By locator) {
        return waitFor(driver).until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void urlContains(WebDriver driver, String fragment) {
        waitFor(driver).until(ExpectedConditions.urlContains(fragment));
    }

    public static void textPresent(WebDriver driver, By locator, String text) {
        waitFor(driver).until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    /** OrangeHRM shows a full-page loader between screens; wait until it is gone. */
    public static void loaderGone(WebDriver driver) {
        waitFor(driver).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".oxd-form-loader, .oxd-loading-spinner")));
    }
}
