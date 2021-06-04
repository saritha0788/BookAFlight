package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheetUtils {
	public static DataFormatter dataFormatter;
	public static String testDataFile=System.getProperty("user.dir")+"/src/test/resources/InputDataFile.xlsx";
	public static Workbook workbook;
	public static Sheet sheet;

	public static Object[][] getTestData(String sheetName) {

		dataFormatter = new DataFormatter();

		FileInputStream file = null;
		try {
			file = new FileInputStream(testDataFile);
		} catch (FileNotFoundException e) {
			e.getMessage();
		}

		try {
			workbook = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		sheet = workbook.getSheet(sheetName);
		// we are storing data in two dimensional object array
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// iterating through excel sheet
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				String str = dataFormatter.formatCellValue(sheet.getRow(i + 1).getCell(j));
				// data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
				data[i][j] = str;
			}
		}
		return data;
	}

}
