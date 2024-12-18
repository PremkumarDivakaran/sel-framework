package org.automation.framework.driver.manager;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteChromeDriverManager extends DriverManager {

    @Override
    public void setBrowserDriver() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setBrowserName(Browser.CHROME.browserName());
        //desiredCapabilities.setVersion("");
        ChromeOptions chrome_options = new ChromeOptions();
        /*chrome_options.addArguments("--no-sandbox");
        chrome_options.addArguments("--disable-dev-shm-usage");
        chrome_options.addArguments("--disable-notifications");*/
        chrome_options.addArguments("--headless");
        desiredCapabilities.merge(chrome_options);

        try {
            driver.set(
                    new RemoteWebDriver(new URL("http://" + remoteUrl + "/wd/hub"), chrome_options));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

}
