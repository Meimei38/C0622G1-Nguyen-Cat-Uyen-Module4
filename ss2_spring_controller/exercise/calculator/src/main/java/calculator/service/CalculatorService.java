package calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {
    @Override
    public double calculate(String function, double number1, double number2) {
        switch (function){
            case "+":
                return number1+number2;

            case "-":
                return number1-number2;

            case "*":
                return number1*number2;

            default:
                if(number2==0){
                    throw new RuntimeException("Cannot divide by zero!");
                }else {
                    return number1/number2;
                }
        }
    }
}
