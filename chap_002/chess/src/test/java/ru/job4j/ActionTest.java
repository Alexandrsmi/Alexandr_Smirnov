package ru.job4j;

import org.junit.Test;
import ru.job4j.model.Figure;
import ru.job4j.model.WhiteBishop;

/**
 * Class
 *
 * @author Aleksandr Smirnov.
 * @vesion 1.0.
 * @since 08.02.2017.
 */
public class ActionTest {

    @Test
    public void fillFinishCellTest(){
        Action action = new Action();
        Board board = new Board();
        Position position = new Position(7,7);
        WhiteBishop whiteBishop = new WhiteBishop(position,ColorFigure.White);
        board.addFigure(board.getBoard());
    }
}
