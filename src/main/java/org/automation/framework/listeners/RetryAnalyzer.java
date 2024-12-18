package org.automation.framework.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private static final int MAX_ATTEMPTS = 3;
    private int currentCount = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (currentCount < MAX_ATTEMPTS){
            currentCount++;
            return true;
        }
        return false;
    }
}
