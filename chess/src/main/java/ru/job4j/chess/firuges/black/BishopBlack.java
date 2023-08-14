package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell source;

    public BishopBlack(final Cell ps) {
        source = ps;
    }

    @Override
    public Cell position() {
        return source;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(source, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not way by diagonal from %s to %s", source, dest)
            );
        }
        int size = Math.abs(source.getX() - dest.getX());
        Cell[] steps = new Cell[size];
        int deltaX = dest.getX() - source.getX() > 0 ? 1 : -1;
        int deltaY = dest.getY() - source.getY() > 0 ? 1 : -1;
        for (int index = 0; index < size; index++) {
            int x = source.getX() + (index + 1) * deltaX;
            int y = source.getY() + (index + 1) * deltaY;
            steps[index] = Cell.findBy(x, y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        int x1x2 = Math.abs(source.getX() - dest.getX());
        int y1y2 = Math.abs(source.getY() - dest.getY());
        return source.getX() != dest.getX() && source.getY() != dest.getY() && x1x2 == y1y2;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}