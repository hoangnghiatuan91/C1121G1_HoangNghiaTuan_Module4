package calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.NoSuchAlgorithmException;

@Controller
public class CalculatorController {
    @GetMapping("")
    public String showIndex() {
        return "index";
    }

    @GetMapping("/calculate")
    public String calculate(@RequestParam double num1, @RequestParam double num2, @RequestParam String input, Model model) {
        Double total = 0.0;
        switch (input) {
            case "sub":
                total = (num1 - num2);
                break;
            case "sum":
                total = (num1 + num2);
                break;
            case "mul":
                total = (num1 * num2);
                break;
            case "div":
                if(num2 == 0){
                   model.addAttribute("message","Can not divide to zero");
                } else {
                    total = num1 / num2;
                }
                break;
        }
        model.addAttribute("total",total);
        return "index";
    }
}
