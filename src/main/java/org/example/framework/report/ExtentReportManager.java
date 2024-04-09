package org.example.framework.report;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentReportManager {

    private ExtentReportManager(){}

    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    static ExtentTest getTest() {
        return test.get();
    }

    static void setTest(ExtentTest extest) {
        test.set(extest);
    }

}
