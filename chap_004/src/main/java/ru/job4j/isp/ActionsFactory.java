package ru.job4j.isp;

import ru.job4j.srp.calculator.operations.EquallyOperation;
import ru.job4j.srp.calculator.operations.ExitOperation;
import ru.job4j.srp.calculator.operations.Operations;
import ru.job4j.srp.calculator.operations.arithmetic.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Aleksandr Smirnov.
 */
public class ActionsFactory {
    /**
     * Массив операциий.
     */
    private List<Action> actions = new ArrayList<>();

    {
    }

    /**
     * Метод получения операции.
     *
     * @param key - ключь операции.
     * @return operation - операция.
     */
    public Action getOperation(String key) {
        for (Action action: actions) {
            if (key.equals(action.getKey())) {
                return action;
            }
        }
        return actions.get(0);
    }

    /**
     * Метод возвращает массив операций.
     *
     * @return - массив операций.
     */
    public Collection<Action> getOperationsArray() {
        return actions;
    }
}
