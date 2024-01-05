package session11;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelDataSupplier2 {
	
	@DataProvider(name = "loginData")
	public String[][] getData() throws IOException{	
//	public static void main(String[] args) throws IOException {
		File src = new File("./src/test/resources/TestData.xlsx");
		//System.out.println(src.exists());
		FileInputStream fis = new FileInputStream(src);// converting excel data into raw data
		XSSFWorkbook wb = new XSSFWorkbook(fis); //create a workbook 
		XSSFSheet sheet = wb.getSheet("Sheet1"); //from the workbook find out the sheet 
		int rowNum = sheet.getPhysicalNumberOfRows();//get the total rows
		int columns = sheet.getRow(0).getLastCellNum();//get the columns in a row
		String[][] data = new String[rowNum-1][columns];
		//iterate through rows and columns to extract all the cell values 
		for (int i=0; i<rowNum-1; i++) {
			for (int j=0; j<columns; j++) {
				DataFormatter df = new DataFormatter();
//			System.out.println(	df.formatCellValue(sheet.getRow(i+1).getCell(j)));
//				System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
			data[i][j] = df.formatCellValue(sheet.getRow(i+1).getCell(j));
			}
//			System.out.println();
		}		
		wb.close();
		fis.close();		
//		for (String[] arrData :data) {
//			System.out.println(Arrays.toString(arrData));
//		}
		return data;
		}
}
