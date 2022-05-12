package com.bank.exo.services;

import com.bank.exo.model.Account;

public class AccountService {
    public int toDeposit(Account account, int depositAmount){
        return account.toDeposit(depositAmount);
    }

    public int toWithdrawalAmount(Account account, int withdrawalAmount) {
        return account.toWithdrawalAmount(withdrawalAmount);
    }
}
