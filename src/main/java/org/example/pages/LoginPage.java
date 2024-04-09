package org.example.pages;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.framework.config.ConfigurationManager;
import org.example.framework.enums.Locators;
import org.example.framework.report.ExtentLogger;
import org.example.framework.seleniumBase.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage extends Base {



    public LoginPage enterUsername(String username){
        clearAndType(locateElement(Locators.ID,"username"), username);
        ExtentLogger.pass("Username is entered", getScreenShot());
        return this;
    }

    public LoginPage enterPassword(String password){
        clearAndType(locateElement(Locators.ID,"password"), password);
        ExtentLogger.pass("Password is entered", getScreenShot());
        return this;
    }

    public HomePage clickLogin(){
        click(locateElement(Locators.ID,"submit"));
        ExtentLogger.pass("Login Successfully", getScreenShot());
        return new HomePage();
    }

    public static HomePage loginInToApp(String username, String password){
        return launchApp()
                .enterUsername(username)
                .enterPassword(password)
                .clickLogin();
    }


}
