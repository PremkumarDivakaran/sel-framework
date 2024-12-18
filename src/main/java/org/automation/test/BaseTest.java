package org.automation.test;

import org.testng.annotations.AfterMethod;

import static org.automation.framework.driver.DriverInstance.getDriver;

public class BaseTest {

    @AfterMethod
    public void quitBrowser(){
        getDriver().quit();
    }


}
