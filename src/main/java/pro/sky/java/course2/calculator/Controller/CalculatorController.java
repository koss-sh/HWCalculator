package pro.sky.java.course2.calculator.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.calculator.Service.CalculatorService;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    String welcome() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    String plus(@RequestParam(value = "num1", required = false) Integer a,
                @RequestParam(value = "num2", required = false) Integer b) {
        return buildView(a, b, "+");
    }

    @GetMapping("/minus")
    String minus(@RequestParam(value = "num1", required = false) Integer a,
                 @RequestParam(value = "num2", required = false) Integer b) {
        return buildView(a, b, "-");
    }

    @GetMapping("/multiply")
    String multiply(@RequestParam(value = "num1", required = false) Integer a,
                    @RequestParam(value = "num2", required = false) Integer b) {
        return buildView(a, b, "*");
    }

    @GetMapping("/divide")
    String divide(@RequestParam(value = "num1", required = false) Integer a,
                  @RequestParam(value = "num2", required = false) Integer b) {
        return buildView(a, b, "/");
    }

    private String buildView(Integer a, Integer b, String operation) {
        if (a == null || b == null) {
            return "Не передан один или оба параметра!";
        }
        if ("/".equals(operation) && b == 0) {
            return "Деление на 0 запрещено!";
        }
        Number result;
        switch (operation) {
            case "+":
                result = calculatorService.plus(a, b);
                break;
            case "-":
                result = calculatorService.minus(a, b);
                break;
            case "*":
                result = calculatorService.multiply(a, b);
                break;
            case "/":
                result = calculatorService.divide(a, b);
                break;
            default:
                result = calculatorService.plus(a, b);
        }
        return a + " " + operation + " " + b + " = " + result;
    }

}

