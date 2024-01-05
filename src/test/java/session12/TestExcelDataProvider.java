package session12;

import org.testng.annotations.Test;

public class TestExcelDataProvider {
	
	@Test(dataProvider = "loginData", dataProviderClass = ExcelDataSupplier.class)
	public void loginTest(String name, String pass) {
		System.out.println(name + " logged in to the application with " + pass);
	}
}
