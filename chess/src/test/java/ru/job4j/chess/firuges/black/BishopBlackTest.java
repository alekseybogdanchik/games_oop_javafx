package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;

public class BishopBlackTest {
    @Test
    public void WhenPositionC1ThanC1() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Cell position = bishopBlack.position();
        assertSame(Cell.C1, position);
    }

    @Test
    public void WhenC1CopyToG5ThanG5() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Figure bishopBlack2 = bishopBlack.copy(Cell.G5);
        Cell position = bishopBlack2.position();
        assertSame(Cell.G5, position);
    }

    @Test
    public void WhenMoveC1ToG5() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Cell[] steps = bishopBlack.way(Cell.C1, Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(steps, is (expected));
    }

    @Test
    public void WhenMoveG5ToC1() {
        Figure bishopBlack = new BishopBlack(Cell.G5);
        Cell[] steps = bishopBlack.way(Cell.G5, Cell.C1);
        Cell[] expected = {Cell.F4, Cell.E3, Cell.D2, Cell.C1};
        assertThat(steps, is (expected));
    }

    @Test(expected = IllegalStateException.class)
    public void WhenNotDiagonalMoveC2ToG5() {
        Figure bishopBlack = new BishopBlack(Cell.C2);
        bishopBlack.way(Cell.C2, Cell.G5);
    }
}

