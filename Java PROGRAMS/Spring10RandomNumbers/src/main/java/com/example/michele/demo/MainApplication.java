package com.example.michele.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;


@Controller
public class MainApplication {

    public double getAverage(ArrayList<Integer> arrayList){
        double a = 0;
        for (Integer i = 0; i < arrayList.size(); i++){
            a += arrayList.get(i);
        }
        double size = arrayList.size();
        System.out.println("Среднее: " + a/arrayList.size());
        return a/size;
    }

    public ArrayList<Integer> getRandomNumbers(Integer a, Integer b){
        if (a < b){
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i < 10; i++){
                int resultNum = (int) (Math.random() * ((b - a) + 1)  + a);
                arrayList.add(resultNum);
            }
            return arrayList;
        }
        if (a > b){
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i < 10; i++){
                int resultNum = (int) (Math.random() * ((a - b) + 1) + b);
                arrayList.add(resultNum);
            }
            return arrayList;
        }
        return null;
    }

    @GetMapping("/")
    public String main(){
        return "greeting";
    }
    @PostMapping("/")
    public String getNumbers(@RequestParam Integer chislo1, @RequestParam Integer chislo2, Model model){
        ArrayList<Integer> randomList = getRandomNumbers(chislo1, chislo2);
        if (randomList != null){
            model.addAttribute("range", randomList.toString());
            double average = getAverage(randomList);
            model.addAttribute("message", average);
        }
        return "greeting";
    }
}
