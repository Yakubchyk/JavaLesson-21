package com.calculator.storage;

import com.calculator.model.Operation;

import java.util.List;

public interface OperationStorage {
    void save(Operation operation);
    public List<Operation> findAll();

}
