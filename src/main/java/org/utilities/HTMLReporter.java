package org.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class HTMLReporter {

    private static ExtentReports extent;
    private static ExtentHtmlReporter htmlReporter;
    public static ExtentTest test;

    public static void startReport(String reportPath) {
        htmlReporter = new ExtentHtmlReporter(reportPath);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    public static void createTest(String testName) {
        test = extent.createTest(testName);
    }

    public static void logInfo(String message) {
        test.info(message);
    }

    public static void logPass(String message) {
        test.pass(message);
    }

    public static void logFail(String message) {
        test.fail(message);
    }

    public static void flushReport() {
        extent.flush();
    }
}

