package pro.sky.java.course2.calculator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.calculator.service.CalculateServiceImpl;

@RestController

@RequestMapping("/calculator")

public class Controller {
    @GetMapping()
    public String showCounter() {
        return "Добро пожаловать в калькулятор";
    }
    private final CalculateServiceImpl calculateService;

    public Controller(CalculateServiceImpl calculateService) {
        this.calculateService = calculateService;
    }
    @GetMapping("/plus")
    public String plus (@RequestParam double num1, @RequestParam double num2) {
        return num1 + " + "  + num2 + " = " + calculateService.plus(num1, num2);
    }
    @GetMapping("/minus")
    public String minus (@RequestParam double num1, @RequestParam double num2) {
        return num1 + " - "  + num2 + " = " + calculateService.minus(num1, num2);
    }
    @GetMapping("/multiply")
    public String multiply(@RequestParam double num1, @RequestParam double num2) {
        return num1 + " * "  + num2 + " = " + calculateService.multiply(num1, num2);
    }
    @GetMapping("/divide")

    public ResponseEntity<String> divide (@RequestParam double num1, @RequestParam double num2) {
        if(num2 == 0){
            return ResponseEntity.badRequest().body("Запрещено деление на ноль");
        }
        return ResponseEntity.ok( num1 + " / "  +  num2 + " = " + calculateService.divide(num1, num2));
    }

}

