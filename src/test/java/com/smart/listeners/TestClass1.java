package com.smart.listeners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(ITestListenerImplementationClass.class)
public class TestClass1 {
	@Test(priority = 1)
	public void testMethod1() {
		System.out.println("I am in testmethod1");
	}	
	@Test(priority = 2)
	public void testMethod2() {
		System.out.println("I am in testmethod2");
		Assert.fail();
	}	
	@Test(priority = 3,timeOut = 1000)
	public void testMethod3() throws Exception {
		Thread.sleep(2000);
		System.out.println("I am in testmethod3");
	}	
	@Test(priority = 4, dependsOnMethods  = "testMethod3")
	public void testMethod4() {
		System.out.println("I am in testmethod4");
	}	
	@Test(priority = 5)
	public void testMethod5() {
		System.out.println("I am in testmethod5");
	}	
	@Test(priority = 6)
	public void testMethod6() {
		System.out.println("I am in testmethod6");
	}	
	@Test(priority = 7)
	public void testMethod7() {
		System.out.println("I am in testmethod7");
	}	
}
