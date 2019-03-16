package com.games._2048;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {

    private ArrayList<ArrayList<Integer>> board = new ArrayList<>();
    private String PlayerName;
    private int size;

    public Game(String playerName, int size) {
        this.size = size;
        initializeBoard();
        this.PlayerName = playerName;
    }

    public ArrayList<ArrayList<Integer>> getBoard() {
        return board;
    }

    private void putTwoAtRandomEmptyPlaces(){
        int position = (int) (Math.random() * size*size);
        int row = (int) Math.ceil(position % (size*size) /size);
        int index = (position%size);
        if(board.get(row).get(index)==0){
            board.get(row).set(index,2);
            return;
        }
        putTwoAtRandomEmptyPlaces();
    }

    private void initializeBoard() {
        for (int i = 0; i < size; i++) {
            board.add(addZeros(new ArrayList<>(), size));
        }
        this.putTwoAtRandomEmptyPlaces();
        this.putTwoAtRandomEmptyPlaces();
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

    private void transpose(){
        for (int rowIndex = 0; rowIndex < this.board.size(); rowIndex++) {
            for (int columnIndex = rowIndex+1; columnIndex < this.board.size(); columnIndex++) {
                ArrayList<Integer> row = this.board.get(rowIndex);
                ArrayList<Integer> column = this.board.get(columnIndex);
                int temp1 = row.get(columnIndex);
                int temp2 = column.get(rowIndex);
                row.set(columnIndex,temp2);
                column.set(rowIndex,temp1);
            }
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

    private void moveUpBoard(){
        transpose();
        moveLeftBoard();
        transpose();
    }

    private void moveDownBoard(){
        transpose();
        moveRightBoard();
        transpose();
    }

    public boolean makeMove(String move){
        switch (move) {
            case "l":
                moveLeftBoard();
                break;
            case "r":
                moveRightBoard();
                break;
            case "u":
                moveUpBoard();
                break;
            case "d":
                moveDownBoard();
                break;
            default:
                return false;
        }
        putTwoAtRandomEmptyPlaces();
        return true;
    }
}
