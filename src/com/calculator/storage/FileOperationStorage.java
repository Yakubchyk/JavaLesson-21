package com.calculator.storage;

import com.calculator.model.Operation;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

public class FileOperationStorage implements OperationStorage {
    public void save(Operation operation) {
        try {
            FileWriter writer = new FileWriter("history.txt", true);
            writer.write(String.format("%s/%s/%s/%s\n", operation.getNum1(),
                    operation.getNum2(),
                    operation.getResult(),
                    operation.getType()));
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Operation> findAll() {
        try {
            FileReader fileReader = new FileReader("history.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            Stream<String> lines = bufferedReader.lines();
            List<Operation> list = lines
                    .map(s -> s.split("/"))
                    .map(a -> new Operation(
                            Double.parseDouble(a[0]),
                            Double.parseDouble(a[1]),
                            a[3],
                            Double.parseDouble(a[2]))).toList();
            return list;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
