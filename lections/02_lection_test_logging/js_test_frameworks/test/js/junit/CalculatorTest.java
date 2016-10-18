package js.junit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    
 private Calculator calculator;
    
    @Before
    public void initCalculator() {
        calculator = new Calculator();
    }
    
    @Test
    public void maxValueTest() {
        Integer actual = calculator.maxValue(Integer.valueOf(10), Integer.valueOf(20));
        Assert.assertEquals(Integer.valueOf(20), actual);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void exceptionTest() {
        calculator.maxValue(Integer.valueOf(10), null);
    }

}



