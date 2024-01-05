package session11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderExample2 {
	WebDriver driver;
	// Define the data provider method
	@DataProvider(name = "siteData")
	public Object[][] siteData() {
		// Return the data in a 2D array
		return new Object[][] { { "https://www.toolsqa.com/testng/testng-dataproviders/" },
				{ "https://www.guru99.com/parameterization-using-xml-and-dataproviders-selenium.html" },
				{ "https://stackoverflow.com/questions/38053309/parallel-execution-of-test-using-dataprovider" } };
	}

	// Use the data provider name to link with the test method
	@Test(dataProvider = "siteData")
	public void siteTest(String site){
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		// Open the site in the browser
		driver.get(site);
		driver.close();
	}
}
