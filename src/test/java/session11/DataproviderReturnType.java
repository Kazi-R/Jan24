package session11;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataproviderReturnType {
	
	@Test(dataProvider = "loginData")
	public void testLogin(Object username) {
		System.out.println(username + " is logged in.");
	}
	
	@DataProvider(name = "loginData")
	public Object [] getData(){
		Object [] data = new Object[] {
				4,
				"Suhana",
				6,
				"Amitabh"
		};
		return data;
	}	
}
