package com.sjia.Leetcode;

import java.util.*;

public class FrogJump {
    // #403. Frog Jump  https://leetcode.com/problems/frog-jump/description/

    /*
    Given a list of stones' positions (in units) in sorted ascending order, determine if the frog can cross the river by landing on the last stone. Initially, the frog is on the first stone and assumes the first jump must be 1 unit.

    If the frog's last jump was k units, its next jump must be either k - 1, k, or k + 1 units. The frog can only jump in the forward direction.

    Input: stones = [0,1,3,5,6,8,12,17]     Output: true
    Explanation: The frog can jump to the last stone by jumping 1 unit to the 2nd stone, then 2 units to the 3rd stone, then 2 units to the 4th stone, then 3 units to the 6th stone, 4 units to the 7th stone, and 5 units to the 8th stone.

    Input: stones = [0,1,2,3,4,8,9,11]      Output: false
    Explanation: There is no way to jump to the last stone as the gap between the 5th and 6th stone is too large.

    2 <= stones.length <= 2000
    0 <= stones[i] <= 2^31 - 1
    stones[0] == 0

     */


    // Map<Integer, Set<Integer>> stoneMap, start to end
    // 41 ms, 67.46%; 49.8 MB, 49.13%
    public boolean canCross(int[] stones) {
        int n = stones.length;

        // Create a map to store stone positions for quick lookup
        Map<Integer, Set<Integer>> stoneMap = new HashMap<>();
        for (int stone : stones) {
            stoneMap.put(stone, new HashSet<>());
        }

        // Base case: the frog can only start from the first stone
        stoneMap.get(0).add(0);

        for (int i = 0; i < n; i++) {
            for (int jump : stoneMap.get(stones[i])) {
                // Try jumping to the next possible stones
                for (int step = jump - 1; step <= jump + 1; step++) {
                    if (step > 0 && stoneMap.containsKey(stones[i] + step)) {
                        stoneMap.get(stones[i] + step).add(step);
                    }
                }
            }
        }

        // If the last stone has at least one possible jump, the frog can cross
        return !stoneMap.get(stones[n - 1]).isEmpty();
    }



    // DP,  jump to stones[i] with jump j
    // 87 ms, 24.89%; 63 MB, 15.31%
    public boolean canCross_dp(int[] stones) {
        final int n = stones.length;
        // dp[i][j] := 1 if a frog can make a size j jump to stones[i]
        int[][] dp = new int[n][n + 1];
        dp[0][0] = 1;

        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                final int k = stones[i] - stones[j];
                if (k > n)
                    continue;
                for (final int x : new int[] {k - 1, k, k + 1})
                    if (0 <= x && x <= n)
                        dp[i][k] |= dp[j][x];
            }
        }

        for (int i=0; i <= n; i++) {
            if (dp[n-1][i] == 1) {
                return true;
            }
        }
        return false;

    }




    // anyMatch(a -> a == 1)
    // 95 ms, 21.96%; 62.8 MB, 15.64%
    public boolean canCross_stream(int[] stones) {
        final int n = stones.length;
        // dp[i][j] := 1 if a frog can make a size j jump to stones[i]
        int[][] dp = new int[n][n + 1];
        dp[0][0] = 1;

        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                final int k = stones[i] - stones[j];
                if (k > n)
                    continue;
                for (final int x : new int[] {k - 1, k, k + 1})
                    if (0 <= x && x <= n)
                        dp[i][k] |= dp[j][x];
            }
        }

        return Arrays.stream(dp[n - 1]).anyMatch(a -> a == 1);
    }


    public static void main(String[] args) {
        FrogJump solution = new FrogJump();
        int[] stones = {0, 1, 3, 5, 6, 8, 12, 17};
        boolean canCross = solution.canCross_dp(stones);

        if (canCross) {
            System.out.println("The frog can cross the river.");
        } else {
            System.out.println("The frog cannot cross the river.");
        }
    }






}
