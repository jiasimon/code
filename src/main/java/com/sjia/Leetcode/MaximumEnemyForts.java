package com.sjia.Leetcode;

public class MaximumEnemyForts {
    // #2511. Maximum Enemy Forts That Can Be Captured  https://leetcode.com/problems/maximum-enemy-forts-that-can-be-captured/description/

    /*
    You are given a 0-indexed integer array forts of length n representing the positions of several forts. forts[i] can be -1, 0, or 1 where:

    -1 represents there is no fort at the ith position.
    0 indicates there is an enemy fort at the ith position.
    1 indicates the fort at the ith the position is under your command.
    Now you have decided to move your army from one of your forts at position i to an empty position j such that:

    0 <= i, j <= n - 1
    The army travels over enemy forts only. Formally, for all k where min(i,j) < k < max(i,j), forts[k] == 0.
    While moving the army, all the enemy forts that come in the way are captured.

    Return the maximum number of enemy forts that can be captured. In case it is impossible to move your army, or you do not have any fort under your command, return 0.
     */



    public int captureForts(int[] forts) {
        int n = forts.length;
        int res = 0, pre = -1;
        for (int i = 0; i < n; i++) {
            if (forts[i] == 1 || forts[i] == -1) {
                if (pre >= 0 && forts[i] != forts[pre]) {
                    res = Math.max(res, i - pre - 1);
                }
                pre = i;
            }
        }
        return res;
    }




    public static void main(String[] args) {
        MaximumEnemyForts solution = new MaximumEnemyForts();
        int[] forts = {1,0,0,-1,0,0,0,0,1};
        int maxCaptured = solution.captureForts(forts);
        System.out.println("Maximum enemy forts that can be captured: " + maxCaptured);
    }

}
