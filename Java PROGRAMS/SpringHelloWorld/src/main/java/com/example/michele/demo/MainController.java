package com.example.michele.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Scanner;

@Controller
public class MainController {

    public String getHello(){
        return "Hello World";
    }

    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("message", getHello());
        return "greeting";
    }
}
