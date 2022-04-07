package com.bank.account.kata.utils;

import java.util.Objects;

public class Fields {

    public static <T> void notNull(T arg, String errorMessage) {
        if (Objects.isNull(arg)) {
            throw new NullPointerException(errorMessage);
        }
    }
}
