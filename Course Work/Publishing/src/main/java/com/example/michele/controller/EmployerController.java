package com.example.michele.controller;

import com.example.michele.domain.Contract;
import com.example.michele.domain.Employer;
import com.example.michele.domain.Role;
import com.example.michele.domain.User;
import com.example.michele.repos.ContractRepo;
import com.example.michele.repos.EmployerRepo;
import com.example.michele.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>Данный класс необходим для работы с сотрудниками</p>
 * В данном классе присутствуют методы для добавления, редактирования, удаления сотрудников издательства, класс доступен только для администратора.
 * @author Кузнецов Михаил
 */
@Controller
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("/employee")
public class EmployerController {
    @Autowired
    EmployerRepo employerRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    ContractRepo contractRepo;

    /**
     * Данный метод позволяет генеральному директору/администратору показывать всех сотрудников издательства
     * @param model Модель
     * @return форма всех сотрудников издательства
     */
    @GetMapping
    public String main(Model model){
        Iterable<Employer> employees;
        employees = employerRepo.findAll();
        int size = (int) employees.spliterator().getExactSizeIfKnown();
        if (size != 0){
            model.addAttribute("employees", employees);
        }
        model.addAttribute("size", size);
        return "employee";
    }

    /**
     * Данный метод помогает показать форму редактирования сотрудника
     * @param Id айди
     * @param model модель
     * @return форма редактирования сотрудника
     */
    @GetMapping("{Id}") //любое что будет после /user/ запишется в User, где PathVariable - переменная которая идет из пути ( путь {user})
    public String userEditForm(@PathVariable Long Id, Model model){ // вот сюда попадает индентификатор пользователя ({user})

        Employer employer = employerRepo.findByid(Id);

        if (employer != null){
            model.addAttribute("roles", Role.values());
            model.addAttribute("employee", employer);
        }
        return "employeeEdit";
    }

    /**
     * Данный метод позволяет изменить старые данные сотрудника на новые данные, введенные в полях редактирования сотрудника администратором
     * @param form форма
     * @param employee сотрудник
     * @return переход на форму всех сотрудников издательства
     */
    @PostMapping //при нажатии на кнопку летит пост запрос который изменяет данные в бд
    public String edit(
            @RequestParam Map<String, String> form,
            @RequestParam("employeeID") Employer employee){ //по выбранной id попадаем в employera){
        if (form.get("salary") == ""){ // если в форме содержится пустота
            employee.setSalary(null);
        }
        else {
            try {
                employee.setSalary(Double.parseDouble(form.get("salary")));
            }
            catch (NumberFormatException ex){

            }
        }
        if (form.get("age") == ""){ // говорим что если пустой параметр прилетел
            employee.setAge(null); //вписываем что поле пустое
        }
        else {
            try {
                employee.setAge(Integer.parseInt(form.get("age")));
            }
            catch (NumberFormatException ex){

            }
        }
        employee.setName((form.get("name")));
        employee.setSurname((form.get("surname")));
        employee.setAdress((form.get("adress")));
        employee.setEmail((form.get("email")));
        employee.setTelephone_number(form.get("telephone_number"));
        Set<String> roles = Arrays.stream(Role.values()).map(Role::name).collect(Collectors.toSet()); // получаем множество ролей
        employee.getUser().getRole_of_user().clear();
        for (String key: form.keySet()) {
            if (roles.contains(key)) { // если нашли ключ который является ролью
               employee.getUser().getRole_of_user().add(Role.valueOf(key)); // добавляем  в юзер поле
            }
        }
        employerRepo.save(employee);
        //employerRepo.deleteById(employee.getId()); // удаление пользователя
        return "redirect:/employee";
    }

    /**
     * Данный метод позволяет показать форму добавления нового сотрудника
     * @return форму добавления сотрудника
     */
    @GetMapping("/add")
    public String showToAdd(){
        return "addEmployee";
    }

    /**
     * Данный метод позволяет создать и сохранить нового сотрудника
     * @param employer сотрудник
     * @param login его логин
     * @param password его пароль
     * @param model модель
     * @return переход на форму всех сотрудников
     */
    @PostMapping("/add")
    public String weAreAdding(Employer employer,@RequestParam String login,@RequestParam String password,Model model){ //В employer попал уже полный объект класса employer(то есть заполненный employer)
        User findUser = userRepo.findByUsername(login); // ищем по юзернейму юзера
        if (findUser != null){ // если есть такой юзер
            model.addAttribute("message", "Такой логин уже существует, попробуйте придумать новый!");
            return "addEmployee";
        }
        User user = new User(login,password); // создай юзера
        user.setRole_of_user(Collections.singleton(Role.USER)); // пишем что его роль - юзер по умолчанию
        userRepo.save(user); // сохраним юзера в бд
        employer.setUser(user); // установим для таблицы employer по (foreign key user_id из таблицы user) ссылку на этого созданного юзера
        employerRepo.save(employer);
        return "redirect:/employee";
    }

    /**
     * Данный метод позволяет удалить сотрудника
     * @param id айди
     * @return переход на форму всех сотрудников
     */
    @GetMapping("/del/{id}")
    public String weAreDeletingEmployee(@PathVariable Long id){
        Employer employer = employerRepo.findByid(id); // находим по переданному айди нужного нам сотрудника
        if (employer != null){ //если мы нашли такого сотрудника
            User user = userRepo.findByid(employer.getUser().getId()); // получаем полный объект user по его айди
            List<Contract> contracts = contractRepo.findAllByEmployer(employer);
            for (Contract contract : contracts){
                contract.setEmployer(null);
                contract.setStatus("Не обработан");
                contractRepo.save(contract);
            }
            employerRepo.deleteById(id);
            userRepo.deleteById(user.getId());
        }
        else {
            System.out.println("Сотрудник + его учетка не найдена!");
        }
        return "redirect:/employee";
    }

    /**
     * Данный метод позволяет сделать сортировку полей сотрудников по указанному варианту/типу сортировки
     * @param sort_type тип сортировки
     * @param model модель
     * @return форму всех сотрудников
     */
    @PostMapping("/sort")
    public String sort(@RequestParam String sort_type, Model model){
        List<Employer> employerList = employerRepo.findAll(Sort.by(Sort.Direction.ASC,sort_type));
        int size = (int) employerList.spliterator().getExactSizeIfKnown();
        if (size != 0){
            model.addAttribute("employees", employerList);
        }
        model.addAttribute("size", size);
        return "employee";
    }
}
