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


    public int findMaxForm_dp(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];

        for (String str : strs) {
            int zeros = 0;
            int ones =0;

            for (char c: str.toCharArray()) {
                if ( c =='1') {
                    ones++;
                } else {
                    zeros++;
                }
            }


            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }


        }
        return dp[m][n];
    }



    // count0 = (int) s.chars().filter(c -> c == '0').count()
    // 20 ms, 81.14%; 41.4 MB, 58.54%
    public int findMaxForm_filter(String[] strs, int m, int n) {
        // dp[i][j] := max size of the subset given i 0's and j 1's are available
        int[][] dp = new int[m + 1][n + 1];

        for (final String s : strs) {
            final int count0 = (int) s.chars().filter(c -> c == '0').count();
            final int count1 = (int) s.length() - count0;
            for (int i = m; i >= count0; --i)
                for (int j = n; j >= count1; --j)
                    dp[i][j] = Math.max(dp[i][j], dp[i - count0][j - count1] + 1);
        }

        return dp[m][n];

    }



    public static void main(String[] args) {
        OnesZeroesMaxForm solution = new OnesZeroesMaxForm();
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5;
        int n = 3;
        int maxStrings = solution.findMaxForm_dp(strs, m, n);
        System.out.println("Maximum number of strings: " + maxStrings); // Output: 4
    }



}
