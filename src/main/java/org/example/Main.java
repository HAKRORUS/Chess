package org.example;

import org.example.piece.Piece;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
//        Board board = new Board();
//        board.setupDefaultPiecesPositions();

        Board board = (new BoardFactory()).fromFEN(
                "5p2/8/8/8/1rbB4/2P5/8/8 w - - 0 1"
        );

        BoardConsoleRenderer renderer = new BoardConsoleRenderer();

        //testgit config --global http.sslVerify false

        Game game = new Game(board);
        game.gameLoop();
    }
}