package com.smart.extentReports;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
		
	@Parameters("browserName")
	@BeforeTest(alwaysRun = true)
	public void setUp(@Optional("Chrome") String browserName) {
		
		switch (browserName.toLowerCase()){
		case "chrome": {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;			
		}
		case "firefox": {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;			
		}
		case "edge": {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;			
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + browserName);
		}		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterTest(alwaysRun = true)
	public void tearDown() {
		driver.close();
	}
	
	
	@BeforeSuite
	public void initialiseEctentReprots() {
		
	}
	
	@AfterSuite
	public void generateExtentReport() {
		
	}
	
	
	public void captureScreenshot(String fileName) {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("./screenshot/"+fileName + ".png"));
			System.out.println("Screenshot captured.");
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
}
