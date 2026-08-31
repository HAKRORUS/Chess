package org.example;

import org.example.piece.*;

import java.util.HashMap;

public class Board {
    HashMap<Coordinates, Piece> pieces = new HashMap<>();

    public void setPiece(Coordinates coordinates, Piece piece) {
        piece.coordinates = coordinates;
        pieces.put(coordinates, piece);
    }

    public void removePiece(Coordinates coordinates) {
        pieces.remove(coordinates);
    }

    public void movePiece(Coordinates from, Coordinates to) {
        Piece piece = getPiece(from);
        removePiece(from);
        setPiece(to, piece);
    }

    public boolean isSquareEmpty(Coordinates coordinates) {
        return !pieces.containsKey(coordinates);
    }

    public void  setupDefaultPiecesPositions() {

        //set pawns
        for (File file : File.values()) {
            setPiece(new Coordinates(file,2),new Pawn(Color.White, new Coordinates(file,2)));
            setPiece(new Coordinates(file,7),new Pawn(Color.Black, new Coordinates(file,7)));
        }

        //set rook
        setPiece(new Coordinates(File.A,1),new Rook(Color.White, new Coordinates(File.A,1)));
        setPiece(new Coordinates(File.H,1),new Rook(Color.White, new Coordinates(File.H,1)));
        setPiece(new Coordinates(File.A,8),new Rook(Color.Black, new Coordinates(File.A,8)));
        setPiece(new Coordinates(File.H,8),new Rook(Color.Black, new Coordinates(File.H,8)));

        //set knight
        setPiece(new Coordinates(File.B,1),new Knight(Color.White, new Coordinates(File.B,1)));
        setPiece(new Coordinates(File.G,1),new Knight(Color.White, new Coordinates(File.G,1)));
        setPiece(new Coordinates(File.B,8),new Knight(Color.Black, new Coordinates(File.B,8)));
        setPiece(new Coordinates(File.G,8),new Knight(Color.Black, new Coordinates(File.G,8)));

        //set bishop
        setPiece(new Coordinates(File.C,1),new Bishop(Color.White, new Coordinates(File.C,1)));
        setPiece(new Coordinates(File.F,1),new Bishop(Color.White, new Coordinates(File.F,1)));
        setPiece(new Coordinates(File.C,8),new Bishop(Color.Black, new Coordinates(File.C,8)));
        setPiece(new Coordinates(File.F,8),new Bishop(Color.Black, new Coordinates(File.F,8)));

        //set queen
        setPiece(new Coordinates(File.D,1),new Queen(Color.White, new Coordinates(File.D,1)));
        setPiece(new Coordinates(File.D,8),new Queen(Color.Black, new Coordinates(File.D,8)));

        //set king
        setPiece(new Coordinates(File.E,1),new King(Color.White, new Coordinates(File.E,1)));
        setPiece(new Coordinates(File.E,8),new King(Color.Black, new Coordinates(File.E,8)));

    }


    public static boolean isSquareDark(Coordinates coordinates) {
        return (((coordinates.file.ordinal() + 1) + coordinates.rank) % 2) == 0;
    }

    public Piece getPiece(Coordinates coordinates) {
        return pieces.get(coordinates);
    }
}
