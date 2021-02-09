package ddt;

import utils.ExcelUtils;

public class DDTExcelTests {
	// Test the excel utils methods for reading and writing using POI library.
	public static void main(String[] args) {
		ExcelUtils excelUtils = new ExcelUtils(".\\data\\TestData.xlsx", "Sheet1");
		System.out.println(excelUtils.getCellData(1,0));
		System.out.println(excelUtils.getCellData(1,1));
		System.out.println(excelUtils.getCellData(1,2));
	}
}
