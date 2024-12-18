package org.automation.pages;


import org.automation.framework.enums.Locators;
import org.automation.framework.seleniumBase.Base;

public class LoginPage extends Base {

    public LoginPage enterUsername(String username){
        waitForSeconds(2000);
        clearAndType(locateElement(Locators.XPATH,"//input[@name='username']"), username);
        return this;
    }

    public LoginPage enterPassword(String password){
        clearAndType(locateElement(Locators.XPATH,"//input[@name='password']"), password);
        return this;
    }

    public HomePage clickLogin(){
        click(locateElement(Locators.XPATH,"//button[@type='submit']"));
        return new HomePage();
    }

    public static HomePage loginInToApp(String username, String password){
        return launchApp()
                .enterUsername(username)
                .enterPassword(password)
                .clickLogin();
    }


}
