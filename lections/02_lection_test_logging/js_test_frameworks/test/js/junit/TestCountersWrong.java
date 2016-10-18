package js.junit;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.CountDownLatch;

import org.junit.Before;
import org.junit.Test;

public class TestCountersWrong {
	private static final int THREADS_COUNT = 5;
	private Counter counter;

	@Before
	public void resetCounter() {
		counter = new DumbCounter();
	}

	@Test
	public void test() throws InterruptedException {
		final CountDownLatch latch = new CountDownLatch(THREADS_COUNT);
		for (int i = 0; i < THREADS_COUNT; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					try {
						int last = counter.incrementAndGet();
						for (int i = 0; i < 1000000; i++) {
							int value = counter.incrementAndGet();
							assertTrue(value > last);
							last = value;
						}
					} finally {
						latch.countDown();
					}
				}
			}).start();
		}

		latch.await();
	}
	
}
