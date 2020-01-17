package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LogicTest {
    @Test
    public void whenCanMove() {
        Logic logic = new Logic();
        Figure bishop = new BishopBlack(Cell.C1);
        logic.add(bishop);
        Figure pawn = new PawnBlack(Cell.C2);
        logic.add(pawn);
        assertThat(logic.move(Cell.C1, Cell.E3), is (true));
    }

    @Test
    public void whenCantMove() {
        Logic logic = new Logic();
        Figure bishop = new BishopBlack(Cell.C1);
        logic.add(bishop);
        Figure pawn = new PawnBlack(Cell.D2);
        logic.add(pawn);
        assertThat(logic.move(Cell.C1, Cell.E3), is (false));
    }
}
