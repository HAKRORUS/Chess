package org.example.piece;

import org.example.*;
import org.example.board.Board;
import org.example.board.BoardConsoleRenderer;
import org.example.board.BoardFactory;
import org.example.board.Move;

import java.util.Scanner;
import java.util.Set;

public class InputCoordinates {
    private static final Scanner scanner = new Scanner(System.in);


    public static Coordinates input() {
        while (true) {
            System.out.println("Please enter cords (ex. a1)");

            String line = scanner.nextLine();

            if (line.length() != 2) {
                System.out.println("invalid format");
                continue;
            }

            char fileChar = line.charAt(0);
            char rankChar = line.charAt(1);

            if (Character.isLetter(rankChar)) {
                System.out.println("Invalid format");
                continue;
            }

            if (Character.isDigit(fileChar)) {
                System.out.println("Invalid format");
                continue;
            }
            int rank = Character.getNumericValue(rankChar);
            if (rank < 1 || rank > 8) {
                System.out.println("Invalid format");
                continue;
            }
            File file = File.fromChar(fileChar);

            if (file == null) {
                System.out.println("Invalid format");
                continue;
            }
            return new Coordinates(file,rank);
        }
    }

    public static Coordinates inputPieceCoordinatesForColor(Color color, Board board) {
            while (true) {
                System.out.println("Enter coordinates for piece to move");
                Coordinates coordinates = input();

                if (board.isSquareEmpty(coordinates)) {
                    System.out.println("Empty square");
                    continue;
                }
                Piece piece = board.getPiece(coordinates);
                if (piece.color != color) {
                    System.out.println("Wrong color");
                    continue;
                }
                Set<Coordinates> availableMoveSquares = piece.getAvailableMoveSquares(board);
                if (availableMoveSquares.isEmpty()) {
                    System.out.println("blocked piece");
                    continue;
                }
                return coordinates;
            }
    }
    public static Coordinates inputAvailableSquare(Set<Coordinates> coordinates) {
            while (true) {
                System.out.println("Enter you-re move");

                Coordinates input = input();
                if (!coordinates.contains(input)) {
                    System.out.println("Non-available square");
                    continue;
                }
                return  input;
            }
        }

        public static Move inputMove(Board board, Color color, BoardConsoleRenderer renderer) {

            while (true) {

                Coordinates soureCoordinates = InputCoordinates.inputPieceCoordinatesForColor(color, board);

                Piece piece = board.getPiece(soureCoordinates);
                Set<Coordinates> availableMoveSquares = piece.getAvailableMoveSquares(board);


                renderer.render(board, piece);
                Coordinates targetCoordinates = InputCoordinates.inputAvailableSquare(availableMoveSquares);


                Move move = new Move(soureCoordinates, targetCoordinates);

                if (validateIfKingCheckAfterMove(board,color,move)) {
                    System.out.println("Your king is under attack");
                    continue;
                }

                return move;
            }
        }

    private static boolean validateIfKingCheckAfterMove(Board board, Color color, Move move) {
        Board copy = (new BoardFactory().copy(board));
        copy.makeMove(move);

        Piece king = copy.getPiecesByColor(color).stream().filter(piece -> piece instanceof King).findFirst().get();
        return copy.isSquareAttackedByColor(king.coordinates,color.opposite());

    }

}
