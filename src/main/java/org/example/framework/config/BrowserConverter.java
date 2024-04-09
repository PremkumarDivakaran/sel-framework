package org.example.framework.config;

import org.aeonbits.owner.Converter;
import org.example.framework.enums.BrowserType;

import java.lang.reflect.Method;

public class BrowserConverter implements Converter<BrowserType> {
    @Override
    public BrowserType convert(Method method, String s) {
        return BrowserType.valueOf(s.toUpperCase());
    }
}
