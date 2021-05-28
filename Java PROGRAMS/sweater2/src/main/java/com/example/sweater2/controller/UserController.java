package com.example.sweater2.controller;

import com.example.sweater2.domain.Role;
import com.example.sweater2.domain.User;
import com.example.sweater2.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {
    @Autowired
    UserRepo userRepo;
    @GetMapping //путь /user
    public String userList(Model model){
        model.addAttribute("users", userRepo.findAll());
        return "userList";
    }
    @GetMapping("{user}") //любое что будет после /user/ запишется в User, где PathVariable - переменная которая идет из пути ( путь {user})
    public String userEditForm(@PathVariable User user, Model model){ // вот сюда попадает индентификатор пользователя ({user})
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }
    @PostMapping
    public String userSave(
            @RequestParam String username,
            @RequestParam("userId") User user,
            @RequestParam Map<String, String> form ){ // Получаем форму из запроса
        user.setUsername(username);
        Set<String> roles = Arrays.stream(Role.values()).map(Role::name).collect(Collectors.toSet()); // получаем множество ролей
        user.getRoles().clear();
        for (String key: form.keySet()){
            if (roles.contains(key)){ // если нашли ключ который является ролью
                user.getRoles().add(Role.valueOf(key)); // добавляем  в юзер поле
            }
        }
        userRepo.save(user);
        return "redirect:/user";
    }
}
