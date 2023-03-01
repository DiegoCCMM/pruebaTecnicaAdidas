package com.example.restapiversion.models;

public class Client implements Comparable<Client> {
    private String email;

    public Client(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int compareTo(Client that) {
        return -1;
    }

    public boolean isGreaterThan(Client that) {
        return !(that instanceof AdiClubClient);
    }

    public boolean isAdiClient(){return false;}

    public boolean isEmailCorrect() {
        return email.matches("[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}");
    }

    @Override
    public String toString() {
        return "client{" +
                "email='" + email + '\'' +
                '}';
    }
}
