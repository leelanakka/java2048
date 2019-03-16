package com.games._2048;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Game game = new Game("leela",4);
        printBoard(game.getBoard());
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
