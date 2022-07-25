package com.example.parkingTask2.controllers;
import com.example.parkingTask2.dto.ClientDTO;
import com.example.parkingTask2.entities.Client;
import org.jose4j.lang.JoseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.parkingTask2.repositories.ClientRepository;
import com.example.parkingTask2.services.ClientService;

import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/v1/client")
public class ClientAppController {
    private final ClientService clientService;

    private ClientRepository repository ;

    @Autowired
    public ClientAppController(ClientService clientService, ClientRepository repository) {
        this.clientService = clientService;
        this.repository = repository;
    }

    @GetMapping("/count")
    public void getNumber(){
        System.out.print(repository.count());
    }


    @PostMapping("/addClient")
    public void registerNewClient(@RequestBody ClientDTO client) throws JoseException, NoSuchAlgorithmException {
        clientService.clientSave(client);
    }


    @PostMapping("/getPayment/{id}")
    public void getPayment (@PathVariable int id){
        System.out.print("The amount to pay is"+clientService.getPayment(id));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById (@PathVariable int id){
        clientService.deleteClient(id);
    }

//    @GetMapping("/getAll")
//    public void getAll(){
//        clientService.getParking();
//    }

}
