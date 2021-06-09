package com.example.michele.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>В данном классе обрабатывается любая ошибка, возникающая на сайте </p>
 *
 * @author Кузнецов Михаил
 */
@Controller
public class ExceptionController implements ErrorController {
    /**
     * Данный метод определяет код ошибки, и в зависимости от него сообщает пользователю о типе произошедшей ошибки.
     * @param request запрос
     * @param model модель
     * @return форму показа ошибок
     */
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model){
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        System.out.println("status_code = " + statusCode);
        System.out.println("Error!!!!");
        if (statusCode == 400){
            model.addAttribute("error_message", "Неправильный запрос!");
        }
        else if (statusCode == 404){
            model.addAttribute("error_message", "Ресурс не найден");
        }
        else if (statusCode == 403){
            model.addAttribute("error_message", "Доступ запрещен");
        }
        else if (statusCode == 502){
            model.addAttribute("error_message", "Ошибка шлюза или же плохой шлюз");
        }
        else if (statusCode == 500){
            model.addAttribute("error_message", "Внутренняя ошибка сервера");
        }
        else if (statusCode == 503){
            model.addAttribute("error_message", "Сервис недоступен");
        }
        else {
            model.addAttribute("error_message", "Возникла ошибка");
        }
        return "errorMessage";
    }

    /**
     * Данный метод возвращает путь, по которому возможно обработать ошибку.
     * @return путь
     */
    @Override
    public String getErrorPath() {
        return "/error";
    }
}
