package org.automation.framework.driver.manager;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteFirefoxDriverManager extends DriverManager {

    @Override
    public void setBrowserDriver() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setBrowserName(Browser.FIREFOX.browserName());
        desiredCapabilities.setVersion("");
        FirefoxOptions firefox_options = new FirefoxOptions();
        firefox_options.addArguments("--no-sandbox");
        firefox_options.addArguments("--disable-dev-shm-usage");
        firefox_options.addArguments("--disable-notifications");
        firefox_options.addArguments("--headless");
        desiredCapabilities.merge(firefox_options);

        try {
            driver.set(
                    new RemoteWebDriver(new URL("http://" + remoteUrl + "/wd/hub"), firefox_options));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

}
