package ru.job4j.figure;

import ru.job4j.figure.Figure;
import ru.job4j.model.ColorFigure;
import ru.job4j.model.FigureType;
import ru.job4j.model.Position;

/**
 * Класс фигуры Bishop.
 *
 * @author Aleksandr Smirnov.
 * @version 1
 * @since 19.02.2017.
 */
public class Bishop extends Figure {
    /**
     * Возможность хода.
     */
    private boolean moveTo;

    /**
     * Конструктор класса.
     */
    public Bishop(Position position, ColorFigure colorFigure, FigureType figureType) {
        super(position, colorFigure, FigureType.BISHOP);
    }

    /**
     * Метод проверяет правильность хода для данной фигуры.
     *
     * @param position
     * @return
     */
    @Override
    public boolean move(Position position) {
        if (position.getY() == getPosition().getY() || position.getX() == getPosition().getX()) {
            return moveTo = true;
        }
        return moveTo = false;
    }
}
