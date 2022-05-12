package com.bank.exo.services;

import com.bank.exo.model.Account;
import com.bank.exo.model.Operation;
import com.bank.exo.model.Transaction;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AccountServiceTest {
    @Test
    void shouldCreateAccountWithInitialAmount(){
        // GIVEN
        int initialAmount = 10;
        // WHEN
        var account = new AccountService().createAccount(initialAmount);
        // THEN
        assertThat(account.getAmount()).isEqualTo(10);
        assertThat(account.transactions).hasSize(1);
        assertThat(account.transactions).extracting(Transaction::getAmount, Transaction::getBalance, Transaction::getOperation)
                .containsExactly(Tuple.tuple(10, 0, Operation.DEPOSIT));
    }

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

    @Test
    void shouldShowHistoryWhenCustomerWantToCheckHisOperations(){
        // GIVEN
        Account account = new Account(100);
        // WHEN
        account.toDeposit(300);
        account.toDeposit(50);
        account.toWithdrawalAmount(50);
        account.toDeposit(100);
        // THEN
        assertThat(account.transactions).extracting(Transaction::getAmount, Transaction::getBalance, Transaction::getOperation)
                .containsExactly(
                        Tuple.tuple(100, 0, Operation.DEPOSIT),
                        Tuple.tuple(300, 400, Operation.DEPOSIT),
                        Tuple.tuple(50, 450, Operation.DEPOSIT),
                        Tuple.tuple(50, 400, Operation.WITHDRAWAL),
                        Tuple.tuple(100, 500, Operation.DEPOSIT));
    }
}
