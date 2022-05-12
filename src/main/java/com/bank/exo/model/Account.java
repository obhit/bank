package com.bank.exo.model;

import java.util.ArrayList;
import java.util.List;

import static com.bank.exo.model.Operation.DEPOSIT;
import static com.bank.exo.model.Operation.WITHDRAWAL;

public class Account {
    private int amount;
    public List<Transaction> transactions = new ArrayList<>();

    public Account(int amount) {
        this.amount = amount;
        var transaction = new Transaction(DEPOSIT, amount);
        this.transactions.add(transaction);
    }

    public int toDeposit(int depositAmount){
        plus(depositAmount);
        transactions.add(new Transaction(DEPOSIT, depositAmount, amount));
        return amount;
    }

    public int toWithdrawalAmount(int withdrawalAmount) {
        minus(withdrawalAmount);
        transactions.add(new Transaction(WITHDRAWAL, withdrawalAmount, amount));
        return amount;
    }

    private void minus(int amount){
        this.amount-=amount;
    }

    private void plus(int amount){
        this.amount+=amount;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "amount=" + amount +
                ", transactions=" + transactions +
                '}';
    }
}
