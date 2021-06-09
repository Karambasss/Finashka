package com.example.michele.controller;

import com.example.michele.domain.Author;
import com.example.michele.domain.Contract;
import com.example.michele.repos.AuthorRepo;
import com.example.michele.repos.ContractRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
/**
 * <p>Класс предназначен для работы с авторами</p>
 * Данный класс позволяет изменять, добавлять и удалять аторов
 * <p>Так же есть возможность просмотра всех авторов</p>
 * @author Кузнецов Михаил
 * */
@Controller
@PreAuthorize("hasAnyAuthority('ADMIN','AUTHOR_MANAGER')")
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorRepo authorRepo;
    @Autowired
    ContractRepo contractRepo;
    /**
     * Данный метод необходим для вывода всех авторов
     * @param model модель
     * @return форму авторов
     * */
    @GetMapping
    public String main(Model model){
        Iterable<Author> authors;
        authors = authorRepo.findAll();
        int size = (int) authors.spliterator().getExactSizeIfKnown();
        if (size != 0){
            model.addAttribute("authors", authors);
        }
        model.addAttribute("size", size);
        return "author";
    }
    /**
     * Данный метод отвечает за показ формы редактирования пользователю
     * @param id айди
     * @param model модель
     * @return форма редактирования
     *
     * */
    @GetMapping("{id}")
    public String authorEditForm(@PathVariable Long id, Model model){ //в Author author попадает уже созданный объект
        Author author = authorRepo.findByid(id);
        if (author != null){
            model.addAttribute("author", author); // подставляем данный созданный объект в модель
        }
        return "authorEdit";
    }
    /**
     * Данный метод изменяет данные редактируемого автора
     * Все содержимое полей авторов будет изменено на то, что пользователь введет
     * @param author автор
     * @param form форма
     * @return переход на форму авторов
     * */
    @PostMapping
    public String edit(
            @RequestParam(name = "authorID") Author author,
            @RequestParam Map<String,String> form){ //узнать почему <String,String>
        author.setAdress(form.get("adress"));
        if (form.get("age") == ""){
            author.setAge(null);
          }
        else {
            try {
                author.setAge(Integer.parseInt(form.get("age")));
            }
            catch (NumberFormatException exception){

            }
        }
        author.setEmail(form.get("email"));
        author.setName(form.get("surname"));
        author.setTelephone_number(form.get("telephone_number"));
        author.setName(form.get("name"));
        authorRepo.save(author);
        return "redirect:/author";
    }

    /**
     * Метод выполняющий показ страницы добавления автора
     * @return форма добавления
     */
    @GetMapping("/add")
    public String showToAddAuthor(){
        return "addAuthor";
    }
    /**
     * Метод выполняющий добавление введенных пользователем данных из формы добвления автора в БД для создания нового автора
     * @param author автор
     * @return переход на форму авторов
     * */
    @PostMapping("/add")
    public String addAuthor(Author author){
        authorRepo.save(author);
        return "redirect:/author";
    }

    /***
     * Данный метод выполняющий удаление указанного автора
     * @param id айди
     * @return переход на форму авторов
     */
    @GetMapping("/del/{id}") // Улавливаем по url /author/del/id - где id : цифра от 1 до n ( этот id попадает в pathvariable LOng id
    public String deleteAuthor(@PathVariable Long id){ // вот сюда попадает индентификатор пользователя ({user})

        Author author = authorRepo.findByid(id); // находим объект автора по айди
        if (author != null){ //если нам возвратилось не пустое значение ( автор существует )
            List<Contract> contracts = contractRepo.findAllByAuthor(author); //  находим по данному автору множество контрактов
            for (Contract contract : contracts){ // тк contracts - list - список, мы просто берем и идем по каждому элементу списка
                contract.setAuthor(null); // ставим в поле автора null чтобы можно было удалить author
                contract.setStatus("Заказ отклонен"); // статус ставим
                contract.setPrice(0); // Ставим цену
                contractRepo.save(contract); // сохраняем в BD
            }
            authorRepo.deleteById(id); // удаляем по айди данного автора
        }
        else {
            System.out.println("Пользователь не найден"); // если не нашелся то пишем
        }
        return "redirect:/author";
    }

    /**
     * Данный метод производит сортировку полей по выбранному пользоватем варианту
     * @param sort_type тип сортировки
     * @param model модель
     * @return форму авторов
     */
    @PostMapping("/sort")
    public String sort(@RequestParam String sort_type, Model model){
        List<Author> authors = authorRepo.findAll(Sort.by(Sort.Direction.ASC,sort_type)); // делаем сортировку по указанному в списке слову
        int size = (int) authors.spliterator().getExactSizeIfKnown();
        if (size != 0){
            model.addAttribute("authors", authors);
        }
        model.addAttribute("size", size);
        return "author";
    }
}
