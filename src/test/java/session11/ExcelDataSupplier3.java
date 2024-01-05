package session11;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataSupplier3 {
	public static void main(String[] args) throws Exception {
		File src = new File("./src/test/resources/TestData.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		int rows = sheet.getPhysicalNumberOfRows();
		System.out.println(rows);
		int cols = sheet.getRow(0).getLastCellNum();
		System.out.println(cols);
		String [][] data = new String[rows-1][cols];
		for (int i = 1; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				DataFormatter format = new DataFormatter();
//				System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
				System.out.println( format.formatCellValue(sheet.getRow(i).getCell(j)));
				data[i-1][j]= format.formatCellValue(sheet.getRow(i).getCell(j));
			}
			System.out.println();
		}
		for(String[] srcData: data) {
		System.out.println(	Arrays.toString(srcData));
		}
	}
}
