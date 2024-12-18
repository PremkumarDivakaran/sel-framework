package org.automation.framework.driver.factory;

import org.automation.framework.driver.manager.DriverManager;
import org.automation.framework.driver.manager.RemoteChromeDriverManager;
import org.automation.framework.driver.manager.RemoteFirefoxDriverManager;
import org.automation.framework.enums.BrowserType;

public class RemoteDriverFactory {

    private RemoteDriverFactory(){}

    public static DriverManager setDriver(BrowserType browserType){
        switch (browserType){
            case CHROME:
                return new RemoteChromeDriverManager();
            case FIREFOX:
                return new RemoteFirefoxDriverManager();
            default:
                throw new RuntimeException("Invalid BrowserType");
        }
    }

}
