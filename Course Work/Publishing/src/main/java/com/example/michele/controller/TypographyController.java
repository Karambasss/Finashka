package com.example.michele.controller;

import com.example.michele.domain.Contract;
import com.example.michele.domain.Production;
import com.example.michele.domain.Typography;
import com.example.michele.repos.ContractRepo;
import com.example.michele.repos.ProductionRepo;
import com.example.michele.repos.TypographyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Данный класс отвечает за работу с типографиями
 * В нем существуют методы для добавления, удаления и редактирования типографий
 * Есть методы для отображения всех типографий
 * @author Кузнецов Михаил
 */
@Controller
@PreAuthorize("hasAnyAuthority('ADMIN','TYPOGRAPHY_MANAGER')")
@RequestMapping("/typography")
public class TypographyController {
    @Autowired
    TypographyRepo typographyRepo;
    @Autowired
    ProductionRepo productionRepo;
    @Autowired
    ContractRepo contractRepo;

    /**
     * Метод для показа всех типографий сотрудникам издательства
     * @param model Модель
     * @return форму всех типографий
     */
    @GetMapping
    public String main(Model model){
        Iterable<Typography> typographies;
        typographies = typographyRepo.findAll(Sort.by(Sort.Direction.ASC,"name")); // по умолчанию сортировка по name
        int size = (int) typographies.spliterator().getExactSizeIfKnown();
        if (size != 0){ //если размер не пустой
            model.addAttribute("typographies", typographies); // значит у нас что то лежит в бд и мы заполняем
        }
        model.addAttribute("size", size);
        return "typography";
    }

    /**
     * Данный метод позволяет отображать форму редактирования типографии
     * @param id айди
     * @param model модель
     * @return форму редактирования типографии
     */
    @GetMapping("{id}") //любое что будет после /typography/ запишется в Typography, где PathVariable - переменная которая идет из пути ( путь {typography})
    public String typographyEditForm(@PathVariable Long id, Model model){ // вот сюда попадает индентификатор пользователя ({user})
        Typography typography = typographyRepo.findByid(id);
        if (typography != null){ // если нашлась типография
            model.addAttribute("typography", typography);
        }
        return "typographyEdit";
    }

    /**
     * Данный метод позволяет изменить данные типографии на новые данные, введеные в полях редактирования типографии
     * @param form форма
     * @param typography типография
     * @return переход на форму всех типографий
     */
    @PostMapping
    public String typographyEdit(@RequestParam Map<String, String> form,
                                 @RequestParam("typographyID") Typography typography){
        typography.setName(form.get("name"));
        typography.setRequisites(form.get("requisites"));
        typography.setTelephone_number(form.get("telephone_number"));
        typography.setTypography_address(form.get("typography_address"));
        typographyRepo.save(typography);
        return "redirect:/typography";
    }

    /**
     * Данный метод позволяет добавлять новую типографию
     * @return форму добавления типографии
     */
    @GetMapping("/add")
    public String showToAddTypography(){
        return "addTypography";
    }

    /**
     * Данный метод позволяет создать и сохранить новую типографию
     * @param typography Типография
     * @return переход на форму всех типографий
     */
    @PostMapping("/add")
    public String addTypography(Typography typography){ //прилетает уже полученный объект типографии
        typographyRepo.save(typography);
        return "redirect:/typography";
    }

    /**
     * Данный метод позволяет удалить типографию
     * @param id айди
     * @return переход на форму всех типографий
     */
    @GetMapping("/del/{id}")
    public String deleteTypography(@PathVariable Long id){
        Typography typography = typographyRepo.findByid(id); // по переданному айди ищем типографию
        if (typography != null){ // если объект не пустой ( нашлась такая типография)
            List<Contract> contracts = contractRepo.findAllByTypography(typography);
            for (Contract contract : contracts){
                contract.setTypography(null);
                contract.setStatus("Заказ отклонен");
                contract.setPrice(0);
                contractRepo.save(contract);
            }
            List<Production> productions = productionRepo.findAll(); // получили все продукции
            for (Production production: productions){ // идем по каждой продукции
                Set<Typography> typographySet = production.getTypographies(); // получаем в каждой продукции Set типографий
                if (typographySet.contains(typography)){ // если нашли во множестве (в продукции типографию)
                    typography.removeProd(production); // то разрываем связи(отношения между этими сущностями)
                    productionRepo.save(production); // после того как обновили связи (отношения между этими таблицами) у нас в Set<typography> сущности Production убралась данная типография, после чего мы спокойно обновляем информацию о данной сущности уже без прямого ссылания на типографию
                    //typographyRepo.deleteById(id); // после того как удалили связи(отношения) между данными сущностями(объектами), мы можем спокойно удалить безопасно для нас типографию
                }
            }
            typographyRepo.deleteById(id); // так как в некоторых наших отношениях с таблицами связей к типографии у продукции может бытть несколько, то удалить безопасно после каждого прохода цикла мы не сможем, так что я придумал такую логику: мы удаляем сначала отношения, потом после всех проходов по продукциям, если уже там не содержится ни одной типографии, мы уже можем просто взять и удалить саму типографию безопасно(тк на нее никто не ссылается)
        }
        else { // если типография не нашлась по айди, то мы обрабатываем ошибку Not Found таким обычным сообщением в нашу консоль(это можно как message вывести, но я считаю, что это достаточно некрасиво будет выглядеть)
            System.out.println("Не нашлась такая типография!");
        }
        return "redirect:/typography"; // выходим обратно в список типографий
    }
}
