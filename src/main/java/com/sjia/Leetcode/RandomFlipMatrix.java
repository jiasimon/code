package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomFlipMatrix {
    // #519. Random Flip Matrix     https://leetcode.com/problems/random-flip-matrix/

    /*
    There is an m x n binary grid matrix with all the values set 0 initially. Design an algorithm to randomly pick an index (i, j) where matrix[i][j] == 0 and flips it to 1. All the indices (i, j) where matrix[i][j] == 0 should be equally likely to be returned.

    Optimize your algorithm to minimize the number of calls made to the built-in random function of your language and optimize the time and space complexity.

    Input
    ["Solution", "flip", "flip", "flip", "reset", "flip"]
    [[3, 1], [], [], [], [], []]
    Output
    [null, [1, 0], [2, 0], [0, 0], null, [2, 0]]

    1 <= m, n <= 10000

     */


    // return new int[]{x / cols, x % cols}

    int rows, cols, total;
    Map<Integer, Integer> map;
    Random random;

    public RandomFlipMatrix(int n_rows, int n_cols) {
        rows = n_rows;
        cols = n_cols;
        total = rows * cols;
        map = new HashMap<>();
        random = new Random();
    }

    public int[] flip() {
        int r = random.nextInt(total--);
        int x = map.getOrDefault(r, r);

        map.put(r, map.getOrDefault(total, total));
        return new int[]{x / cols, x % cols};
    }

    public void reset() {
        map.clear();
        total = rows * cols;
    }

    public static void main(String[] args) {
        int rows = 2, cols = 3;
        RandomFlipMatrix matrix = new RandomFlipMatrix(rows, cols);

        // Flipping cells
        System.out.println(Arrays.toString(matrix.flip()));
        System.out.println(Arrays.toString(matrix.flip()));
        System.out.println(Arrays.toString(matrix.flip()));

        // Resetting matrix
        matrix.reset();

        // Flipping again after reset
        System.out.println(Arrays.toString(matrix.flip()));
        System.out.println(Arrays.toString(matrix.flip()));
    }

}
