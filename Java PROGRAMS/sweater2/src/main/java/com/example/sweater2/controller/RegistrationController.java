package com.example.sweater2.controller;

import com.example.sweater2.domain.Role;
import com.example.sweater2.domain.User;
import com.example.sweater2.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepo userRepo;
    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }
    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model){
        User userFromDb = userRepo.findByUsername(user.getUsername()); // Находим по юзернейму в существующей таблице
        if (userFromDb != null){ // если есть запись
            model.put("message", "User exists!"); // пишем что он уже был создан
            return "registration"; // возвращаем шаблон регистрации (html файл)
        }
        user.setActive(true); // добавление нового юзера ( пишем что он активен )
        user.setRoles(Collections.singleton(Role.USER)); // пишем что его роль - юзер
        userRepo.save(user);    // посылаем данные в бд
        return "redirect:/login"; // делаем переход на логин форму

    }
}
