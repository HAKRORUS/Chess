package org.example;

import org.example.piece.Piece;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
//        Board board = new Board();
//        board.setupDefaultPiecesPositions();

        Board board = (new BoardFactory()).fromFEN(
                "5n2/2p5/3B4/8/k2R1p2/8/8/3K4 w KQkq - 0 1"
        );

        BoardConsoleRenderer renderer = new BoardConsoleRenderer();
//
//        Piece piece = board.getPiece(new Coordinates(File.G,8));
//        Set<Coordinates> availableMoveSquares = piece.getAvailableMoveSquares(board);
//
//        int a = 123;

        Game game = new Game(board);
        game.gameLoop();
    }
}