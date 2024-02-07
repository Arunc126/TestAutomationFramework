package org.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumUtils {

    private WebDriver driver;
    private WebDriverWait wait;

    public SeleniumUtils(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public static WebDriver initWebDriver(String browser) {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriver driver = null;
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            default:
                System.out.println("Invalid browser specified");
        }
        return driver;
    }

    // Open URL
    public void openUrl(String url) {
        driver.get(url);
    }

    // Click element
    public void click(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    // Type text into element
    public void type(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.sendKeys(text);
    }

    // Get text of element
    public String getText(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element.getText();
    }

    // Close browser
    public void closeBrowser() {
        driver.quit();
    }
}
