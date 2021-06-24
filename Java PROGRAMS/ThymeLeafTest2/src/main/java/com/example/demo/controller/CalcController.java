package com.example.demo.controller;


import com.example.demo.model.CalculatorModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CalcController {

    public double getDiv(double a, double b){
        return a/b;
    }

    @GetMapping("/")
    public String greeting(){
        return "hello";
    }

    @RequestMapping(value = "/calc", params = "add", method = RequestMethod.POST)
    public String getAdd(@RequestParam Integer first, @RequestParam Integer second, Model model){
        System.out.println(first);
        System.out.println(second);
        System.out.println(first + second);
        model.addAttribute("result", first + second);
        return "hello";
    }
    @RequestMapping(value = "/calc", params = "substact", method = RequestMethod.POST)
    public String getSubstact(@RequestParam Integer first, @RequestParam Integer second, Model model){
        model.addAttribute("result", first - second);
        return "hello";
    }
    @RequestMapping(value = "/calc", params = "multiply", method = RequestMethod.POST)
    public String getMultiply(@RequestParam Integer first, @RequestParam Integer second, Model model){
        model.addAttribute("result", first * second);
        return "hello";
    }
    @RequestMapping(value = "/calc", params = "divide", method = RequestMethod.POST)
    public String getDivide(@RequestParam Double first, @RequestParam Double second, Model model){
        if (second != 0){
            model.addAttribute("result", getDiv(first, second));
        }
        else {
            model.addAttribute("result", "На ноль делить нельзя!");
        }
        return "hello";
    }
}
