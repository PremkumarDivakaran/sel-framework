package org.example.framework.config;

import org.aeonbits.owner.ConfigCache;
import org.aeonbits.owner.ConfigFactory;

public class ConfigManager {

    public static ConfigReader getConfig(){
        return ConfigFactory.create(ConfigReader.class);
        //return ConfigCache.getOrCreate(ConfigReader.class);
    }
}
