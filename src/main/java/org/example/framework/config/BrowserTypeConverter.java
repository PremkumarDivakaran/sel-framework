package org.example.framework.config;

import org.example.framework.enums.BrowserType;

import java.lang.reflect.Method;

public class BrowserTypeConverter implements org.aeonbits.owner.Converter<BrowserType> {

    @Override
    public BrowserType convert(Method method, String browserName) {
        return BrowserType.valueOf(browserName.toUpperCase());
    }
}
