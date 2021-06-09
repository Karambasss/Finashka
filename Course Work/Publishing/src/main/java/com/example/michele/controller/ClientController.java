package com.example.michele.controller;

import com.example.michele.domain.Client;
import com.example.michele.repos.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
/**
 * <p>Данный класс необходим для работы с клиентами</p>
 * В нем находится только один метод - просмотр всех клиентов
 * @author Кузнецов Михаил
 * */
@Controller
@PreAuthorize("hasAnyAuthority('ADMIN','CLIENT_MANAGER', 'USER')")
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientRepo clientRepo;

    /**
     * Данный метод необходим для показа всех клиентов
     * @param model модель
     * @return форму клиентов
     */
    @GetMapping
    public String main(Model model){
        Iterable<Client> clients;
        clients = clientRepo.findAll(Sort.by(Sort.Direction.ASC,"name")); // по умолчанию по имени
        int size = (int) clients.spliterator().getExactSizeIfKnown();
        if (size != 0){
            model.addAttribute("clients", clients);
        }
        model.addAttribute("size",size);
        return "client";
    }
//    @GetMapping("{id}")
//    public String ClientEditForm(@PathVariable Long id, Model model){
//        Client client = clientRepo.findByid(id);
//        if (client != null){
//            model.addAttribute("client", client);
//        }
//        return "clientEdit";
//    }
//    @PostMapping
//    public String ClientEdit(@RequestParam Map<String, String> form,
//                             @RequestParam ("clientID") Client client){
//        client.setName(form.get("name"));
//        client.setSurname(form.get("surname"));
//        if (form.get("age") == ""){
//            client.setAge(null);
//        }
//        else {
//            try {
//                client.setAge(Integer.parseInt(form.get("age")));
//            }
//            catch (NumberFormatException exception){
//
//            }
//        }
//        client.setAdress(form.get("adress"));
//        client.setEmail(form.get("email"));
//        client.setTelephone_number(form.get("telephone_number"));
//        client.setOrganization_name(form.get("organization_name"));
//        client.setRequisites(form.get("requisites"));
//        clientRepo.save(client);
//        return "redirect:/client";
//    }
}

