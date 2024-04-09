package org.example.framework.config;

import org.aeonbits.owner.Config;
import org.example.framework.enums.BrowserType;

@Config.Sources(
        "file:${user.dir}/src/main/resources/config.properties"
)
public interface ConfigurationReader extends Config {

    @Key("remote")
    boolean remote();

    @Key("remoteUrl")
    String remoteUrl();

    @Key("browser")
    @ConverterClass(BrowserTypeConverter.class)
    BrowserType browser();

    @Key("url")
    String url();

    @Key("username")
    String username();

    @Key("password")
    String password();

}
