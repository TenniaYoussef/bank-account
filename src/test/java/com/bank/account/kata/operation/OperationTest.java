package com.bank.account.kata.operation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

class OperationTest {

    @Test
    void should_throw_exception_when_date_is_null() {
        Assertions.assertThrows(NullPointerException.class,
                () -> new Operation(OperationType.DEPOSIT, null, 10));
    }

    @Test
    void should_throw_exception_when_operation_type_is_null() {
        Assertions.assertThrows(NullPointerException.class,
                () -> new Operation(null, new Date(), 10));
    }

}