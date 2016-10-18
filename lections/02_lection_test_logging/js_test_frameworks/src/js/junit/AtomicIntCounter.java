package js.junit;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntCounter implements Counter {
	private AtomicInteger atomicInt = new AtomicInteger();

	@Override
	public int incrementAndGet() {
		return atomicInt.incrementAndGet();
	}
}
