package com.sjia.Leetcode;

import java.util.Arrays;

public class JumpGame5 {
    // #1340. Jump Game V  https://leetcode.com/problems/jump-game-v/

    /*
    Given an array of integers arr and an integer d. In one step you can jump from index i to index:

    i + x where: i + x < arr.length and  0 < x <= d.
    i - x where: i - x >= 0 and  0 < x <= d.
    In addition, you can only jump from index i to index j if arr[i] > arr[j] and arr[i] > arr[k] for all indices k between i and j (More formally min(i, j) < k < max(i, j)).

    You can choose any index of the array and start jumping. Return the maximum number of indices you can visit.
     */

    /*
    Input: arr = [6,4,14,6,8,13,9,7,10,6,12], d = 2
    Output: 4
    Explanation: You can start at index 10. You can jump 10 --> 8 --> 6 --> 7 as shown.
    Note that if you start at index 6 you can only jump to index 7. You cannot jump to index 5 because 13 > 9. You cannot jump to index 4 because index 5 is between index 4 and 6 and 13 > 9.
    Similarly You cannot jump from index 3 to index 2 or index 1.
     */

    // 1 <= arr.length <= 1000
    // 1 <= arr[i] <= 105
    // 1 <= d <= arr.length

    public static int maxJumps(int[] arr, int d) {
//        if (arr == null || arr.length == 0) {
//            return 0;
//        }

        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int maxJumps = 0;

        for (int i = 0; i < n; i++) {
            maxJumps = Math.max(maxJumps, dfs(arr, i, d, dp));
        }

        return maxJumps;
    }

    private static int dfs(int[] arr, int index, int d, int[] dp) {
        if (dp[index] != -1) {
            return dp[index];
        }

        int maxJumps = 1;
        int n = arr.length;

        for (int i = 1; i <= d; i++) {
            if (index - i >= 0 && arr[index - i] < arr[index]) {
                maxJumps = Math.max(maxJumps, 1 + dfs(arr, index - i, d, dp));
            } else {
                break;
            }
        }

        for (int i = 1; i <= d; i++) {
            if (index + i < n && arr[index + i] < arr[index]) {
                maxJumps = Math.max(maxJumps, 1 + dfs(arr, index + i, d, dp));
            } else {
                break;
            }
        }

        dp[index] = maxJumps;
        return maxJumps;
    }




    public static int maxJumps2(int[] arr, int d) {
        int res = 1; // when no jump , return 1
        int n = arr.length;
        int[] dp = new int[n];
        for (int i=0; i < n ; i++) {
            res = Math.max(res, dfsMaxJumps2(arr, d , dp, i) );
        }
        return res;
    }

    private static int dfsMaxJumps2(int[] arr, int d, int[] dp, int i) {
        if ( dp[i] != 0) {
            return dp[i]; // memorization
        }
        int res = 1;
        for (int j=i+1; j<=i+d && j< arr.length && arr[j] < arr[i]; j++) {
            res = Math.max(res, 1 + dfsMaxJumps2(arr, d , dp, j) );
        }
        for (int j=i-1; j>= i-d && j>=0 && arr[j] < arr[i]; j--) {
            res = Math.max(res, 1 + dfsMaxJumps2(arr, d , dp, j) );
        }
        dp[i] = res;
        return dp[i];

    }



    public static void main(String[] args) {
        int[] arr1 = {6, 4, 14, 6, 8, 13, 9, 7, 10, 6, 12};
        int d1 = 2;
        System.out.println("Max jumps: " + maxJumps2(arr1, d1)); // Output: 4

        int[] arr2 = {3, 3, 3, 3, 3};
        int d2 = 3;
        System.out.println("Max jumps: " + maxJumps2(arr2, d2)); // Output: 1

        int[] arr3 = {7, 6, 5, 4, 3, 2, 1};
        int d3 = 1;
        System.out.println("Max jumps: " + maxJumps2(arr3, d3)); // Output: 7

        int[] arr4 = {7, 1, 7, 1, 7, 1};
        int d4 = 2;
        System.out.println("Max jumps: " + maxJumps2(arr4, d4)); // Output: 2
    }



}
