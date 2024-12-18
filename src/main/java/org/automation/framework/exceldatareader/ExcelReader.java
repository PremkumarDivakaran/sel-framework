package org.automation.framework.exceldatareader;

import com.creditdatamw.zerocell.Reader;

import java.io.File;
import java.util.List;

public final class ExcelReader {

    private static final String TEST_DATA_PATH = "/src/main/resources/data/TestData.xlsx";

    private ExcelReader(){}

    public static List<TestData> readData() {
        return Reader.of(TestData.class)
                .from(new File(System.getProperty("user.dir") + TEST_DATA_PATH))
                .sheet("Sheet1")
                .skipHeaderRow(true)
                .list();
    }

}
