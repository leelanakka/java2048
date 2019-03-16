package com.games._2048;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Game game = new Game("leela",4);
        System.out.println(game.moveLeft(new ArrayList<>(Arrays.asList(2, 2, 4, 2))));
        System.out.println(game.moveLeft(new ArrayList<>(Arrays.asList(2, 4, 4, 2))));
        System.out.println(game.moveLeft(new ArrayList<>(Arrays.asList(4, 2, 4, 2))));
        System.out.println(game.moveLeft(new ArrayList<>(Arrays.asList(2, 2, 4, 4))));
        System.out.println(game.moveLeft(new ArrayList<>(Arrays.asList(2, 2, 2, 2))));
        System.out.println(game.moveLeft(new ArrayList<>(Arrays.asList(2, 2, 0, 0))));

        System.out.println(game.moveLeft(new ArrayList<>(Arrays.asList(0, 0, 0, 0))));
        ArrayList<ArrayList<Integer>> board = new ArrayList<>();
        board.add(new ArrayList<>(Arrays.asList(2, 2, 0, 0)));
        board.add(new ArrayList<>(Arrays.asList(2, 2, 0, 0)));
        board.add(new ArrayList<>(Arrays.asList(2, 2, 0, 0)));
        board.add(new ArrayList<>(Arrays.asList(2, 2, 0, 0)));
        printBoard(board);
    }


    public static void printBoard(ArrayList<ArrayList<Integer>> board) {
        System.out.println("+---+---+---+---+");
        for (ArrayList<Integer> row : board) {
            System.out.print("|");
            for (Integer integer : row) {
                System.out.print(" " + ((integer != 0) ? integer : " ") + " |");
            }
            System.out.println("\n+---+---+---+---+");
        }
    }
}
