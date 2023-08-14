package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

class BishopBlackTest {

    @Test
    void position() {
        ru.job4j.chess.firuges.black.BishopBlack bishop = new ru.job4j.chess.firuges.black.BishopBlack(Cell.C1);
        Cell result = bishop.position();
        Cell expected = Cell.C1;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void way() {
        ru.job4j.chess.firuges.black.BishopBlack bishop = new ru.job4j.chess.firuges.black.BishopBlack(Cell.C1);
        Cell[] result = bishop.way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(result).containsExactly(expected);
    }

    @Test
    void wayThenNotDiagonal() {
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> {
                    new ru.job4j.chess.firuges.black.BishopBlack(Cell.C1).way(Cell.G3);
                });
        assertThat(exception.getMessage()).isEqualTo("Could not way by diagonal from C1 to G3");
    }

    @Test
    void copy() {
        ru.job4j.chess.firuges.black.BishopBlack bishop = new ru.job4j.chess.firuges.black.BishopBlack(Cell.C1);
        Cell result = bishop.copy(Cell.G5).position();
        Cell expected = Cell.G5;
        assertThat(result).isEqualTo(expected);
    }
}