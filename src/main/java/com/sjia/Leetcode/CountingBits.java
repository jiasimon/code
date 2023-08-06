package com.sjia.Leetcode;

import java.util.Arrays;

public class CountingBits {
    // #338. Counting Bits  https://leetcode.com/problems/counting-bits/description/
    /*
    Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
    Input: n = 2    Output: [0,1,1]
    Input: n = 5    Output: [0,1,1,2,1,2]
     */



    // bitCount
    // 2 ms, 63.32%; 46.8 MB, 12.60%
    public int[] countBits_bitCount(int num) {
        int[] res = new int[num+1];
        for (int i=0; i <= num; i++) {
            res[i] = Integer.bitCount(i);
        }
        return res;
    }

    public static void main(String[] args) {
        CountingBits solution = new CountingBits();
        int num = 5;
        int[] result = solution.countBits(num);
        System.out.println(Arrays.toString(result)); // Output: [0, 1, 1, 2, 1, 2]
    }

}
