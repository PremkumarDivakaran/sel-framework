package org.example.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.framework.config.ConfigurationManager;

import static org.example.framework.seleniumBase.DriverInstance.getDriver;
import static org.example.framework.seleniumBase.DriverInstance.setDriver;
import static org.example.pages.LoginPage.loginInToApp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest {

    @Test
    public void checkLogin(){
        String title = loginInToApp(ConfigurationManager.getConfiguration().username(),
                ConfigurationManager.getConfiguration().password())
                .getTitle();

        Assert.assertEquals(title,"Logged In Successfully");
    }

    @Test
    public void checkLogin1(){
        String title = loginInToApp(ConfigurationManager.getConfiguration().username(),
                ConfigurationManager.getConfiguration().password())
                .getTitle();

        Assert.assertEquals(title,"Logged In Successfully");
    }

    @Test
    public void checkLogin2(){
        String title = loginInToApp(ConfigurationManager.getConfiguration().username(),
                ConfigurationManager.getConfiguration().password())
                .getTitle();

        Assert.assertEquals(title,"Logged In Successfully");
    }

    @Test
    public void checkLogin3(){
        String title = loginInToApp(ConfigurationManager.getConfiguration().username(),
                ConfigurationManager.getConfiguration().password())
                .getTitle();

        Assert.assertEquals(title,"Logged In Successfully");
    }

    @Test
    public void checkLogin4(){
        String title = loginInToApp(ConfigurationManager.getConfiguration().username(),
                ConfigurationManager.getConfiguration().password())
                .getTitle();

        Assert.assertEquals(title,"Logged In Successfully");
    }


}
