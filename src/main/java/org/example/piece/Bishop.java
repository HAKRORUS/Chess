package org.example.piece;

import org.example.Board;
import org.example.BoardUtils;
import org.example.Color;
import org.example.Coordinates;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Bishop extends LongRangePiece {
    public Bishop(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {

        Set<CoordinatesShift> result = new HashSet<>();

        for (int i = -7; i <= 7; i++) {
            if (i == 0) continue;
            result.add(new CoordinatesShift(i,i));
        }

        for (int i = -7; i <= 7; i++) {
            if (i == 0) continue;
            result.add(new CoordinatesShift(i,-i));
        }
        return result;
    }
}
