package org.example.framework.config;

import org.aeonbits.owner.Config;
import org.example.framework.enums.BrowserType;

@Config.Sources("file:${user.dir}/src/main/resources/config.properties")
public interface ConfigReader extends Config {

    @Key("browser")
    @ConverterClass(BrowserConverter.class)
    BrowserType getBrowser();
}
