package com.games._2048;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private ArrayList<ArrayList<Integer>> board;
    private String PlayerName;

    public Game(String playerName, int size) {
        this.board = initializeBoard(size);
        this.PlayerName = playerName;
    }

    private ArrayList<ArrayList<Integer>> initializeBoard(int size) {
        ArrayList<ArrayList<Integer>> integers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            integers.add(addZeros(new ArrayList<>(), size));
        }
        return integers;
    }

    private ArrayList<Integer> addSameNeighbours(ArrayList<Integer> integers) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < integers.size(); i++) {
            if (i != integers.size() - 1 && integers.get(i).equals(integers.get(i + 1))) {
                result.add(integers.get(i) * 2);
                i++;
                continue;
            }
            result.add(integers.get(i));
        }
        return result;
    }

    private ArrayList<Integer> removeZeros(List<Integer> integers) {
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer integer : integers) {
            if (integer != 0) result.add(integer);

        }
        return result;
    }

    private ArrayList<Integer> addZeros(ArrayList<Integer> integers, int size) {
        ArrayList<Integer> result = new ArrayList<>(integers);
        while (result.size() != size) {
            result.add(0);
        }
        return result;
    }

    private ArrayList<Integer> moveLeft(ArrayList<Integer> integers) {
        return addZeros(addSameNeighbours(removeZeros(integers)), integers.size());
    }

    private ArrayList<Integer> reverse(ArrayList<Integer> row){
        ArrayList<Integer> reversedRow = new ArrayList<>(row);
        for (int i = row.size()-1; i >= 0; i++) {
            reversedRow.add(row.get(i));
        }
        return reversedRow;
    }

    private void reverseBoard(){
        for (int row = 0; row < this.board.size(); row++) {
            this.board.set(row,reverse(this.board.get(row)));
        }
    }

    private void moveLeftBoard(){
        for (int row = 0; row < this.board.size(); row++) {
            this.board.set(row,moveLeft(this.board.get(row)));
        }
    }

    private void moveRightBoard(){
        reverseBoard();
        moveLeftBoard();
        reverseBoard();
    }
}
