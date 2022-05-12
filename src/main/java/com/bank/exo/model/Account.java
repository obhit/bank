package com.bank.exo.model;

import java.util.ArrayList;
import java.util.List;

import static com.bank.exo.model.Balance.DEPOSIT;

public class Account {
    private int amount;
    public List<Transaction> transactions = new ArrayList<>();

    public Account(int amount) {
        this.amount = amount;
        var transaction = new Transaction(DEPOSIT, amount);
        this.transactions.add(transaction);
    }

    public int toDeposit(int amount){
        this.amount+=amount;
        transactions.add(new Transaction(DEPOSIT, amount));
        return this.amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "amount=" + amount +
                ", transactions=" + transactions +
                '}';
    }
}