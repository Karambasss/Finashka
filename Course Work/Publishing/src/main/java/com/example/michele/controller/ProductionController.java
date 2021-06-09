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

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>Данный класс позволяет работать с продукцией</p>
 * Тут находятся методы, позволяющие сделать добавление, редактирования и удаление продукции
 * Есть методы для просмотра сотрудником всех продукций
 * @author Кузнецов Михаил
 */
@Controller
@PreAuthorize("hasAnyAuthority('ADMIN','PRODUCTION_MANAGER')")
@RequestMapping("/production")
public class ProductionController {
    @Autowired
    ProductionRepo productionRepo;
    @Autowired
    TypographyRepo typographyRepo;
    @Autowired
    ContractRepo contractRepo;

    /**
     * Данный метод позволяет показать все продукции
     * @param model Модель
     * @return форму всех продукций
     */
    @GetMapping
    public String main(Model model){
        Iterable<Production> productions;
        productions = productionRepo.findAll(Sort.by(Sort.Direction.ASC,"name")); // сортировка по умолчанию по имени
        int size = (int) productions.spliterator().getExactSizeIfKnown();
        if (size != 0){
            model.addAttribute("productions", productions);
        }
        model.addAttribute("size", size);
        return "production";
    }

    /**
     * Данный метод позволяет отображать форму редактирования продукции
     * @param id айди
     * @param model модель
     * @return форма редактирования продукции
     */
    @GetMapping("{id}")
    public String productionEditForm(@PathVariable Long id, Model model){
        Production production = productionRepo.findByid(id);
        List<Typography> typographies = typographyRepo.findAll();
        if (production != null){
            model.addAttribute("production", production);
            model.addAttribute("typographies",typographies);
        }
        return "productionEdit";
    }

    /**
     * Данный метод позволяет заменить данные заказа на новые данные, введенные в полях формы редактирования продукции
     * @param form форма
     * @param production продукция
     * @return переход на форму всех продукций
     */
    @PostMapping
    public String productionEdit(@RequestParam Map<String, String> form,
                                 @RequestParam("productionID") Production production){
        production.setName(form.get("name"));
        production.setDescription(form.get("description"));
        production.getTypographies().clear();
        for (String key:form.keySet()){
            System.out.println(key);
            if (form.get(key).equals("on")){
                production.getTypographies().add(typographyRepo.findByid(Long.parseLong(key)));
            }
        }
        productionRepo.save(production);
        return "redirect:/production";
    }

    /**
     * Данный метод позволяет показать форму добавления продукции
     * @param model Модель
     * @return форму добавления продукции
     */
    @GetMapping("/add")
    public String showToAddProduct(Model model){
        Iterable<Typography> typographies;
        typographies = typographyRepo.findAll(); // находим все типографии
        model.addAttribute("typographies", typographies); //  отправляем в форму
        return "addProduction";
    }

    /**
     * Данный метод позволяет создать и сохранить новую продукцию
     * @param description описание
     * @param name имя
     * @param form форма
     * @return переход на форму всех продукций
     */
    @PostMapping("/add")
    public String addProduct(@RequestParam String description, @RequestParam String name,
                             @RequestParam Map<String, String> form
    ){
        Production product = new Production();
        product.setName(name);
        product.setDescription(description);

        List<Typography> types = typographyRepo.findAll();
        Set<Long> typographySet = new HashSet<>();
        for (Typography typography : types) {
            Long id = typography.getId();
            typographySet.add(id);
        }
//        System.out.println(types.get(0).getName());
        for (String key: form.keySet()) {
            //System.out.println(key);
            if (form.get(key).equals("on")){
                product.getTypographies().add(typographyRepo.findByid(Long.parseLong(key)));
//                    System.out.println("KKK!" + key);
            }
        }
        productionRepo.save(product);

        //        Iterable <Typography> typographies = typographyRepo.findAll();
//        System.out.println(typographies.forEach(typography -> typography.getId());

        return "redirect:/production";
    }

    /**
     * Данный метод позволяет удалить указанную пользователем продукцию
     * @param id айди
     * @return переход на форму всех продукций
     */
    @GetMapping("/del/{id}")
    public String deleteProduction(@PathVariable Long id){
        Production production = productionRepo.findByid(id);

        if (production != null){
            List<Contract> contracts = contractRepo.findAllByProduction(production);
            for (Contract contract : contracts){
                contract.setProduction(null);
                contract.setStatus("Заказ отклонен");
                contract.setPrice(0);
                contractRepo.save(contract);
            }
            List <Typography> types = typographyRepo.findAll();
            for (Typography typography : types) {
                Set<Production> productionSet = typography.getProductionSet();
                if (productionSet.contains(production)){
                    production.removeTyp(typography); //удаляем из set<> объекты (разрываем связи друг с другом) (убирается строчка из product_typ)
                    typographyRepo.save(typography); //обновляем информацию о типографии  (что там теперь не находится продукт тк мы его удалили)
                    //productionRepo.deleteById(id); // удаляем из базы продукт
                }
            }
            productionRepo.deleteById(id); // если не пришла типография в продукции ( нет ссылок на типографию ) тогда мы удалим продукцию ( или мы обработали все связи(отношения )с типографией ( убрали все типографии из продукции) и убрали все продукции из типографии), то теперь в нашей продукции лежит обычный объект продукции без ссылок на типографию, а в типографии лежит обычный объект типографии без ссылок на продукцию ( все связи обработаны и удалены между данными сущностями(объектами) теперь мы можем спокойно удалять продукцию)
        }
        else {
            System.out.println("Не нашлась такая продукция!");
        }
        return "redirect:/production";
    }
}
