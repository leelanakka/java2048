package com.games._2048;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Game game = new Game("lela",4);
        System.out.println(game.moveLeft(new ArrayList<>(Arrays.asList(2, 2, 4, 2))));
        System.out.println(game.moveLeft(new ArrayList<>(Arrays.asList(2, 4, 4, 2))));
        System.out.println(game.moveLeft(new ArrayList<>(Arrays.asList(4, 2, 4, 2))));
        System.out.println(game.moveLeft(new ArrayList<>(Arrays.asList(2, 2, 4, 4))));
        System.out.println(game.moveLeft(new ArrayList<>(Arrays.asList(2, 2, 2, 2))));
        System.out.println(game.moveLeft(new ArrayList<>(Arrays.asList(2, 2, 0, 0))));

        System.out.println(game.moveLeft(new ArrayList<>(Arrays.asList(0, 0, 0, 0))));
    }


}
