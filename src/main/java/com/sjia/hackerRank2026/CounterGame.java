package com.sjia.hackerRank2026;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class CounterGame {
    // https://www.hackerrank.com/challenges/one-month-preparation-kit-counter-game
    // https://www.hackerrank.com/challenges/counter-game/problem

    public static String counterGame(long n) {
        int turnCount = 0;

        // Loop until the counter is reduced to 1
        while (n > 1) {
            // Check if n is a power of 2 using bitwise AND
            if ((n & (n - 1)) == 0) {
                // If it is a power of 2, reduce it by half
                n = n / 2;
            } else {
                // Find the largest power of 2 less than n
                // Long.highestOneBit(n) keeps only the most significant bit
                n = n - Long.highestOneBit(n);
            }
            // Increment turn counter after a valid move
            turnCount++;
        }

        // Louise goes first. Odd turns = Louise wins. Even turns = Richard wins.
        if (turnCount % 2 == 1) {
            return "Louise";
        } else {
            return "Richard";
        }

    }

    public static void main(String[] args) {
        long[] inputs =      {1, 2, 3, 6, 7, 132, 1000000000000000000L, 4, 5, 1024};
        String[] expected =  {"Richard", "Louise", "Louise", "Richard", "Richard",
                "Louise", "Louise", "Richard", "Louise", "Richard"};

        int passed = 0;
        for (int i = 0; i < inputs.length; i++) {
            String actual = counterGame(inputs[i]);
            boolean ok = actual.equals(expected[i]);
            if (ok) passed++;
            System.out.printf("n=%-20d expected=%-8s actual=%-8s %s%n",
                    inputs[i], expected[i], actual, ok ? "PASS" : "FAIL");
        }

        System.out.println(passed + "/" + inputs.length + " tests passed");
    }

}
