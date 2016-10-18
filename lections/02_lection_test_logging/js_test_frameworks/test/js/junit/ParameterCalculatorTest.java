package js.junit;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class ParameterCalculatorTest {

    private Integer input1;
    private Integer input2;
    private Integer result;
    private boolean exception;

    public ParameterCalculatorTest(Integer input1, Integer input2, Integer result, boolean exception) {
        this.input1 = input1;
        this.input2 = input2;
        this.result = result;
        this.exception = exception;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                { null, null, 0, true }, 
                { null, 1, 0, true }, 
                { 1, null, 0, true }, 
                { 2, 2, 2, false }, 
                { 1, 2, 2, false }, 
                { 2, -2, 2, false }
                });
    }
    @Test
    public void test() {
        Calculator calc = new Calculator();
        if (exception) {
            try {
                calc.maxValue(input1, input2);
            } catch (Exception e) {
                Assert.assertTrue(e instanceof IllegalArgumentException);
            }
        } else {
            Assert.assertEquals(result, calc.maxValue(input1, input2));
        }
    }
}
