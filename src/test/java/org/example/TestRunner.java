package org.example;

import org.example.framework.config.ConfigManager;
import org.example.framework.config.ConfigPropertyReader;
import org.example.framework.config.ConfigurationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class TestRunner {

    @Test
    public void calcPercentage(){
        System.out.println(ConfigManager.getConfig().getBrowser());
        System.out.println(ConfigPropertyReader.getConfig("browser"));
    }

    @Test
    public void runner(){
        System.out.println(ConfigurationManager.getConfiguration().browser());

    }

}