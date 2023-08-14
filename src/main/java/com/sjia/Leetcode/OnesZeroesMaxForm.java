package com.sjia.Leetcode;

public class OnesZeroesMaxForm {
    // #474. Ones and Zeroes    https://leetcode.com/problems/ones-and-zeroes/description/

    /*
    You are given an array of binary strings strs and two integers m and n.

    Return the size of the largest subset of strs such that there are at most m 0's and n 1's in the subset.

    A set x is a subset of a set y if all elements of x are also elements of y.

    Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3  Output: 4
    Input: strs = ["10","0","1"], m = 1, n = 1      Output: 2

    1 <= strs.length <= 600
    1 <= strs[i].length <= 100
    strs[i] consists only of digits '0' and '1'
    1 <= m, n <= 100
     */

    // target: m and n, or int[2], coins: string[]
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];

        for (String str : strs) {
            int zeros = countZeros(str);
            int ones = str.length() - zeros;

            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }


        }
        return dp[m][n];
    }


    private int countZeros(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == '0') {
                count++;
            }
        }
        return count;
    }



    public static void main(String[] args) {
        OnesZeroesMaxForm solution = new OnesZeroesMaxForm();
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5;
        int n = 3;
        int maxStrings = solution.findMaxForm(strs, m, n);
        System.out.println("Maximum number of strings: " + maxStrings); // Output: 4
    }



}
