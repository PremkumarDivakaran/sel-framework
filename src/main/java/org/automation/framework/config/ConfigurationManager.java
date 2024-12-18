package org.automation.framework.config;

import org.aeonbits.owner.ConfigCache;

public class ConfigurationManager {

    public static ConfigurationReader getConfiguration() {
        //return ConfigFactory.create(ConfigurationReader.class);
        return ConfigCache.getOrCreate(ConfigurationReader.class);
    }

}
