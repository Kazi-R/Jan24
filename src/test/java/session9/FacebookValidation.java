package session9;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookValidation {
	WebDriver driver;
	@Test
	public void facebookLogin() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("~!@#*&", Keys.ENTER);
		String value =  driver.findElement(By.id("error_box")).getCssValue("background-color");
		System.out.println(value);
		driver.close();
	}
	
}
