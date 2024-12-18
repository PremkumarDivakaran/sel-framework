package org.example;

import org.example.configReader.LoginTestDataReader;
import org.automation.framework.config.ConfigPropertyReader;
import org.automation.framework.config.ConfigurationManager;
import org.example.pojo.User;
import org.testng.annotations.Test;


public class TestRunner {

    @Test
    public void calcPercentage(){
        System.out.println(ConfigPropertyReader.getConfig("browser"));
    }

    @Test
    public void runner(){
        System.out.println(ConfigurationManager.getConfiguration().browser());
    }

    @Test
    public void readLoginData(){
        /*for(User user:LoginTestDataReader.read().getData()){
            System.out.println(user.getUsername());
            System.out.println(user.getPassword());
        }*/
    }

}