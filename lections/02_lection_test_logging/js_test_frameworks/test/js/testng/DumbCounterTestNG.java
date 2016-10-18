package js.testng;

import js.junit.Counter;
import js.junit.DumbCounter;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DumbCounterTestNG {
	
	private Counter counter = new DumbCounter();
	
	@Test(threadPoolSize = 30, invocationCount = 30, invocationTimeOut = 10000)
	public void test() {
		
		int last = counter.incrementAndGet();
		for (int i = 0; i < 1000000; i++) {
			int value = counter.incrementAndGet();
			Assert.assertTrue(value > last);
			last = value;
		}
	}
	
	
	

}
