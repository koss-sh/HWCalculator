package pro.sky.java.course2.weblibrary;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.java.course2.calculator.Service.CalculatorServiceImpl;

import java.util.stream.Stream;

public class CalculatorServiceImplParametrizedTest {
    private final CalculatorServiceImpl out = new CalculatorServiceImpl();

    public static Stream<Arguments> provideParamsForTests() {
        return Stream.of(
                Arguments.of(4, -5),
                Arguments.of(4, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTests")
    public void shouldReturnCorrectPlusResult(int a, int b) {
        int actual = out.plus(a, b);
        int expected = a + b;
        Assertions.assertEquals(expected, actual);
    }
    @ParameterizedTest
    @MethodSource("provideParamsForTests")
    public void shouldReturnCorrectMinusResult(int a, int b) {
        int actual = out.minus(a, b);
        int expected = a - b;
        Assertions.assertEquals(expected, actual);
    }
    @ParameterizedTest
    @MethodSource("provideParamsForTests")
    public void shouldReturnCorrectMultiplyResult(int a, int b) {
        int actual = out.multiply(a, b);
        int expected = a * b;
        Assertions.assertEquals(expected, actual);
    }
    @ParameterizedTest
    @MethodSource("provideParamsForTests")
    public void shouldReturnCorrectDivideResult(int a, int b) {
        double actual = out.divide(a, b);
        double expected = (double) a / b;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldThrowExceptionWhenDivisionByZero(){
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->out.divide(4,0));
    }
}
