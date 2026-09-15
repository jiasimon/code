package com.sjia.hackerRank2026;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FormingMagicSquare {
    // https://www.hackerrank.com/challenges/magic-square-forming/

    public static int formingMagicSquare(List<List<Integer>> s) {
        // Predefined list of all 8 possible 3x3 magic squares
        int[][][] magicSquares = {
                {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
                {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
                {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
                {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},
                {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
                {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},
                {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},
                {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}}
        };

        int minCost = Integer.MAX_VALUE;

        // Iterate through each possible valid magic square
        for (int[][] magic : magicSquares) {
            int currentCost = 0;

            // Compare each position to calculate the absolute difference cost
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    currentCost += Math.abs(s.get(i).get(j) - magic[i][j]);
                }
            }

            // Keep track of the minimum cost found
            minCost = Math.min(minCost, currentCost);
        }

        return minCost;
    }

    public static void main(String[] args) throws IOException {

        List<List<Integer>> s = new ArrayList<>();
        s.add(Arrays.asList(5,3,4));
        s.add(Arrays.asList(1,5,8));
        s.add(Arrays.asList(6,4,2));

        int result = FormingMagicSquare.formingMagicSquare(s);

        System.out.print(result);

    }


}
