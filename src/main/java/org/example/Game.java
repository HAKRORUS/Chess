package org.example;

import org.example.board.Board;
import org.example.board.BoardConsoleRenderer;
import org.example.piece.InputCoordinates;
import org.example.board.Move;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Game {
    private final Board board;

    private BoardConsoleRenderer renderer = new BoardConsoleRenderer();

    private final List<GameStateChecker> checkers = List.of(
            new CheckmateGameStateChecker(),
            new StalemateGameStateChecker()
    );


    public Game(Board board) {
        this.board = board;
    }

    public void gameLoop() {
        Color colorToMove = Color.White;

        GameState state = determineGameState(board, colorToMove);

        while (state == GameState.ONGOING) {
            renderer.render(board);

            if (colorToMove == Color.White) {
                System.out.println("white to move");
            } else {
                System.out.println("Black to move");
            }

            Move move = InputCoordinates.inputMove(board, colorToMove, renderer);

            board.makeMove(move);


            colorToMove = colorToMove.opposite();

            state = determineGameState(board,colorToMove);
        }

        renderer.render(board);
        System.out.println("Game ended with state = " + state);
    }

    private GameState determineGameState(Board board, Color color) {
        for (GameStateChecker checker : checkers) {
            GameState state = checker.check(board,color);

            if (state != GameState.ONGOING) {
                return state;
            }
        }
        return GameState.ONGOING;
    }
}
