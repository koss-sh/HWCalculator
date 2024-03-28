package pro.sky.java.course2.calculator.Service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {


    @Override
    public int plus(int a, int b) {
        return a + b;
    }

    @Override
    public int minus(int a, int b) {
        return a - b;
    }

    @Override
    public int multiply(int a, int b) {
        return a * b;
    }

    @Override
    public double divide(int a, int b) {
        if (b != 0) {
            return a / (double) b;
        }
        throw new IllegalArgumentException("Делить на 0 нельзя!");
    }
}