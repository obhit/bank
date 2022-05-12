package com.bank.exo.model;

import java.time.LocalDateTime;

public class Transaction {
    Balance balance;
    int amount;
    LocalDateTime date;

    public Transaction(Balance balance, int amount) {
        this.amount = amount;
        this.date = LocalDateTime.now();
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "balance=" + balance +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
