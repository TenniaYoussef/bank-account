package com.bank.account.kata.account;

import com.bank.account.kata.exception.AmountException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;

class BankAccountTest {

    BankAccount bankAccount;

    @BeforeEach
    void init() {
        bankAccount = new BankAccount(1000);
    }

    @Test
    void deposit_with_negative_amount_throw_amount_exception() {
        Assertions.assertThrows(AmountException.class, () -> {
            bankAccount.deposit(-50);
        });
    }

    @Test
    void deposit_with_amount_zero_throw_amount_exception() {
        Assertions.assertThrows(AmountException.class, () -> {
            bankAccount.deposit(0);
        });
    }

    @Test
    void deposit_with_positive_amount() {
        double depositAmount = 1000;
        double initialBalance = bankAccount.getBalance();
        bankAccount.deposit(depositAmount);
        assertThat(bankAccount.getBalance()-depositAmount).isEqualTo(initialBalance);
    }

    @Test
    void withdraw_with_negative_amount_throw_amount_exception() {
        Assertions.assertThrows(AmountException.class, () -> {
            bankAccount.withdraw(-50);
        });
    }

    @Test
    void withdraw_with_amount_zero_throw_amount_exception() {
        Assertions.assertThrows(AmountException.class, () -> {
            bankAccount.withdraw(0);
        });
    }

    @Test
    void withdraw_with_amount_bigger_than_balance_return_log_inf() {
        bankAccount.withdraw(1500);
        assertThat(Logger.getLogger(bankAccount.getClass().getName())).isNotNull();
    }

    @Test
    void withdraw_with_amount_less_or_equal_to_balance() {
        double withdrawAmount = 1000;
        double initialBalance = bankAccount.getBalance();
        bankAccount.withdraw(withdrawAmount);
        assertThat(bankAccount.getBalance()+withdrawAmount).isEqualTo(initialBalance);
    }

    @Test
    void history_contains_deposit_record() {
        bankAccount.deposit(1000);
        assertThat(bankAccount.getHistory().getHistory().size()).isEqualTo(1);
    }

    @Test
    void history_contains_withdraw_record() {
        bankAccount.withdraw(1000);
        assertThat(bankAccount.getHistory().getHistory().size()).isEqualTo(1);
    }

    @Test
    void givenSystemOutRedirection_whenInvokePrintln_thenOutputCaptorSuccess() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        bankAccount.deposit(1000);

        bankAccount.printHistory();

        assertThat(bankAccount.getHistory().getHistory().get(0).toString())
                .isEqualTo(outputStreamCaptor.toString()
                .trim());

    }
}