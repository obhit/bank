package com.bank.exo.services;

import com.bank.exo.model.Account;

public class AccountService {
    public Account createAccount(int initialAmount){
        return new Account(initialAmount);
    }

    public int toDeposit(Account account, int depositAmount){
        return account.toDeposit(depositAmount);
    }

    public int toWithdraw(Account account, int withdrawalAmount) {
        return account.toWithdraw(withdrawalAmount);
    }

    public String toPrintStatement(Account account) {
        return account.getHistory();
    }
}
