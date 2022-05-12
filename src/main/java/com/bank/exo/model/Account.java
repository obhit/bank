package com.bank.exo.model;

import java.util.ArrayList;
import java.util.List;

import static com.bank.exo.model.Balance.DEPOSIT;
import static com.bank.exo.model.Balance.WITHDRAWAL;

public class Account {
    private int amount;
    public List<Transaction> transactions = new ArrayList<>();

    public Account(int amount) {
        this.amount = amount;
        var transaction = new Transaction(DEPOSIT, amount);
        this.transactions.add(transaction);
    }

    public int toDeposit(int depositAmount){
        amount+=depositAmount;
        transactions.add(new Transaction(DEPOSIT, depositAmount));
        return amount;
    }

    public int toWithdrawalAmount(int withdrawalAmount) {
        amount-=withdrawalAmount;
        transactions.add(new Transaction(WITHDRAWAL, withdrawalAmount));
        return amount;
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
