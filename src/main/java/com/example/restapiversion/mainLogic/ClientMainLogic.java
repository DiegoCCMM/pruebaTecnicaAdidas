package com.example.restapiversion.mainLogic;

import com.example.restapiversion.algorithms.Heap;
import com.example.restapiversion.exceptions.StreamFailException;
import com.example.restapiversion.models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.PriorityQueue;

@Component
public class ClientMainLogic{

    @Autowired
    Heap hp = new Heap();

    @Autowired
    ClientFactory clientFactory = new ClientFactory();

    public Client deleteClient() {
        return hp.getMaxHeap().poll();
    }

    public PriorityQueue<Client> getAllClients() {
        return hp.getMaxHeap();
    }
    public Client addClient() throws StreamFailException {
        Client c = clientFactory.createClient( 1 + hp.getMaxHeap().size(), 0);
        hp.getMaxHeap().add(c);
        return c;

    }

}
