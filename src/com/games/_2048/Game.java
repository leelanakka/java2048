package com.games._2048;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private  ArrayList<Integer> addSameNeighbours(ArrayList<Integer> integers) {
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

    private  ArrayList<Integer> removeZeros(List<Integer> integers) {
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer integer : integers) {
            if (integer != 0) result.add(integer);

        }
        return result;
    }

    private  ArrayList<Integer> addZeros(ArrayList<Integer> integers, int size) {
        ArrayList<Integer> result = new ArrayList<>(integers);
        while (result.size() != size) {
            result.add(0);
        }
        return result;
    }

    public ArrayList<Integer> moveLeft(ArrayList<Integer> integers) {
        return addZeros(addSameNeighbours(removeZeros(integers)), integers.size());
    }
}
