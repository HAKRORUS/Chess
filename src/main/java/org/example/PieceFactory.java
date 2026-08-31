package org.example;

import org.example.piece.*;

public class PieceFactory {
    Piece fromFenChar(char fenChar, Coordinates coordinates) {
        switch (fenChar) {
            case 'p':
                return new Pawn(Color.Black, coordinates);
            case 'P':
                return new Pawn(Color.White, coordinates);

            case 'r':
                return new Rook(Color.Black, coordinates);
            case 'R':
                return new Rook(Color.White, coordinates);

            case 'n':
                return new Knight(Color.Black, coordinates);
            case 'N':
                return new Knight(Color.White, coordinates);

            case 'b':
                return new Bishop(Color.Black, coordinates);
            case 'B':
                return new Bishop(Color.White, coordinates);

            case 'q':
                return new Queen(Color.Black, coordinates);
            case 'Q':
                return new Queen(Color.White, coordinates);

            case 'k':
                return new King(Color.Black, coordinates);
            case 'K':
                return new King(Color.White, coordinates);

            default:
                throw new RuntimeException("Unknown FEN char!");
        }
    }
}
