package ru.job4j.srp.calculator.input;

import ru.job4j.srp.calculator.operations.Operations;
import ru.job4j.srp.calculator.operations.OperationsFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Aleksandr Smirnov.
 */
public class InputConsole implements Input {
    /**
     * Используем Scanner  для получения данных.
     */
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Метод ввода аргумента.
     *
     * @return - double number.
     */
    @Override
    public double writeArgument() {
        double result = 0.0;
        try {
            System.out.print("Enter number" + " ");
            result = Double.valueOf(scanner.next());
        } catch (InputMismatchException ime) {
            System.out.println("Incomplete input");
            writeArgument();
        }
        return result;
    }
    /**
     * Метод для ввода операции.
     *
     * @return - operation.
     */
    @Override
    public Operations writeOperation() {
        OperationsFactory operationsFactory = new OperationsFactory();
        Operations operation = null;
        while (operation == null) {
            System.out.print("Enter operation ");
            operation = operationsFactory.getOperation(scanner.next());
            if (operation == null) {
                System.out.println("Incomplete input ");
            }
        }
        return operation;
    }

    /**
     * Метод выбора действия.
     *
     * @return true - для продожения, false - закрыть программу.
     */
    @Override
    public boolean writeCloseOrContinue() {
        System.out.println("Желаете продолжить: y/n");
        if (scanner.next().equals("n")) {
            return false;
        }
        return true;
    }
}
