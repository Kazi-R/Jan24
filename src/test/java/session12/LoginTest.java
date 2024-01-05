package session12;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;



public class LoginTest {

    // Create a WebDriver object
    public WebDriver driver;

    // Create a WebDriverWait object
    public WebDriverWait wait;

    // Specify the URL of the web application
    String appURL = "https://www.saucedemo.com/";

    // Specify the locators of the web elements
    private By byEmail = By.id("user-name");
    private By byPassword = By.id("password");
    private By bySubmit = By.id("login-button");
    private By byError = By.xpath("//h3[@data-test='error']");

    // Create a data provider method that reads data from an Excel file and returns it as a two-dimensional array of objects
    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        Object[][] arrayObject = getExcelData("./src/test/resources/ExcelData.xlsx", "Sheet1");
        return arrayObject;
    }

    // Create a method that can read data from an Excel file and return it as a two-dimensional array of objects
    public String[][] getExcelData(String filePath, String sheetName) {
        String[][] arrayExcelData = null;
        try {
        	File src = new File(filePath);
            // Create a FileInputStream object to read the Excel file
            FileInputStream fs = new FileInputStream(src);

            // Create a Workbook object to access the Excel file
            XSSFWorkbook wb = new XSSFWorkbook(fs);
           

            // Create a Sheet object to access the sheet in the Excel file
            XSSFSheet sh = wb.getSheet(sheetName);

            // Get the total number of rows and columns in the sheet
            int totalNoOfRows = sh.getLastRowNum();
            int  totalNoOfCols = sh.getRow(0).getLastCellNum();

            // Create a two-dimensional array of strings to store the data from the sheet
            arrayExcelData = new String[totalNoOfRows - 1][totalNoOfCols];

            // Loop through the rows and columns of the sheet and store the data in the array
            for (int i = 1; i < totalNoOfRows; i++) {
                for (int j = 0; j < totalNoOfCols; j++) {
                    // Get the cell object in the sheet
                    Cell cell = sh.getRow(i).getCell(j);

                    // Get the contents of the cell as a string
                    arrayExcelData[i - 1][j] = cell.getStringCellValue();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }  
        return arrayExcelData;
    }

    // Create a test method that takes two parameters, username and password, and uses them to perform the login functionality of the web application
    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password) {
        WebDriverManager.firefoxdriver().setup();
    	// Create a FirefoxDriver object
        driver = new FirefoxDriver();

        // Navigate to the web page
        driver.get(appURL);

        // Locate the email input field and enter the username
        driver.findElement(byEmail).sendKeys(username);

        // Locate the password input field and enter the password
        driver.findElement(byPassword).sendKeys(password);

        // Locate the submit button and click it
        driver.findElement(bySubmit).click();

        // Wait for the error message to be displayed
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(byError));

        // Get the text of the error message
        String actualError = driver.findElement(byError).getText();
        System.out.println(actualError);

        // Specify the expected error message
        String expectedError = "Epic sadface: Username and password do not match any user in this service";
        
        SoftAssert soft = new SoftAssert();
        // Compare the actual and expected error messages
        soft.assertEquals(actualError, expectedError);

        // Close the browser
        driver.quit();
        soft.assertAll();
    }
}
