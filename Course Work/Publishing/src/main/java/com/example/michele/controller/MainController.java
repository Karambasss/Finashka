package com.example.michele.controller;
import com.example.michele.domain.Production;
import com.example.michele.repos.ProductionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * <p>Класс необходим для отображения главной страницы сайта</p>
 * @author Кузнецов Михаил
 */
@Controller
public class MainController {
    @Autowired
    ProductionRepo productionRepo;

    /**
     * Данный метод позволяет показать главную страницу сайта
     * @param model Модель
     * @return форма главной страницы
     */
    @GetMapping
    public String main(Model model){
        List<Production> productions = productionRepo.findAll();
        int size = productions.size();
        if (size != 0){
            model.addAttribute("productions", productions);
        }
        model.addAttribute("size", size);
        return "mainPage";
    }

    /**
     * Данный метод позволяет показывать страницу об авторе
     * @return страницу об авторе
     */
    @GetMapping("/aboutMe")
    public String aboutMe(){
        return "aboutMe";
    }

    /**
     * <p>Данный метод позволяет ограничить посещения личного кабинета клиента для сотрудника, и ограничить посещения личного кабинета сотрудника для клиента</p>
     * <p>Сотрудник имеет право перейти только на свой личный кабинет сотрудника</p>
     * <p>Клиент имеет право перейти только на свой личный кабинет клиента</p>
     * @return переход на личный кабинет для сотрудника или клиента в зависимости от роли пользователя
     */
    @GetMapping("/greeting")
    public String greeting(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("CLIENT"))){ // получаем их тех кто авторизован, если его роль клиент, то даем ему отдельную форму для перехода
            return "greeting1"; // даем всем ролям = CLIENT переход онли на меню клиента -  greeting1, если что, они никогда не смогут попасть со своей ролью = CLIENT на форму сотрудника(greeting)
        }
        return "greeting"; // а для тех, чья роль != CLIENT переход онли на меню сотрудника -  greeting ( если что, они не могут попасть никогда со своей ролью != CLIENT на форму клиента(greeting1)
    }
}
