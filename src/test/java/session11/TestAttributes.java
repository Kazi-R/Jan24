package session11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestAttributes {
	@Test (invocationCount = 4, threadPoolSize = 2)
	public void testmethod1() throws Exception {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://randomuser.me/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@data-label='name']")).click();
		System.out.println("User name: " + driver.findElement(By.id("user_value")).getText());
		
		driver.findElement(By.xpath("//li[@data-label='email']")).click();
		System.out.println("User email: " + driver.findElement(By.id("user_value")).getText());
		
		driver.close();
	}	
}
