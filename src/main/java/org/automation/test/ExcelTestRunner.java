package org.automation.test;

import org.automation.framework.exceldatareader.ExcelReader;
import org.automation.framework.exceldatareader.TestData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ExcelTestRunner {

    /*@Test(dataProvider = "getDataFromExcel")
    public void tc1(TestData testDataReader){
        System.out.println(testDataReader);
    }

    @Test(dataProvider = "getDataFromExcel")
    public void tc2(TestData testDataReader){
        System.out.println(testDataReader);
    }

    @DataProvider
    public Object[] getDataFromExcel(Method method){
        return ExcelReader
                .readData()
                .stream()
                .filter(e -> e.getTestcase().equalsIgnoreCase(method.getName()))
                .toArray();
    }*/
}
