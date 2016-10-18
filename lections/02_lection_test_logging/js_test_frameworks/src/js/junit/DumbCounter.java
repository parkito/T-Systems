package js.junit;

public class DumbCounter implements Counter {
	private int counter;

	@Override
	public int incrementAndGet() {
		return ++counter;
	}
}
