package pro.sky.java.course2.weblibrary;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.java.course2.calculator.Service.CalculatorServiceImpl;

import static org.apache.coyote.http11.Constants.a;

public class CalculatorServiceImplTest {
    private final CalculatorServiceImpl out = new CalculatorServiceImpl();
    private static final int a = 4;
    private static final int b = -5;
    private static final int a2 = 4;
    private static final int b2 = 5;


    @Test
    public void shouldReturnCorrectPlusResult() {
        int result = out.plus(a, b);
        int result2 = out.plus(a2, b2);
        Assertions.assertEquals(-1, result);
        Assertions.assertEquals(9, result2);
    }

    @Test
    public void shouldReturnCorrectMinusResult() {
        int result = out.minus(a, b);
        int result2 = out.minus(a2, b2);
        Assertions.assertEquals(9, result);
        Assertions.assertEquals(-1, result2);
    }

    @Test
    public void shouldReturnCorrectMultiplyResult() {
        int result = out.multiply(a, b);
        int result2 = out.multiply(a2, b2);
        Assertions.assertEquals(-20, result);
        Assertions.assertEquals(20, result2);
    }

    @Test
    public void shouldReturnCorrectDivideResult() {
        double result = out.divide(a, b);
        double result2 = out.divide(a2, b2);
        Assertions.assertEquals(-0.8, result);
        Assertions.assertEquals(0.8, result2);
    }
    @Test
    public void shouldThrowExceptionWhenDivisionByZero(){
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->out.divide(a,0));
    }
}
