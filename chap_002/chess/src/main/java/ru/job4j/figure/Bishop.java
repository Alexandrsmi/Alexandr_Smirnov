package ru.job4j.figure;

import ru.job4j.ColorFigure;
import ru.job4j.FigureType;
import ru.job4j.Position;

/**
 * Класс фигуры Bishop.
 * @author Aleksandr Smirnov.
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
