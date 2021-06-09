package com.example.michele.controller;

import com.example.michele.domain.*;
import com.example.michele.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>Данный класс необходим сотрудникам издательства для работы с заказами клиентов</p>
 * В данном классе содержатся методы, позволяющие сотрудникам издательства смотреть, проставлять статусы, находить авторов и типографии для выполнения заказов клиента
 * @author Кузнецов Михаил
 */
@Controller
@PreAuthorize("hasAnyAuthority('ADMIN','ACCOUNTANT')")
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    ContractRepo contractRepo;
    @Autowired
    AuthorRepo authorRepo;
    @Autowired
    TypographyRepo typographyRepo;
    @Autowired
    EmployerRepo employerRepo;
    @Autowired
    UserRepo userRepo;

    /**
     * Данный метод позволяет показывать сотрудникам издательства все заказы клиентов
     * @param model модель
     * @return форму всех заказов клиентов
     */
    @GetMapping
    public String main(Model model){
        Iterable<Contract> contracts;
//        contracts = contractRepo.findAll(Sort.by(Sort.Direction.ASC,"price","value"));
        contracts = contractRepo.findAll();
        int size = (int) contracts.spliterator().getExactSizeIfKnown();
        if (size != 0){  // если в бд что то лежит
            model.addAttribute("contracts", contracts);
        }
        model.addAttribute("size", size);
        return "contract";
    }

    /**
     * Данный метод позволяет показывать форму редактирования заказа клиента сотруднику издательства
     * @param id айди
     * @param model модель
     * @return форму редактирования заказа
     */
    @GetMapping("{id}")
    public String contractEditForm(@PathVariable Long id, Model model){
        Contract contract = contractRepo.findByid(id);
        if (contract.getStatus().equals("Заказ отклонен")){ // если статус = заказ отменен ( он отменен при потере автора, увольнении сотрудника, нет товара в меню),  то мы перенаправляем на /contract
            return "redirect:/contract";
        }
        List<Author> authors = authorRepo.findAll();
        List<Typography> typographies = typographyRepo.findAll();
        if (contract != null){
            model.addAttribute("contract",contract);
            model.addAttribute("authors", authors);
            model.addAttribute("typographies", typographies);
        }
        return "contractEdit";
    }

    /**
     * Данный метод позволяет изменить данные заказа на новые данные, введенные в полях редактирования заказа сотрудником издательства
     * @param price Цена
     * @param author_selected_id Айди выбранного автора
     * @param typography_selected_id Айди выбранной типографии
     * @param contractID Айди заказа
     * @return переход на форму всех заказов клиентов
     */
    @PostMapping
    public String contractEdit(@RequestParam Integer price,
                               @RequestParam Long author_selected_id,
                               @RequestParam Long typography_selected_id,
                               @RequestParam Long contractID){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Employer employer = employerRepo.findByUser(userRepo.findByUsername(auth.getName()));
        Contract contract = contractRepo.findByid(contractID);
        Author author = authorRepo.findByid(author_selected_id);
        Typography typography = typographyRepo.findByid(typography_selected_id);
        contract.setAuthor(author);
        contract.setTypography(typography);
        contract.setAuthor_requisites(author.getAuthor_requisites());
        contract.setPublisher_requisites(typography.getRequisites());
        contract.setPrice(price);
        contract.setEmployer(employer);
        contract.setStatus("Заказ в работе");
        contractRepo.save(contract);
        return "redirect:/contract";
    }

    /**
     * Данный метод позволяет совершить сортировку полей заказов клиентов по введенным сотруднику варианту сортировки
     * @param sort_type Тип сортировки
     * @param model Модель
     * @return форма всех заказов клиентов
     */
    @PostMapping("/sort")
    public String sort(@RequestParam String sort_type, Model model){
        List<Contract> contracts = contractRepo.findAll(Sort.by(Sort.Direction.ASC,sort_type));
        int size = (int) contracts.spliterator().getExactSizeIfKnown(); // получаем размер списка
        if (size != 0){ // если размер не ноль
            model.addAttribute("contracts", contracts); // отдаем в форму список контрактов
        }
        model.addAttribute("size", size); // отдаем сайз в форму
        return "contract";
    }

    /**
     * Данный метод позволяет сотруднику совершать анализ заказов, он может найти максимальную и минимальную стоимость заказа , среднее значение, выручку.
     * @param analytics выбранный вариант анализа
     * @param model модель
     * @return форма всех заказов клиента
     */
    @PostMapping("/analytics")
    public String analytics(@RequestParam String analytics, Model model){
        List<Contract> contracts = contractRepo.findAll(); // все наши договоры
        int size = contracts.size(); // смотрим кол-во договоров
        if (size != 0) { // если есть что - то ( договоры не пустые)
            model.addAttribute("contracts", contracts); // засовываем в модель наши договоры
            if (analytics.equals("max")) { // если выбрали из списка найти максимум
                int maximum = -999;
                for (Contract contract : contracts) {
                    int c_price = contract.getPrice();
                    if (c_price > maximum) {
                        maximum = c_price;
                    }
                }
                model.addAttribute("message", maximum); // после всех действий отдаем в модель этот максимум
            }
            else if (analytics.equals("min")){ // если выбрали из списка найти минимум
                int minimum = 9999;
                for (Contract contract : contracts){
                    int c_price = contract.getPrice();
                    if (c_price < minimum){
                        minimum = c_price;
                    }
                }
                model.addAttribute("message",minimum); // засовываем в модель минимум
            }
            else if (analytics.equals("srznach")){ // если выбрали найти среднее значение
                double summa = 0;
                double quantity = contracts.size();
                for (Contract contract : contracts){
                    summa += contract.getPrice();
                }
                double itog = summa/quantity;

                model.addAttribute("message", itog); // отдаем в модель итоговое среднее значение
            }
            else if (analytics.equals("summ")){ // если выбрали найти сумму
                int summa = 0;
                for (Contract contract : contracts){
                    summa+=contract.getPrice();
                }
                model.addAttribute("message", summa); // отдаем в модель сумму
            }
        }
        model.addAttribute("size", size); // отдаем size в модель, чтобы там отследить, (там написана такая логика, если сайз != 0, то показываем все таблицы и тп, а если сайз == 0, то пишем, что договоров нет)
        return "contract";
    }
}
