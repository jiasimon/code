package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TriangleMinimumTotal {
    // #120. Triangle   https://leetcode.com/problems/triangle/
    /*
    Given a triangle array, return the minimum path sum from top to bottom.

    For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

    Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]] Output: 11
       2
      3 4
     6 5 7
    4 1 8 3
    The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).

    1 <= triangle.length <= 200
    triangle[0].length == 1
    triangle[i].length == triangle[i - 1].length + 1
    -10^4 <= triangle[i][j] <= 10^4

    Follow up: Could you do this using only O(n) extra space, where n is the total number of rows in the triangle?

     */

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        // Create a 2D array to store the minimum path sums
        int[][] dp = new int[n][n];

        // Initialize the bottom row of dp with the values from the last row of the triangle
        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = triangle.get(n - 1).get(i);
        }

        // Fill the dp array from the second last row up to the first row
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                // Calculate the minimum path sum at each position by choosing the smaller value from the next row
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }

        // The minimum path sum is at the top of the dp array
        return dp[0][0];
    }


    public static void main(String[] args) {
        TriangleMinimumTotal solution = new TriangleMinimumTotal();

        // Create the triangle
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));

        // Calculate the minimum path sum
        int result = solution.minimumTotal(triangle);

        // Print the result
        System.out.println("Minimum Path Sum: " + result);  // Output: 11
    }


}
