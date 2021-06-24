package com.example.michele.demo.controllers;

import com.example.michele.demo.domain.User;
import com.example.michele.demo.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepo userRepo;

    @GetMapping
    public String main(Model model){
        List<User> users = userRepo.findAll();
        int size = users.size();
        if (size != 0){
            model.addAttribute("users", users);
        }
        model.addAttribute("size", size);
        return "user";
    }
    @GetMapping("/add")
    public String showToAdd(){
        return "addUser";
    }
    @PostMapping("/add")
    public String addUser(@RequestParam String age, String group_num, String name, String surname){
        User user = new User();
        try {
            user.setAge(Integer.parseInt(age));
        }
        catch (NumberFormatException exception){

        }
        user.setGroupNum(group_num);
        user.setName(name);
        user.setSurname(surname);
        userRepo.save(user);
        return "redirect:/user";
    }
    @GetMapping("{id}")
    public String userEditForm(@PathVariable Long id, Model model){
        User user = userRepo.findByid(id);
        if (user != null){
            model.addAttribute("user", user);
        }
        return "userEdit";
    }
    @PostMapping
    public String editUser(
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user){
        if (form.get("age").equals("")){
            user.setAge(null);
        }
        else {
            try {
                user.setAge(Integer.parseInt(form.get("age")));
            }
            catch (NumberFormatException exception){

            }
        }
        user.setGroupNum(form.get("group_num"));
        user.setSurname(form.get("surname"));
        user.setName(form.get("name"));
        userRepo.save(user);
        return "redirect:/user";
    }
    @GetMapping("/del/{id}")
    public String deleteUser(@PathVariable Long id){
        User user = userRepo.findByid(id);
        if (user != null){
            userRepo.deleteById(user.getId());
        }
        else {
            System.out.println("Не нашлось человека такого чтобы удалить!");
        }
        return "redirect:/user";
    }
}
