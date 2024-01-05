package session10;

import static org.testng.Assert.*;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMParameters {

	WebDriver driver;

	@Parameters("browserName")
	@BeforeTest
	public void initialiseBrowser(@Optional("Chrome") String browserName) {

		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			System.err.println("This browser is not supported");
			break;
		}

		driver.manage().window().maximize();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	@Parameters("appUrl")
	@Test
	public void launchApp(String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	@Parameters({"user","pass"})
	@Test
	public void enterLoginDetails(String user, String pass) throws Exception {
		driver.findElement(By.name("username")).sendKeys(user);
		driver.findElement(By.name("password")).sendKeys(pass);
		driver.findElement(By.tagName("button")).click();
		Thread.sleep(3000);
	}

	@Test
	public void navigateToMyInfo() {
		driver.findElement(By.xpath("//span[text()='My Info']")).click();
	}

	@Test
	public void verifyMyInfo() {
		boolean actualValue =
		driver.findElement(By.xpath("//h6[text()='Personal Details']")).isDisplayed();
		assertTrue(actualValue);
	}

	@Test
	public void verifyLogin() {
		WebElement dashboard = driver.findElement(By.xpath("//h6[text()='Dashboard']"));
		assertTrue(dashboard.isDisplayed());
		assertTrue(dashboard.getText().contains("Dashboard"));
	}
}
