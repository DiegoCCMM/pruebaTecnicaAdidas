package com.example.restapiversion.models;

import com.example.restapiversion.exceptions.StreamFailException;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.LinkedList;
import java.util.SplittableRandom;
@Component("clientFactory")
public class ClientFactory {

    public SplittableRandom splittableRandom = new SplittableRandom();

    public LinkedList<Client>createClients(int numberOfClients) throws StreamFailException {
        LinkedList<Client> listOfClients = new LinkedList<>();
        for(int i = 0; i < numberOfClients; i++) {
            listOfClients.push(createClient(i, 0));
        }
        return listOfClients;
    }

    public Client createClient(int id, int chance_of_failure) throws StreamFailException {

        generateException(chance_of_failure);

        if(splittableRandom.nextInt(1, 7) < 4){
            return new Client(id + "@onemail.com");
        }else{
            return new AdiClubClient(id + "@adiclub.com",
                            splittableRandom.nextInt(1, 700),
                            new Date(splittableRandom.nextInt(0, 1200000)));
        }
    }

    private void generateException(int chance_of_failure) throws StreamFailException {
        if(chance_of_failure!=0 && splittableRandom.nextInt(1, chance_of_failure)==1){
            throw new StreamFailException("The stream broke, try again later");
        }
    }
}
