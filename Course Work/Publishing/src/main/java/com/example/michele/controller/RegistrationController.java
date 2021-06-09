package com.example.michele.controller;

import com.example.michele.domain.Client;
import com.example.michele.domain.Role;
import com.example.michele.domain.User;
import com.example.michele.repos.ClientRepo;
import com.example.michele.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

/**
 * Данный класс отвечает за регистрацию нового клиента
 * @author Кузнецов Михаил
 */
@Controller
@RequestMapping("/registration")
public class RegistrationController {
    @Autowired
    UserRepo userRepo;
    @Autowired
    ClientRepo clientRepo;

    /**
     * Данный метод помогает показать форму регистрации клиента
     * @return форму регистрации клиента
     */
    @GetMapping
    public String showToRegisterClient(){
        return "/registration";
    }

    /**
     * Данный метод позволяет зарегистрировать ( создать и сохранить ) нового клиента
     * @param client клиент
     * @param name имя
     * @param surname фамилия
     * @param organization_name имя организации клиента (тк клиенты - Юр. лица)
     * @param username - логин клиента
     * @param password - пароль клиента
     * @param model модель
     * @return переход на главную страницу сайта
     */
    @PostMapping
    public String addClient(Client client,
                            @RequestParam String name, @RequestParam String surname,
                            @RequestParam String organization_name ,
                            @RequestParam String username,
                            @RequestParam String password,
                            Model model){

        User findUser = userRepo.findByUsername(username);
        if (findUser != null){
            model.addAttribute("message", "Такой логин уже существует, попробуйте придумать новый!");
            return "registration";
        }

        User user = new User(username,password);
        user.setRole_of_user(Collections.singleton(Role.CLIENT));
        userRepo.save(user);
        client.setUser(user);
        client.setName(name);
        client.setSurname(surname);
        client.setOrganization_name(organization_name);
        clientRepo.save(client);
        return "redirect:/";
    }

}
