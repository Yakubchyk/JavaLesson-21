package com.calculator.console;


import com.calculator.model.Operation;
import com.calculator.service.OperationService;
import com.calculator.storage.FileOperationStorage;

public class ConsoleAppllication implements Application {
    private final ConsoleReader consoleReader = new ConsoleReader();
    private final ConsoleWriter consoleWriter = new ConsoleWriter();
    private final OperationService operationService = new OperationService();

    public void run() {
        while (true) {


            consoleWriter.write("Enter num 1: ");
            double num1 = consoleReader.readNumber();
            consoleWriter.write("Enter num 2: ");
            double num2 = consoleReader.readNumber();
            consoleWriter.write("Enter operation type: SUM, SUB, MUL, DIV");
            String type = consoleReader.readOperation();


            Operation operation = new Operation(num1, num2, type);
            Operation execute = operationService.execute(operation);
            consoleWriter.write("Result : " + execute.getResult());
            consoleWriter.write("History : ");

            for (Operation op : operationService.getOperations()) {
                consoleWriter.write(String.format("Operation %s %s %s %s: ",
                        op.getNum1(),
                        op.getNum2(),
                        op.getResult(),
                        op.getType()));
            }
            consoleWriter.write("Clear History File. Enter command [clear]: ");
            consoleWriter.write("Exit : [y/N] ");
            String clearHistoryFile = consoleReader.readCommand();
            if (clearHistoryFile.equals("clear")) {
                FileOperationStorage fileOperationStorage = new FileOperationStorage();
                fileOperationStorage.clear();
                break;
            }

            String key = consoleReader.readCommand();
            if (key.equals("y")) {
                break;
            }
        }
    }
}

