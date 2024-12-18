package org.automation.framework.exceldatareader.convertor;

import com.creditdatamw.zerocell.converter.Converter;

public class StringToInteger implements Converter<Integer> {
    @Override
    public Integer convert(String s, String s1, int i) {
        return Integer.parseInt(s);
    }
}
