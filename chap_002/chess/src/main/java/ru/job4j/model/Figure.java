package ru.job4j.model;

import ru.job4j.ColorFigure;
import ru.job4j.Position;

import java.awt.*;

/**
 * Class
 *
 * @author Aleksandr Smirnov.
 * @vesion 1.0.
 * @since 05.02.2017.
 */

public abstract class Figure {

    private ColorFigure colorFigure;

    private Position position;

    public Figure(Position position, ColorFigure colorFigure) {
        this.colorFigure = colorFigure;
        this.position = position;
    }

    public Position getRealPosition() {
        return position;
    }

    public void setRealPosition(Position position) {
        this.position = position;
    }

    public abstract boolean moveTo(Position position);

    public ColorFigure getColorFigure(Position position) {
        return colorFigure;
    }
}

