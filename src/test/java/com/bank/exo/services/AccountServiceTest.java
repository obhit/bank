package com.bank.exo.services;

import com.bank.exo.model.Account;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


class AccountServiceTest {

    @Test
    void shouldIncrementAccountOf50eurosWhenDeposit50Euros(){
        // GIVEN
        Account account = new Account(100);
        int depositAmount = 50;
        // WHEN
        var finalAmount = new AccountService().toDeposit(account, depositAmount);
        // THEN
        assertThat(finalAmount).isEqualTo(150);
    }

    @Test
    void shouldDecrementAccountOf50eurosWhenWithdrawal50Euros(){
        // GIVEN
        Account account = new Account(100);
        int withdrawalAmount = 50;
        // WHEN
        var finalAmount = new AccountService().toWithdrawalAmount(account, withdrawalAmount);
        // THEN
        assertThat(finalAmount).isEqualTo(50);
    }

}
