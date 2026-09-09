package org.example;

import org.example.board.Board;
import org.example.board.BoardConsoleRenderer;
import org.example.board.BoardFactory;

public class Main {
    public static void main(String[] args) {
//        Board board = new Board();
//        board.setupDefaultPiecesPositions();

        Board board = (new BoardFactory()).fromFEN(
                "k1r4R/8/8/8/1P1P4/1PKP4/1PPP4/8 w - - 0 1"
        );

        BoardConsoleRenderer renderer = new BoardConsoleRenderer();

        Game game = new Game(board);
        game.gameLoop();
    }
}