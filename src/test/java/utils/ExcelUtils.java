package utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//String projPath = System.getProperty("user.dir");
//System.out.println(projPath);
public class ExcelUtils {
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public ExcelUtils(String excelPath, String sheetName) {
		try {
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);

		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}

	public void getRowCount() {
		int rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println(rowCount);
	}

	public Object getCellData(int rowNo, int colNo) {
		DataFormatter formatter = new DataFormatter();
		return formatter.formatCellValue(sheet.getRow(rowNo).getCell(colNo));
	}

}
