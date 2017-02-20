package ru.job4j.figure;

import ru.job4j.ColorFigure;
import ru.job4j.FigureType;
import ru.job4j.Position;

/**
 * @author Aleksandr Smirnov.
 * @version 1
 * @since 19.02.2017.
 */
public abstract class Figure {
    /**
     * Кординаты.
     */
    private Position position;
    /**
     * Цвет фигуры.
     */
    private final ColorFigure colorFigure;
    /**
     * Тип фигуры.
     */
    private final FigureType figureType;

    /**
     * Конструктор класса.
     * @param position - позиция фигуры.
     * @param colorFigure - цвет фигуры.
     * @param figureType - тип фигуры.
     */
    public Figure(Position position, ColorFigure colorFigure, FigureType figureType) {
        this.position = position;
        this.colorFigure = colorFigure;
        this.figureType = figureType;
    }


    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public ColorFigure getColorFigure() {
        return colorFigure;
    }

    public FigureType getFigureType() {
        return figureType;
    }

    public abstract boolean move(Position position);


}
