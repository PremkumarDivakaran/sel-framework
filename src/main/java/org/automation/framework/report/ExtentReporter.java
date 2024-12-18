package org.automation.framework.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public final class ExtentReporter {

    private ExtentReporter(){}

    private static ExtentReports extent;

    public static void initReport() {
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("reports/index.html");
        extent.attachReporter(spark);
    }

    public static void createTest(String testName) {
        ExtentReportManager.setTest(extent.createTest(testName));
    }

    public static void flushReport() {
        extent.flush();
    }

}
