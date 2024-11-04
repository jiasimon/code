package com.sjia.Leetcode700;

public class MinimumASCIIDelete {
    // #712. Minimum ASCII Delete Sum for Two Strings   https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/description/
    /*

     */

    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        // DP array to store minimum ASCII delete sums
        int[][] dp = new int[m + 1][n + 1];

        // Initialize base cases for dp[i][0] and dp[0][j]
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1);
        }

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];  // Characters match, no deletion needed
                } else {
                    dp[i][j] = Math.min(
                            dp[i - 1][j] + s1.charAt(i - 1),  // Delete from s1
                            dp[i][j - 1] + s2.charAt(j - 1)   // Delete from s2
                    );
                }
            }
        }

        // The answer is the minimum delete sum to make s1 and s2 equal
        return dp[m][n];
    }


    public static void main(String[] args) {
        MinimumASCIIDelete solution = new MinimumASCIIDelete();

        // Test Case 1
        String s1 = "sea";
        String s2 = "eat";
        System.out.println(solution.minimumDeleteSum(s1, s2));  // Output: 231

        // Test Case 2
        String s1_2 = "delete";
        String s2_2 = "leet";
        System.out.println(solution.minimumDeleteSum(s1_2, s2_2));  // Output: 403
    }

}
