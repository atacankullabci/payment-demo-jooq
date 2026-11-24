package com.atancankullabci.domain;

public class Account {
    private final String id;
    private Balance balance;

    public Account(String id, Balance balance) {
        if(id == null)
            throw new NullPointerException();
        this.id = id;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public Balance getBalance() {
        return balance;
    }

    public void deposit(Money money) {
        balance = balance.add(money);
    }

    public void withdraw(Money money) {
        balance = balance.subtract(money);
    }
}
