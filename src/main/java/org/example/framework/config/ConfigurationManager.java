package org.example.framework.config;

import org.aeonbits.owner.ConfigCache;

public class ConfigurationManager {

    public static ConfigurationReader getConfiguration() {
        return ConfigCache.getOrCreate(ConfigurationReader.class);
    }

}
