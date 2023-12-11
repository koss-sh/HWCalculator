package pro.sky.java.course2.calculator.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.calculator.Service.CalculatorService;

@RestController
@RequestMapping("/library")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    String hello() {
        return "ljhasfvsh";
    }
    @GetMapping("/greetings")
    String showGreetings(@RequestParam String name, @RequestParam String lastName) {
        return "Hello, " + name + " " + lastName;
    }
    @GetMapping("/counter")
    String count() {
        return "Количество запросов: " + calculatorService.getRequestCount();
    }
}

