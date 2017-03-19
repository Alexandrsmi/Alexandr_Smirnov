package ru.job4j.srp.calculator.output;

import ru.job4j.srp.calculator.operations.Operations;

/**
 * @author Aleksandr Smirnov.
 */
public class OutputConsole implements Output {

    private String message;

    @Override
    public void writeResult(double result) {
        message = "Result = " + result;
        System.out.println(message);
    }

    @Override
    public void helpInfo(Operations[] operations) {
        System.out.println("Программа поддерживает следующие команды:");
        for (Operations operation : operations) {
            System.out.println(operation.getInfo());
        }
    }

    public String getMessage() {
        return message;
    }

}
