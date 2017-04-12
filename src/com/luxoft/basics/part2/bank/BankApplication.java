package com.luxoft.basics.part2.bank;

public class BankApplication {
    public static void main(String[] args) {
        Bank bank = new Bank();

        Client client2 = new Client();
        client2.setName("Denis");

        Client client1 = new Client();
        client1.setName("Anna");


        Account account = new Account();
        account.setId(1);
        account.setBalance(2000);


        client1.addAccount(account);

        client2.addAccount(account);

        bank.addClient(client1);
        bank.addClient(client2);

        bank.printAllClients();

        client1.printAllAccounts();

    }
}
