package com.luxoft.basics.part2.bank;

public class Bank {

    private Client[] clients = new Client[2];
    int clientsCounter;

    public void addClient(Client client)
    {
        clients[clientsCounter]= client;
        clientsCounter++;
    }
    public void printAllClients()
    {

        for (Client client: clients)
        {
            if (client!=null) {
                System.out.println("Client name: " + client.getName());
            }
        }
    }
}
