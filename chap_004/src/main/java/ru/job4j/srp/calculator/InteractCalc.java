package ru.job4j.srp.calculator;

import ru.job4j.srp.calculator.input.Input;
import ru.job4j.srp.calculator.input.InputConsole;
import ru.job4j.srp.calculator.operations.Operations;
import ru.job4j.srp.calculator.operations.OperationsFactory;
import ru.job4j.srp.calculator.output.Output;
import ru.job4j.srp.calculator.output.OutputConsole;


/**
 * @author Aleksandr Smirnov.
 */
public class InteractCalc {
    /**
     * Результат вычисления.
     */
    private double result;
    /**
     *
     */
    private final Output output;
    private final Input input;
    private final OperationsFactory operationsFactory;
    private Operations operation;

    /**
     * Конструктор по умолчанию.
     */
    public InteractCalc() {
        this.result = result;
        this.output = new OutputConsole();
        this.input = new InputConsole();
        this.operationsFactory = new OperationsFactory();
        this.operation = null;
    }

    /**
     * Метод запускает программу.
     */
    public void start() {
        output.helpInfo(operationsFactory.getOperationsArray());
        InteractCalc interactCalc = new InteractCalc();
        interactCalc.humanSystemInterface();
    }

    /**
     * Метод взаимодействует спользователем.
     */
    public void humanSystemInterface() {
        double firstArgument = input.writeArgument();
        Operations operation = input.writeOperation();
        do {
            // условие для операций с двумя атрибутами.
            if (operation.getQuantityArgument() == false) {
                result = operation.execute(firstArgument);
                operation = input.writeOperation();
            } else {  // иначе операция требует однин атрибут.
                double secondArgument = input.writeArgument();
                result = operation.execute(firstArgument, secondArgument);
                operation = input.writeOperation();
            }
            if (operation.getKey().equals("=")) {
                output.writeResult(result);
                if (input.writeCloseOrContinue()) {
                    firstArgument = input.writeArgument();
                    operation = input.writeOperation();
                } else {
                    break;
                }
            } else if (!operation.getKey().equals("exit")) {
                output.writeResult(result);
                firstArgument = result;
            } else {
                output.writeResult(result);
            }
        }
        while (!operation.getKey().equals("exit"));
    }
    public double getResult() {
        return result;
    }
}
