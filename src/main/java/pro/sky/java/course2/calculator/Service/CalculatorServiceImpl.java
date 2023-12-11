package pro.sky.java.course2.calculator.Service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService{

    private int requestCount;
    @Override
    public int getRequestCount() {
        return ++requestCount;
    }
}
