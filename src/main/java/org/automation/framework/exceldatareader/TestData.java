package org.automation.framework.exceldatareader;

import com.creditdatamw.zerocell.annotation.Column;
import lombok.Getter;
import lombok.ToString;
import org.automation.framework.enums.BrowserType;
import org.automation.framework.exceldatareader.convertor.StringToBrowserType;
import org.automation.framework.exceldatareader.convertor.StringToInteger;

@ToString
@Getter
public class TestData {

    @Column(name = "testcase", index = 0)
    private String testcase;

    @Column(name = "browser", index = 1, converterClass = StringToBrowserType.class)
    private BrowserType browser;

    @Column(name = "firstName", index = 2)
    private String firstName;

    @Column(name = "lastName", index = 3)
    private String lastName;

    @Column(name = "age", index = 4, converterClass = StringToInteger.class)
    private int age;

}
