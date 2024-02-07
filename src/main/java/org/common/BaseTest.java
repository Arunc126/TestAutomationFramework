package org.common;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.utilities.ExcelUtils;
import org.utilities.HTMLReporter;
import org.utilities.RestAssuredUtils;
import org.utilities.SeleniumUtils;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class BaseTest extends HTMLReporter{

    protected WebDriver driver;
    protected RestAssuredUtils restAssuredUtils;
    protected ExcelUtils excelUtils;
    protected HTMLReporter htmlReporter;

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(String browser, Method method) {
        // Initialize WebDriver using existing Selenium utility class
        driver = SeleniumUtils.initWebDriver(browser);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Initialize RestAssuredUtils
        restAssuredUtils = new RestAssuredUtils("http://api.example.com");

        // Initialize ExcelUtils
        excelUtils = new ExcelUtils();

        // Initialize HTMLReporter
        htmlReporter = new HTMLReporter();
        htmlReporter.startReport("test-output/report.html");
        htmlReporter.createTest(method.getName());
    }

    @AfterMethod
    public void tearDown() {
        // Close WebDriver
        if (driver != null) {
            driver.quit();
        }

        // Flush HTML report
        if (htmlReporter != null) {
            htmlReporter.flushReport();
        }
    }

    @DataProvider(name = "testData")
    public Object[][] testData() {
        // Read test data from Excel
        return excelUtils.readTestData("TestDataSheet");
    }
}

