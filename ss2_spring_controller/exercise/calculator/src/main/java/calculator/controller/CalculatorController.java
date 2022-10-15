package calculator.controller;

import calculator.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class CalculatorController {
    @Autowired
    private ICalculatorService calculatorService;

    @RequestMapping("/")
    public String showForm() {
        return "index";
    }

    @RequestMapping("/calculate")
    public String calculate(@RequestParam String function, double number1, double number2, Model model) {
        try{
            double result = calculatorService.calculate(function, number1, number2);
            model.addAttribute("number1", number1);
            model.addAttribute("number2", number2);
            model.addAttribute("result", result);
        }catch (RuntimeException e){
            model.addAttribute("number1", number1);
            model.addAttribute("number2", number2);
            model.addAttribute("result", "Cannot divide by 0");
        }

        return "index";

    }
}
