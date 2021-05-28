package com.example.sweater2.controller;

import com.example.sweater2.domain.Message;
import com.example.sweater2.domain.User;
import com.example.sweater2.repos.MessageRepo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController { // модуль который по пути слушает запросы и выдает данные
    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/") // путь (get - возвращаем инфу)
    public String greeting(Map<String,Object> model) {
        return "greeting"; // возвращаем в greeting шаблон
    }
    @GetMapping("/main")
    public String main(@RequestParam(required = false) String my_tag,  Model model){
        Iterable<Message> messages;
        if (my_tag != null && !my_tag.isEmpty()) {
            messages = messageRepo.findByTag(my_tag);
            model.addAttribute("input_tag",my_tag);
        } else {
            messages = messageRepo.findAll();
        }
        model.addAttribute("messages", messages); //как будто говорим, для первого парметра(имя {{Some}} на мусташе, впиши значение, переданное во 2 параметре) первый параметр: это имя, 2 параметр - это то что мы хотим в это имя присвоить
        return "main";
    }
    //    @PostMapping
//    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model) { // name  из mustache - request param, который летит в String text
//        Message message = new Message(text, tag);
//
//        messageRepo.save(message); //послать в бд
//
//        Iterable<Message> messages = messageRepo.findAll(); // select для messages
//
//        //System.out.println(messages);
//
//        model.put("messages", messages);
//
//        return "main";
//    }
    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam(name="text") String my_text,
            @RequestParam(name="tag") String my_tag, Map<String, Object> model) { // name  из mustache - request param, который летит в String text
        Message message = new Message(my_text, my_tag, user);

        messageRepo.save(message); //послать в бд

        Iterable<Message> messages = messageRepo.findAll(); // select для messages

        //System.out.println(messages);

        model.put("messages", messages);

        return "redirect:/main";
    }
}
