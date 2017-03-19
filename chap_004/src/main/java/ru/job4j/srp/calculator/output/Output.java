package ru.job4j.srp.calculator.output;

import ru.job4j.srp.calculator.operations.Operations;

/**
 * @author Aleksandr Smirnov.
 */
public interface Output {
    void writeResult(double result);
    void helpInfo(Operations[] operations);
    String getMessage();
}
