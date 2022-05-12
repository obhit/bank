package com.bank.exo;

import com.bank.exo.services.AccountService;

public class ApplicationMain {
    public static void main(String[] args) {
        AccountService accountService = new AccountService();

        var account = accountService.createAccount(10);
        accountService.toDeposit(account, 100);
        accountService.toDeposit(account, 300);
        accountService.toWithdrawalAmount(account, 100);
        accountService.toDeposit(account, 10);


        System.out.println(accountService.toPrintStatement(account));
    }
}
