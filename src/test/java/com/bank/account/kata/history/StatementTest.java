package com.bank.account.kata.history;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StatementTest {


    @Test
    void when_operation_is_null_then_should_throw_exception() {
        Assertions.assertThrows(NullPointerException.class,
                () -> new Statement(null, 0));
    }

}