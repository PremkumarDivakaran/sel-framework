package org.automation.framework.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public final class ConfigPropertyReader {

    private ConfigPropertyReader(){}

    static HashMap<String, String> hashMap = new HashMap<>();

    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (Map.Entry entry:properties.entrySet())
            hashMap.put(entry.getKey().toString(), entry.getValue().toString());
    }

    public static String getConfig(String key){
        return hashMap.get(key);
    }

}
