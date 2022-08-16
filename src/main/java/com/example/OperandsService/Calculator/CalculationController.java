package com.example.OperandsService.Calculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CalculationController {

    @GetMapping("/")
    public String calculator(final Model model){
        model.addAttribute("calculation", new Calculation());
        return "calculator";
    }

    RestTemplate restTemplate = new RestTemplate();

    @PostMapping("/calculate")
    public String calculate( Calculation calculation, RedirectAttributes redirAttrs) {
        String result = restTemplate.getForObject("http://localhost:8082/calculate/"+calculation.getOperand1()+"/"+calculation.getOperand2()+"/"+calculation.getOperator(),String.class);
        redirAttrs.addFlashAttribute("answer", result);
        return "redirect:/";
    }
}
