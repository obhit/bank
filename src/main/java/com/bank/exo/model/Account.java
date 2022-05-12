package com.bank.exo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.bank.exo.model.Operation.*;

public class Account {
    private final String uuid= UUID.randomUUID().toString();
    private int balance;
    private final List<Transaction> transactions = new ArrayList<>();

    public Account(int amount) {
        this.balance = amount;
        var transaction = new Transaction(CREATION, amount);
        this.transactions.add(transaction);
    }

    public int toDeposit(int amount){
        plus(amount);
        transactions.add(new Transaction(DEPOSIT, amount, balance));
        return balance;
    }

    public int toWithdraw(int amount) {
        if(balance < amount){
            throw new IllegalStateException(String.format("Can't withdraw [%d] : Insufficient balance [%d] ",amount, balance));
        }

        minus(amount);
        transactions.add(new Transaction(WITHDRAWAL, amount, balance));
        return balance;
    }

    public String getHistory(){
        return String.format("Account %s History %n%n%s",uuid,
                transactions.stream()
                .map(Transaction::toString)
                .collect(Collectors.joining("\n")));
    }

    private void minus(int amount){
        this.balance -=amount;
    }

    private void plus(int amount){
        this.balance +=amount;
    }

    public int getBalance() {
        return balance;
    }

    public String getUuid(){
        return uuid;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    @Override
    public String toString() {
        return "Account{" +
                "amount=" + balance +
                ", transactions=" + transactions +
                '}';
    }
}
