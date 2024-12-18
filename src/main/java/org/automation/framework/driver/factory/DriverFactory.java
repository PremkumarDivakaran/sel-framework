package org.automation.framework.driver.factory;

import org.automation.framework.driver.manager.ChromeDriverManager;
import org.automation.framework.driver.manager.DriverManager;
import org.automation.framework.driver.manager.FirefoxDriverManager;
import org.automation.framework.enums.BrowserType;

public class DriverFactory {

    private DriverFactory(){}

    public static DriverManager setDriver(BrowserType browserType){
        switch (browserType){
            case CHROME:
                return new ChromeDriverManager();
            case FIREFOX:
                return new FirefoxDriverManager();
            default:
                throw new RuntimeException("Invalid BrowserType");
        }
    }

}
