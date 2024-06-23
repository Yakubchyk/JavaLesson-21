package com.calculator.console;


import com.calculator.model.Operation;
import com.calculator.service.OperationService;

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
            consoleWriter.write("Exit : [y/N] \n");


        }
    }
}

