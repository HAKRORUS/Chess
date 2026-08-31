package org.example;

import org.example.piece.InputCoordinates;
import org.example.piece.Piece;

import java.util.Set;

public class Game {
    private final Board board;

    private BoardConsoleRenderer renderer = new BoardConsoleRenderer();

    public Game(Board board) {
        this.board = board;
    }

    public void gameLoop() {
        boolean isWhiteToMove = true;

        while (true) {
            renderer.render(board);

            if (isWhiteToMove) {
                System.out.println("white to move");
            } else {
                System.out.println("Black to move");
            }
            Coordinates soureCoordinates = InputCoordinates.inputPieceCoordinatesForColor(
                    isWhiteToMove ? Color.White : Color.Black, board
            );

            Piece piece = board.getPiece(soureCoordinates);
            Set<Coordinates> availableMoveSquares = piece.getAvailableMoveSquares(board);


            renderer.render(board, piece);
            Coordinates targetCoordinates = InputCoordinates.inputAvailableSquare(availableMoveSquares);

            board.movePiece(soureCoordinates, targetCoordinates);


            isWhiteToMove =! isWhiteToMove;
        }
    }
}
