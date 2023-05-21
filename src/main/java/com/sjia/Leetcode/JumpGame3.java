package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.*;

public class JumpGame3 {
    // #1306. Jump Game III  https://leetcode.com/problems/jump-game-iii/

    // Given an array of non-negative integers arr, you are initially positioned at start index of the array. When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.

    /*
    Input: arr = [4,2,3,0,3,1,2], start = 5
    Output: true
    Explanation:
    All possible ways to reach at index 3 with value 0 are:
    index 5 -> index 4 -> index 1 -> index 3
    index 5 -> index 6 -> index 4 -> index 1 -> index 3
     */

    // 1 <= arr.length <= 5 * 104
    // 0 <= arr[i] < arr.length


    // boolean array, space: O(N)
    public static boolean canReach2(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return canReachdfs(arr, start, visited);
    }

    private static boolean canReachdfs(int[] arr, int start, boolean[] visited) {
        if ( start < 0 || start >= arr.length || visited[start]) return false;
        if( arr[start] == 0) return true;
        visited[start] = true;
        return canReachdfs(arr,start-arr[start],visited) || canReachdfs(arr,start+arr[start],visited);
    }


    // recursive dfs, hashset
    public static boolean canReach(int[] arr, int start) {
        if (arr == null || arr.length == 0) {
            return false;
        }

        Set<Integer> visited = new HashSet<>();
        return canReachHelper(arr, start, visited);
    }


    private static boolean canReachHelper(int[] arr, int index, Set<Integer> visited) {
        if (index < 0 || index >= arr.length || visited.contains(index)) {
            return false;
        }

        if (arr[index] == 0) {
            return true;
        }

        visited.add(index);

        return canReachHelper(arr, index + arr[index], visited)
                || canReachHelper(arr, index - arr[index], visited);
    }


    public static boolean canReachBard(int[] arr, int start) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[start] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int i = curr - arr[curr]; i <= curr + arr[curr]; i++) {
                if (i >= 0 && i < n && dp[i] == -1) {
                    dp[i] = dp[curr] + 1;
                    if (arr[i] == 0) {
                        return true;
                    }
                    queue.add(i);
                }
            }
        }

        return false;
    }



    public static void main(String[] args) {
        int[] arr1 = {4, 2, 3, 0, 3, 1, 2};
        int start1 = 5;
        System.out.println(Arrays.toString(arr1) + " Can reach? " + canReach(arr1, start1)); // Output: true

        int[] arr2 = {4, 2, 3, 0, 3, 1, 2};
        int start2 = 0;
        System.out.println(Arrays.toString(arr2) + " Can reach? " + canReach(arr2, start2)); // Output: true

        int[] arr3 = {3, 0, 2, 1, 2};
        int start3 = 2;
        System.out.println(Arrays.toString(arr3) + " Can reach? " + canReach(arr3, start3)); // Output: false
    }



}
