package com.luxoft.basics.part2.bank;

public class Client {

    private String name;
    private Account[] accounts = new Account[1];
    private int AccountCounter = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void addAccount(Account account)
    {
        accounts[AccountCounter] =account;
    }
    public void printAllAccounts()
    {
        for (Account account: accounts)
        {
            System.out.println("Account ID: " + account.getId()+" " +"Account Balance: "+ account.getBalance());
        }
    }
}
