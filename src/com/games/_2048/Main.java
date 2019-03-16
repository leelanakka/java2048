package com.games._2048;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name :- ");
        String playerName = scanner.next();
        Game game = new Game(playerName, 4);

        System.out.println("welcome " + game.getPlayerName() + " to 2048 world ");
        printBoard(game.getBoard());


        while (true) {
            System.out.println("Enter the which side you want to swipe ");
            String input = scanner.next();
            if (input.equals("q")) break;
           if(!game.makeMove(input)){
               System.out.println("Invalid input");
           }
            printBoard(game.getBoard());
            if(game.isWon()){
                System.out.println("you won...! ");
                break;
            }
        }
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
