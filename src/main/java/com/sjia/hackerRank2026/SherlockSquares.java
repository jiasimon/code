package com.sjia.hackerRank2026;

public class SherlockSquares {
    // https://www.hackerrank.com/challenges/sherlock-and-squares
    public static int squares(int a, int b) {
        int start = (int)Math.ceil(Math.sqrt(a));
        int end = (int) Math.floor(Math.sqrt(b));
        if (end < start) return 0;
        return end-start+1;

    }
}
