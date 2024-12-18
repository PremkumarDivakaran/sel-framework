package org.automation.framework.config;

import org.aeonbits.owner.Config;
import org.automation.framework.enums.BrowserType;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources(
        {
                "file:${user.dir}/src/main/resources/config.properties",
                "file:${user.dir}/src/main/resources/dev-config.properties",
                "file:${user.dir}/src/main/resources/qa-config.properties"
        }
)
public interface ConfigurationReader extends Config {

    @DefaultValue("qa")
    @Key("environment")
    String environment();

    @Key("remote")
    boolean remote();

    @Key("remoteUrl")
    String remoteUrl();

    @Key("browser")
    @ConverterClass(BrowserTypeConverter.class)
    BrowserType browser();

    @Key("${environment}.url")
    String url();

    @Key("${environment}.username")
    String username();

    @Key("${environment}.password")
    String password();

}
