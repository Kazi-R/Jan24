package session11;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PartialDataProvider {
//	@DataProvider(name = "dp1", indices = {0,2})
//	public String[] dataP1() {
//		String[] data = new String[] { "Ibrahim", "Mustafa", "Saiful", "Nabila" };
//		return data;
//	}
	@Test(dataProvider = "dp2", dataProviderClass = DataSupplier.class)
	public void validateLogin(String name) {
		System.out.println(name + " logged into the application.");
	}
	
	@Test(dataProvider = "loginData", dataProviderClass = ExcelDataSupplier2.class)
	public void useDataFromExcel(String username, String password) {
		System.out.println(username + " is using " + password);
	}
}
