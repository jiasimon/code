package com.sjia.Leetcode;

import java.util.Arrays;

public class MatchsticksToSquare473 {
    // #473. Matchsticks to Square      https://leetcode.com/problems/matchsticks-to-square/description/

    /*
    You are given an integer array matchsticks where matchsticks[i] is the length of the ith matchstick. You want to use all the matchsticks to make one square. You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.

    Return true if you can make this square and false otherwise.

    Input: matchsticks = [1,1,2,2,2]        Output: true
    Input: matchsticks = [3,3,3,3,4]        Output: false

    1 <= matchsticks.length <= 15
    1 <= matchsticks[i] <= 10^8
     */


    //
    // 195 / 195 passed, still TLE
    public boolean makesquare_dfs(int[] matchsticks) {
        if (matchsticks == null || matchsticks.length < 4) {
            return false;
        }

        int totalSum = 0;
        for (int matchstick : matchsticks) {
            totalSum += matchstick;
        }

        if (totalSum % 4 != 0) {
            return false; // Total sum must be divisible by 4
        }

        int targetSideLength = totalSum / 4;
        int[] sides = new int[4]; // Array to store the current sum of each side

        return canFormSquare_dfs(matchsticks, sides, targetSideLength, 0);
    }

    private boolean canFormSquare_dfs(int[] matchsticks, int[] sides, int target, int index) {
        if (index == matchsticks.length) {
            // If all matchsticks are used, check if all sides are of equal length
            return sides[0] == target && sides[1] == target && sides[2] == target;
        }

        // Try to put the current matchstick into each side
        for (int i = 0; i < 4; i++) {
            if (sides[i] + matchsticks[index] <= target) {
                sides[i] += matchsticks[index];
                if (canFormSquare_dfs(matchsticks, sides, target, index + 1)) {
                    return true; // Continue with the next matchstick
                }
                sides[i] -= matchsticks[index]; // Backtrack
            }
        }

        return false;
    }



    // https://leetcode.cn/problems/matchsticks-to-square/solutions/1529706/by-ac_oier-k8i7/
    // faster
    // 4 ms, 92.29%; 40.2 MB, 54.79%

    int[] ms;
    int t;
    public boolean makesquare(int[] _ms) {
        ms = _ms;
        int sum = 0;
        for (int i : ms) sum += i;
        t = sum / 4;
        if (t * 4 != sum) return false;
        Arrays.sort(ms);
        return dfs(ms.length - 1, new int[4]);
    }
    boolean dfs(int idx, int[] cur) {
        if (idx == -1) return true;
        out:for (int i = 0; i < 4; i++) {
            for (int j = 0; j < i; j++) {
                if (cur[j] == cur[i]) continue out;
            }
            int u = ms[idx];
            if (cur[i] + u > t) continue;
            cur[i] += u;
            if (dfs(idx - 1, cur)) return true;
            cur[i] -= u;
        }
        return false;
    }



    public static void main(String[] args) {
        MatchsticksToSquare473 solution = new MatchsticksToSquare473();
        int[] matchsticks = {1, 1, 2, 2, 2};

        boolean canFormSquare = solution.makesquare_dfs(matchsticks);
        System.out.println("Can Form Square: " + canFormSquare); // Output: true
    }
}
