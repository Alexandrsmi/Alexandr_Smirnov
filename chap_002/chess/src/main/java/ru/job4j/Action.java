package ru.job4j;

import ru.job4j.model.Figure;

/**
 * Class
 *
 * @author Aleksandr Smirnov.
 * @vesion 1.0.
 * @since 07.02.2017.
 */
public class Action {

    Action action = new Action();

    /**
     * проверяем свободна ли ячейка
     */

    public boolean freeFinishCell(Figure figure, Position position){
        if(position.equals(null)){
            return true;
        }else if(figure.getColorFigure(figure.getRealPosition())!=figure.getColorFigure(position)){
            return true;
        }return false;
    }

    /**
     * Можно ли ходить по диагонали.
     */
}
