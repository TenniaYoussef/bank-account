package com.bank.account.kata.operation;

import com.bank.account.kata.utils.Fields;

import java.util.Date;

public class Operation {

    private final OperationType operationType;
    private final Date operationDate;
    private final double amount;

    public Operation(OperationType operationType, Date operationDate, double amount) {
        Fields.notNull(operationType, "OperationType should not be null.");
        Fields.notNull(operationDate, "OperationDate should not be null.");
        this.operationType = operationType;
        this.operationDate = new Date(operationDate.getTime());
        this.amount = amount;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public double getAmount() {
        return amount;
    }

    public Date getOperationDate() {
        return operationDate;
    }



    @Override
    public String toString() {
        return "Operation{" +
                "operationType=" + operationType +
                ", amount=" + amount +
                ", operationDate=" + operationDate +
                '}';
    }

}
