package com.bank.exo.model;

import java.time.LocalDateTime;

public class Transaction {
    private Operation operation;
    private int amount;
    private int balance;
    private LocalDateTime date;

    public Transaction(Operation operation, int amount) {
        this.amount = amount;
        this.date = LocalDateTime.now();
        this.operation = operation;
    }

    public Transaction(Operation operation, int amount, int balance) {
        this.amount = amount;
        this.date = now();
        this.operation = operation;
        this.balance = balance;
    }

    private LocalDateTime now(){
       return LocalDateTime.now();
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
        return "\nTransaction{\n" +
                "operation=" + operation +
                ",\n amount=" + amount +
                ",\n balance=" + balance +
                ",\n date=" + date +
                "\n}";
    }
}
