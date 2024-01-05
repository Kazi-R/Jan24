package com.smart.groups;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestClass extends BaseClass {

	@Test(testName = "TestGoogle", groups = { "smoke" })
	public void testGoogle() {
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.name("q")).sendKeys("ProSmart", Keys.ENTER);
		String expectedTitle = "ProSmart - Google Search";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, " >> Title mismatched!");
	}

	@Test(testName = "TestFacebook", groups = { "smoke", "regression" })
	public void testFacebook() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("~!@#*&", Keys.ENTER);
		Thread.sleep(2000);
		SoftAssert soft = new SoftAssert();
		String actualTitle = driver.getTitle();
		String expectedTitle = "Log into Facebook";
		soft.assertEquals(actualTitle, expectedTitle, ">> Title mismatched!");
		soft.assertAll();
	}

	@Test(testName = "TestOrangeHRM", groups = { "sanity" })
	public void testOrangeHRM() throws Exception {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.tagName("button")).click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Paul Collings']")).isDisplayed());
	}
}
