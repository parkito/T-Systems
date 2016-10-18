package js.testng;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGTest1 {
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before suite call");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before class call");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before method call");
	}
	

	@BeforeTest
	public void before() {
		System.out.println("Before test call");
	}
	
	@Test
	public void test1() {
		Assert.assertTrue(true);
	}
	
	@Test
	public void test2() {
		Assert.assertTrue(true);
	}

}
