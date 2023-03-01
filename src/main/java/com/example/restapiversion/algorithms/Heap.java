package com.example.restapiversion.algorithms;

import com.example.restapiversion.exceptions.StreamFailException;
import com.example.restapiversion.models.Client;
import com.example.restapiversion.models.ClientFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.PriorityQueue;
@Component("heap")
public class Heap {

    private Comparator<Client> cmp = Comparator.comparing(Client::isAdiClient).thenComparing(Client::compareTo);
    //it uses the current logic to create a MIN heap, for readability its reversed on use.
    private PriorityQueue<Client> maxHeap = new PriorityQueue<Client>(cmp.reversed());

    public PriorityQueue<Client> getMaxHeap() {
        return maxHeap;
    }

    public PriorityQueue <Client> orderStreamedList(ClientFactory stream, int end) throws StreamFailException {
        for(int i = 0; i < end; i++){
            maxHeap.add(stream.createClient(i, 10));
        }
        return maxHeap;
    }
}
