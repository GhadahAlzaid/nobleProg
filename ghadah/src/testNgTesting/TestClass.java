package testNgTesting;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClass {

	@Test(priority = 0)
	public void testcase1() {

		System.out.println("Test case 1");
	}

	@Test(priority = 1000)
	public void testcase3() {

		System.out.println("Test case 3");
	}
	
	@Test(priority = 2000)
	public void testcase4() {

		System.out.println("Test case 4");
	}
	
	@Test(priority = 3000, enabled =  false)
	public void testcase2() {

		System.out.println("Test case 2");
	}
	
	@BeforeMethod
	public void beforeAMethod() {
		System.out.println("Before a test");
	}
	
	@AfterMethod
	public void afterAMethod() {
		System.out.println("After a method");
	}
	
	@BeforeClass
	public void beforeAClass() {
		System.out.println("First Test case to execute in a class");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("Last Method to execute in a class");
	}
}
