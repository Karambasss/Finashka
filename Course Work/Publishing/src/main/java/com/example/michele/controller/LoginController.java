package com.example.michele.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;

/**
 * В данном классе реализуется функционал для отображения страницы авторизации
 */
@Controller
public class LoginController {
    /**
     * В данном методе производится обработка ситуации, когда пользователь ввел не тот логин или пароль, в таком случае, выводится предупреждения пользователю об ошибке, на экран
     * @param loginError пришла ли ошибка
     * @param model модель
     * @return страницу авторизации
     */
    @GetMapping("/login")
    public String loging(@RequestParam(value = "error", defaultValue = "false") boolean loginError, Model model){
        if (loginError){
            model.addAttribute("loginError", true);
        }
        return "login";
    }
}
