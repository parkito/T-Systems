package js.junit;

public class Calculator {
	
	public Integer maxValue(Integer a, Integer b) {
		if (a == null || b == null) {
			throw new IllegalArgumentException("Param must be not null");
		}
		if (a < b) {
			return b;
		}
		return a;
	}
}





