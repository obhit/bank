package com.bank.exo.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private Operation operation;
    private LocalDateTime date;
    private int amount;
    private int balance;

    public Transaction(Operation operation, int amount) {
        this.amount = amount;
        this.balance = amount;
        this.date = LocalDateTime.now();
        this.operation = operation;
    }

    public Transaction(Operation operation, int amount, int balance) {
        this.amount = amount;
        this.date = LocalDateTime.now();
        this.operation = operation;
        this.balance = balance;
    }

    public Operation getOperation() {
        return operation;
    }

    public int getAmount() {
        return amount;
    }

    public int getBalance() {
        return balance;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public String toString() {
        return operation +
                ", " + date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm")) +
                ", amount=" + amount +
                ", balance=" + balance;
    }
}
