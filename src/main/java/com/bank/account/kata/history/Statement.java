package com.bank.account.kata.history;

import com.bank.account.kata.operation.Operation;
import com.bank.account.kata.utils.Fields;

public class Statement {


    private Operation operation;
    private double balance;

    public Statement(Operation operation, double balance) {
        Fields.notNull(operation, "Operation should not be null");
        this.operation = operation;
        this.balance = balance;
    }

    public Operation getOperation() {
        return operation;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Statement{" +
                "operation=" + operation.toString() +
                ", balance=" + balance +
                '}';
    }


}
