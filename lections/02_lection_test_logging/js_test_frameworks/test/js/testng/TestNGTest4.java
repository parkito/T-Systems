package js.testng;

import org.testng.annotations.Test;


public class TestNGTest4 {
	
	@Test(groups="integration")
	public void testI1() {
		System.out.println("integration test 1");
	}
	
	@Test(groups="integration")
	public void testI2() {
		System.out.println("integration test 2");
	}

}
