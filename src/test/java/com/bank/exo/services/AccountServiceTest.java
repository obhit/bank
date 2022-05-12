package com.bank.exo.services;

import com.bank.exo.model.Account;
import com.bank.exo.model.Operation;
import com.bank.exo.model.Transaction;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.Assertions;
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
        assertThat(account.getBalance()).isEqualTo(10);
        assertThat(account.getTransactions()).hasSize(1);
        assertThat(account.getTransactions()).extracting(Transaction::getAmount, Transaction::getBalance, Transaction::getOperation)
                .containsExactly(Tuple.tuple(10, 10, Operation.CREATION));
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
        var finalAmount = new AccountService().toWithdraw(account, withdrawalAmount);
        // THEN
        assertThat(finalAmount).isEqualTo(50);
    }

    @Test
    void shouldShowHistoryWhenCustomerWantToCheckHisOperations(){
        // GIVEN
        AccountService accountService = new AccountService();
        Account account = accountService.createAccount(100);
        // WHEN
        accountService.toDeposit(account, 300);
        accountService.toDeposit(account, 50);
        accountService.toWithdraw(account, 50);
        accountService.toDeposit(account, 100);
        // THEN
        assertThat(account.getTransactions()).extracting(Transaction::getAmount, Transaction::getBalance, Transaction::getOperation)
                .containsExactly(
                        Tuple.tuple(100, 100, Operation.CREATION),
                        Tuple.tuple(300, 400, Operation.DEPOSIT),
                        Tuple.tuple(50, 450, Operation.DEPOSIT),
                        Tuple.tuple(50, 400, Operation.WITHDRAWAL),
                        Tuple.tuple(100, 500, Operation.DEPOSIT));
    }

    @Test
    void shouldThrowIllegalExceptionWhenInsufficientBalance(){
        // GIVEN
        AccountService accountService = new AccountService();
        var account = accountService.createAccount(10);

        // WHEN
        IllegalStateException thrown = Assertions.assertThrows(IllegalStateException.class, () -> account.toWithdraw(11));

        // THEN
        Assertions.assertEquals(String.format("Can't withdraw [%d] : Insufficient balance [%d] ",11, 10), thrown.getMessage());
    }
}
