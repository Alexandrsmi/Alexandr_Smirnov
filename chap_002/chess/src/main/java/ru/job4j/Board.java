package ru.job4j;

import ru.job4j.model.Figure;

/**
 * Class
 *
 * @author Aleksandr Smirnov.
 * @vesion 1.0.
 * @since 05.02.2017.
 */
public class Board {
    private static final int boardSize = 8;
    private Figure[][] board = new Figure[boardSize][boardSize];

    public void addFigure(Figure figure){
        this.board[figure.getRealPosition().getY()][figure.getRealPosition().getX()] = figure;
    }

    public void deleteFigure(Figure figure){

    }

    public void moveFigure(Figure figure, Position position){

    }

    public Figure[][] getBoard() {
        return board;
    }
}