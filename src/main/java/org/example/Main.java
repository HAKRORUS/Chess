package org.example;

import org.example.piece.Piece;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
//        Board board = new Board();
//        board.setupDefaultPiecesPositions();

        Board board = (new BoardFactory()).fromFEN(
                "8/8/1b3N2/8/3B4/8/8/8 w - - 0 1"
        );

        BoardConsoleRenderer renderer = new BoardConsoleRenderer();
 //       renderer.render(board);
//
//        Piece piece = board.getPiece(new Coordinates(File.G,8));
//        Set<Coordinates> availableMoveSquares = piece.getAvailableMoveSquares(board);
//
//        int a = 123;

        Game game = new Game(board);
        game.gameLoop();
    }
}