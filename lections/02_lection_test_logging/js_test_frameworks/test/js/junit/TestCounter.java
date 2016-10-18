package js.junit;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestCounter {
	
	private static final int THREADS_COUNT = 5;
		
	@Test
	public void dumbTest() throws InterruptedException {
		final Counter counter = new DumbCounter();
		
	    AsynchTester[] testers = new AsynchTester[THREADS_COUNT];
	    for(int i = 0;i < THREADS_COUNT; i++) {
	        testers[i] = new AsynchTester(new Runnable() {

	            @Override
	            public void run() {
	                int last = counter.incrementAndGet();
	                for (int i = 0; i < 1000000; i++) {
	                    int value = counter.incrementAndGet();
	                    assertTrue (value > last);
	                    last = value;
	                }
	            }
	        });
	        testers[i].start();
	    }

	    for(AsynchTester tester : testers)
	        tester.test();
	}
	
	@Test
	public void atomicTest() throws InterruptedException {
		final Counter counter = new AtomicIntCounter();

	    AsynchTester[] testers = new AsynchTester[THREADS_COUNT];
	    for(int i = 0;i < THREADS_COUNT; i++) {
	        testers[i] = new AsynchTester(new Runnable() {

	            @Override
	            public void run() {
	                int last = counter.incrementAndGet();
	                for (int i = 0; i < 1000000; i++) {
	                    int value = counter.incrementAndGet();
	                    assertTrue (value > last);
	                    last = value;
	                }
	            }
	        });
	        testers[i].start();
	    }

	    for(AsynchTester tester : testers)
	        tester.test();
	}
	

}
