package ru.job4j.srp.calculator.operations;

import ru.job4j.srp.calculator.operations.arithmetic.*;

/**
 * @author Aleksandr Smirnov.
 */
public class OperationsFactory {
    /**
     * Массив операциий.
     */
    private Operations[] operations = {
            new AddOperation(),
            new MultiplyOperation(),
            new SinOperation(),
            new DivOperation(),
            new SquareRootOperation(),
            new PowOperation(),
            new SubOperation(),
            new EquallyOperation(),
            new ExitOperation()
    };
    /**
     * Метод получения операции.
     * @param operationName - ключь операции.
     * @return operation - операция.
     */
    public Operations getOperation(String operationName){
        for (Operations operation : operations) {
            if (operationName.equals(operation.getKey())) {
                return operation;
            }
        }
        return null;
    }
    /**
     * Метод возвращает массив операций.
     * @return - массив операций.
     */
    public Operations[] getOperationsArray() {
        return operations;
    }
}
