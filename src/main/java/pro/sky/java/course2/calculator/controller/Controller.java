package pro.sky.java.course2.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/calculator ")
    public String showCounter() {
        return "Добро пожаловать в калькулятор";
    }
}

