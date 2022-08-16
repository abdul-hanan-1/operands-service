package com.example.OperandsService.Calculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CalculationController {
    List<String> operators;
    @ModelAttribute
    public void preLoad(Model model){
        operators = new ArrayList<>();
        operators.add("Super Mario");
        operators.add("Contraaa");
        operators.add("Elevator");
    }
    @GetMapping("/")
    public String calculator(final Model model){
        model.addAttribute("operators", operators);
        model.addAttribute("calculation", new Calculation());
        return "calculator";
    }
}
