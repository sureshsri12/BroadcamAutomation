package org.broadcom.utils.zerocell;

import java.io.File;
import java.util.List;

import com.creditdatamw.zerocell.Reader;

public class ExcelReader {
	private ExcelReader() {
	}

	public static List<TestData> getTestdatas() {
		return testdatas;
	}

	public static List<TestData> testdatas = null;
	
	static {

		testdatas = Reader.of(TestData.class).from(new File("testdata.xlsx")).sheet("Sheet1").skipHeaderRow(true)
				.list();
		testdatas.forEach(System.out::println);
	}

}
