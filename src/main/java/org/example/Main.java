package org.example;

import org.example.piece.Piece;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
//        Board board = new Board();
//        board.setupDefaultPiecesPositions();

        Board board = (new BoardFactory()).fromFEN(
                "8/4q3/8/4K3/8/4k3/8/4Q3 w - - 0 1"
        );

        BoardConsoleRenderer renderer = new BoardConsoleRenderer();

        //testgit config --global http.sslVerify false

        Game game = new Game(board);
        game.gameLoop();
    }
}