package com.luxoft.basics.part2.bank;

public class Account {
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private double balance;

    public double getBalance() {
        return balance;
    }

    public int getId() {
        return id;
    }

    public void deposit(double amount)
    {
        balance+=amount;
    }
    public void withdraw(double amount)
    {
        balance-=amount;
    }


}
