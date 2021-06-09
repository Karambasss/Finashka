package com.example.michele.controller;


import com.example.michele.domain.Client;
import com.example.michele.domain.Contract;
import com.example.michele.domain.Production;
import com.example.michele.repos.ClientRepo;
import com.example.michele.repos.ContractRepo;
import com.example.michele.repos.ProductionRepo;
import com.example.michele.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
/**
 *<p>Данный класс неоюходим для работы личного кабинета клиентов</p>
 *<p>В данном классе существует методы для показа личного профиля клиента, его редактирования</p>
 *<p>Есть методы для работы с заказами: клиент может создать заказ, посмотреть все свои заказы на своем аккаунте</p>
 *@author Кузнецов Михаил
 * */
@Controller
@PreAuthorize("hasAuthority('CLIENT')")
@RequestMapping("clientUser")
public class ClientUserController {
    @Autowired
    ClientRepo clientRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    ProductionRepo productionRepo;
    @Autowired
    ContractRepo contractRepo;

    /**
     * Данный метод необходим для показа клиенту его профиля
     * @param model модель
     * @return форму профиля клиента
     */
    @GetMapping("/profil")
    public String main(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            Client client = clientRepo.findByUser(userRepo.findByUsername(auth.getName())); // находим клиента по его user полю
            if (client != null ){
                model.addAttribute("client", client);
            }
        }
        else {
            System.out.println("что-то произошло очень странное и магическое!");
        }
        return "profilClient";
    }

    /**
     * Данный метод отвечает за загрузку формы редактирования личного профиля клиента. Предотвращаются любые попытки перехода не на свою форму редактирования профиля.
     * @param id айди
     * @param model модель
     * @return форму редактирования
     */
    @GetMapping("/profil/{id}")
    public String showToEditProfilOfTheUserClient(@PathVariable Long id, Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Client client1 = clientRepo.findByUser(userRepo.findByUsername(auth.getName()));
        if (client1.getId() != id){ // если не тот пользователь
            return "/greeting1";
        }

        Client client = clientRepo.findByid(id); // находим клиента по айди
        if (client != null){ // если нашли
            model.addAttribute("client", client); // заполняем его поля
        }
        return "editProfilClient"; // возвращаем форму ( если клиента не нашли, то в форме есть условие, если клиент?? (отправлен и существует), то мы заполняем форму, в ином случае мы там прописали, что если не прислан клиент, то мы возвращаемся на профиль клиента обратно
    }

    /**
     * Данный метод необходим для изменения данных о клиенте. Клиент вбивает в поля редактирования своего профиля новые данные, нажимает сохранить, и данные в БД будут заменены на новые, введенные клиентом, данные из полей редактирования
     * @param form форма
     * @param id айди
     * @return переход на форму профиля клиента
     */
    @PostMapping("/profil")
    public String editUserClient(@RequestParam Map<String, String> form,
                                 @RequestParam("clientUserID") Long id ){
        Client client = clientRepo.findByid(id);
        client.setName(form.get("nameClient"));
        client.setSurname(form.get("surnameClient"));
        if (form.get("ageClient") == ""){
            client.setAge(null);
        }
        else {
            try{
                client.setAge(Integer.parseInt(form.get("ageClient")));
            }
            catch (NumberFormatException exception){

            }
        }
        client.setAdress(form.get("adressClient"));
        client.setEmail(form.get("emailClient"));
        client.setTelephone_number(form.get("telephone_numberClient"));
        client.setOrganization_name(form.get("organization_nameClient"));
        client.setRequisites(form.get("requisitesClient"));
        clientRepo.save(client);
        return "redirect:/clientUser/profil";
    }

    /**
     * Данный метод загружает и показывает клиенту форму добавления нового заказа
     * @param model модель
     * @return форма добавления заказа
     */
    @GetMapping("/createContract")
    public String showToAddClientContract(Model model){
        List<Production> productions = productionRepo.findAll();
        model.addAttribute("production", productions);
        return "addContract";
    }

    /**
     * Метод выполняющий добавление введенных пользователем данных из формы добавления заказов в БД для создания нового заказа
     * @param value количество
     * @param date дата
     * @param product_selected_id айди выбранных продуктов
     * @return переход на форму всех заказов клиента
     */
    @PostMapping("/createContract")
    public String addContract(@RequestParam Integer value,
                              @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date,
                              @RequestParam Long product_selected_id
                              ){
        Contract contract = new Contract();
        contract.setValue(value);
        contract.setDate_of_agreement(date);
        Production production = productionRepo.findByid(product_selected_id);
        contract.setProduction(production);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("name = " + auth.getName());

        System.out.println("data = " + date);
        Client client = clientRepo.findByUser(userRepo.findByUsername(auth.getName()));
        contract.setClient(client);
        contract.setClient_requisites(client.getRequisites());
        contractRepo.save(contract);
        return "redirect:/clientUser/contracts";
    }

    /**
     * Данный метод необходим для показа всех заказов клиента
     * @param model Модель
     * @return форма заказов клиента
     */
    @GetMapping("/contracts")
    public String pageContracts(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        //System.out.println(auth.getName());
        Client client = clientRepo.findByUser(userRepo.findByUsername(auth.getName()));
        //System.out.println("client " + client);
        List<Contract> contracts = contractRepo.findByClientId(client.getId());
        //System.out.println("contract " + contracts);
        int size = (int) contracts.spliterator().getExactSizeIfKnown();
        //System.out.println("size " + size);
        int size1 = contracts.size();
        //System.out.println("size1 " + size1);
        if (size != 0){
            model.addAttribute("contracts", contracts);
        }
        model.addAttribute("size", size1);
        return "clientContracts";
    }

    /**
     * Данный метод помогает для показа меню для клиентов (его возможности: доступные ссылки, на которые он может нажать и перейти туда, куда ему надо)
     * @return форма меню клиента
     */
    @GetMapping // чтобы пользователь если введет /clientUser, не выскочила ошибка о том, что нет такого GetMapping Url
    public String mainPage(){
        return "/greeting1";
    }

    /**
     * Данный метод отвечает за загрузку и показа формы редактирования конкретного заказа для клиента
     * @param id айди
     * @param model модель
     * @return форма редактирования заказов
     */
    @GetMapping("/contracts/{id}")
    public String clientEditContractForm(@PathVariable Long id, Model model){
        Contract contract = contractRepo.findByid(id);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Client client1 = clientRepo.findByUser(userRepo.findByUsername(auth.getName()));
        List<Contract> contracts = contractRepo.findByClientId(client1.getId());
        if (contracts.contains(contract)){

            if (!(contract.getStatus().equals("Не обработан"))){// если статус не является "Не обработан", то возвращаем форму всех заказов
                System.out.println("Заказ не подлежит редактированию");
                return "redirect:/clientUser/contracts";
            }

            System.out.println("Прошел заказ: " + contract);
            model.addAttribute("contract", contract);
        }
        return "clientContractEdit";
    }

    /**
     * Данный метод помогает заменить данные заказа, на новые данные, введенные клиентом в полях редактирования заказа
     * @param value количество
     * @param contractID айди заказа/договора
     * @return переход на форму заказов клиента
     */
    @PostMapping("/contracts")
    public String clientContractEdit(@RequestParam Integer value,
                                     @RequestParam Long contractID){
        Contract contract = contractRepo.findByid(contractID);
        contract.setValue(value);
        contractRepo.save(contract);
        return "redirect:/clientUser/contracts";
    }
}
