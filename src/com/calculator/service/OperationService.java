package com.calculator.service;

import com.calculator.model.Operation;
import com.calculator.storage.FileOperationStorage;
import com.calculator.storage.OperationStorage;

import java.util.List;

public class OperationService {

    private final OperationStorage operationStorage = new FileOperationStorage();


    public Operation execute(Operation operation) {
        switch (operation.getType()) {
            case "SUM":
                operation.setResult(operation.getNum1() + operation.getNum2());
                operationStorage.save(operation);
                return operation;
            case "SUB":
                operation.setResult(operation.getNum1() - operation.getNum2());
                operationStorage.save(operation);
                return operation;
            case "MUL":
                operation.setResult(operation.getNum1() * operation.getNum2());
                operationStorage.save(operation);
                return operation;
            case "DIV":
                operation.setResult(operation.getNum1() / operation.getNum2());
                operationStorage.save(operation);
                return operation;
        }
        throw new IllegalArgumentException("com.calculator.model.Operation type not supported");

    }
    public List<Operation> getOperations() {
        return operationStorage.findAll();
    }
}
