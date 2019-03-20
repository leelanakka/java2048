package com.games._2048;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void shouldReturnTrueIfAnyRowContainsZero() {
        Game game = new Game("leela", 4);
        assertTrue(game.canPutRandom());
        game.makeMove("d");
        assertTrue(game.canPutRandom());
    }

    @Test
    void shouldAddTheSameNeighbours() {
        Game game = new Game("leela", 4);
        ArrayList<Integer> row = new ArrayList<>();
        row.add(2);
        row.add(4);
        row.add(4);
        row.add(2);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(8);
        expected.add(2);
        assertEquals(expected, game.addSameNeighbours(row));

    }

    @Test
    void shouldNotAddTheSameNeighbours() {
        Game game = new Game("leela", 4);
        ArrayList<Integer> row = new ArrayList<>();
        row.add(2);
        row.add(3);
        row.add(4);
        row.add(2);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(2);
        assertEquals(expected, game.addSameNeighbours(row));

    }

    @Test
    void byCallingReverseMethodItShouldReverseTheBoardThatIsPresentNow() {
        Game game = new Game("Akanksha", 4);
        ArrayList<Integer> row = new ArrayList<>();
        row.add(2);
        row.add(3);
        row.add(4);
        row.add(2);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(4);
        expected.add(3);
        expected.add(2);
        assertEquals(expected, game.reverse(row));

    }

    @Test
    void shouldReturnTrueIfTheElementsContainsZeroOrTwoAdjacentElementsAreEqual() {
        Game sai = new Game("sai", 4);
        ArrayList<Integer> row = new ArrayList<>();
        row.add(2);
        row.add(3);
        row.add(2);
        row.add(2);
        assertTrue(sai.canMove(row));
    }

    @Test
    void shouldReturnFalseIfTheElementsContainsZeroOrTwoAdjacentElementsAreEqual() {
        Game sai = new Game("sai", 4);
        ArrayList<Integer> row = new ArrayList<>();
        row.add(2);
        row.add(3);
        row.add(4);
        row.add(2);
        assertFalse(sai.canMove(row));
    }

    @Test
    void shouldReturnFalseIfTheElementsContainsZero() {
        Game sai = new Game("sai", 4);
        ArrayList<Integer> row = new ArrayList<>();
        row.add(2);
        row.add(0);
        row.add(4);
        row.add(2);
        assertTrue(sai.canMove(row));
    }
}