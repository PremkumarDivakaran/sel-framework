package org.automation.framework.exceldatareader.convertor;

import com.creditdatamw.zerocell.converter.Converter;
import org.automation.framework.enums.BrowserType;

public class StringToBrowserType implements Converter<BrowserType> {
    @Override
    public BrowserType convert(String s, String s1, int i) {
        return BrowserType.valueOf(s.toUpperCase());
    }
}
