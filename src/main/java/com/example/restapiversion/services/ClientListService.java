package com.example.restapiversion.services;

import com.example.restapiversion.exceptions.StreamFailException;
import com.example.restapiversion.mainLogic.ClientMainLogic;
import com.example.restapiversion.models.Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.PriorityQueue;

@RestController
@RequestMapping("/clientList")
public class ClientListService {
    ClientMainLogic clientMainLogic = new ClientMainLogic();

    @GetMapping("/findAll")
    public PriorityQueue<Client> findAll(){
        return clientMainLogic.getAllClients();
    }

    @PostMapping("/deleteOne")
    public Client deleteOne(){return clientMainLogic.deleteClient();}

    @PostMapping("/insertOne")
    public Client insertOne(){
        try {
            return clientMainLogic.addClient();
        } catch (StreamFailException e) {
            e.printStackTrace();
        }
        return null;
    }
}
