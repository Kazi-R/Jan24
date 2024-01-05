package session11;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelDataSupplier {
	
//	@DataProvider(name = "loginData")
//	public String[][] getData() throws Exception {
public static void main (String[] args) throws Exception {
		File src = new File("./src/test/resources/TestData.xlsx");
		System.out.println(src.exists());
		//to read the excel data we need to create the raw data 
		//will convert the excel data into the raw data 
		FileInputStream fis = new FileInputStream(src); 
		//create a wrok book
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("sheet1");
		int rowNos = sheet.getPhysicalNumberOfRows();
		int lastRowNox = sheet.getLastRowNum();
		int noOfCols = sheet.getRow(0).getLastCellNum();		
		System.out.println(sheet.getLastRowNum());
		
		String[][] data = new String[rowNos-1][noOfCols];
		
		for(int i=0; i< rowNos-1; i++) {
			for(int j=0; j< noOfCols; j++) {
				DataFormatter df = new DataFormatter();
			System.out.println(	df.formatCellValue(sheet.getRow(i+1).getCell(j)));
			data[i][j]= df.formatCellValue(sheet.getRow(i+1).getCell(j));
			}
			System.out.println();
		}
		wb.close();
		fis.close();
		
		for (String[] dataArr :data) {
			System.out.println(Arrays.toString(dataArr));
		}
//		return data; 
	}

}
