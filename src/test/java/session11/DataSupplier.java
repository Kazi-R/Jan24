package session11;

import org.testng.annotations.DataProvider;

public class DataSupplier {

	@DataProvider(name = "dp1", indices = {0,2})
	public String[] dataP1() {
		String[] data = new String[] { "Ibrahim", "Mustafa", "Saiful", "Nabila" };
		return data;
	}
	
	@DataProvider(name = "dp2")
	public String[] dataP2() {
		String[] data = new String[] { "Sumi", "Kalyan", "Ahnaf", "Sharmin" };
		return data;
	}	
}
