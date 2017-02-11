package ru.job4j.model;

import ru.job4j.ColorFigure;
import ru.job4j.Position;

/**
 * Class
 *
 * @author Aleksandr Smirnov.
 * @vesion 1.0.
 * @since 06.02.2017.
 */
public class WhiteBishop extends Figure {

    private ColorFigure colorFigure = ColorFigure.White;

    public WhiteBishop(Position position, ColorFigure colorFigure) {
        super(position, colorFigure);
    }

    @Override
    public boolean moveTo(Position position) {

        return false;
    }

    @Override
    public ColorFigure getColorFigure(Position position) {
        return colorFigure;
    }
}
