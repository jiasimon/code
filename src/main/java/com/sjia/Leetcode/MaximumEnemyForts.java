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



    // one pass, pre, i - pre - 1
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



    // two pass
    public int captureForts_twoPass(int[] forts) {
        int n = forts.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (forts[i] == 1 ) {
                for ( int j = i+1; j < n; j++) {
                    if (forts[j] == 1) {
                        break;
                    } else if (forts[j] == -1) {
                        res = Math.max(res, j - i - 1);
                        break;
                    }
                }

            }
        }

        for (int i = n-1; i >=0; i--) {
            if (forts[i] == 1 ) {
                for ( int j = i-1; j >=0; j--) {
                    if (forts[j] == 1) {
                        break;
                    } else if (forts[j] == -1) {
                        res = Math.max(res, i-j - 1);
                        break;
                    }
                }

            }
        }

        return res;
    }




    public static void main(String[] args) {
        MaximumEnemyForts solution = new MaximumEnemyForts();
        int[] forts = {1,0,0,-1,0,0,0,0,1};
        int maxCaptured = solution.captureForts_twoPass(forts);
        System.out.println("Maximum enemy forts that can be captured: " + maxCaptured);

        int[] forts2 = {1,0,0,-1,0,0,-1,0,0,1};
        int maxCaptured2 = solution.captureForts_twoPass(forts2);
        System.out.println("Maximum enemy forts that can be captured: " + maxCaptured2);

    }

}
