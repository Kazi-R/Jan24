package session11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwagLabDemoOnDataProvider {
	
	@Test(dataProvider = "getData")
	public void testSwagLogin(String username, String password) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.name("user-name")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();		
		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Products']")).isDisplayed());
		driver.quit();		
	}
	
	@DataProvider (parallel = true)
	public Object[][] getData(){
	return	new Object[][] {
		{"standard_user", "secret_sauce"}
		,{"locked_out_user", "secret_sauce"}
		,{"problem_user", "secret_sauce"}
		,{"performance_glitch_user", "secret_sauce"}
//		,{"error_user", "secret_sauce"}
//		,{"visual_user", "secret_sauce"}
		};
	}	
}
