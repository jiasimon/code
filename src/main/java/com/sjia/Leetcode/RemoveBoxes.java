package com.sjia.Leetcode;

public class RemoveBoxes {
    // #546. Remove Boxes   https://leetcode.com/problems/remove-boxes/description/

    /*
    You are given several boxes with different colors represented by different positive numbers.

    You may experience several rounds to remove boxes until there is no box left. Each time you can choose some continuous boxes with the same color (i.e., composed of k boxes, k >= 1), remove them and get k * k points.

    Return the maximum points you can get.

    Input: boxes = [1,3,2,2,2,3,4,3,1]      Output: 23
    [1, 3, 2, 2, 2, 3, 4, 3, 1]
    ----> [1, 3, 3, 4, 3, 1] (3*3=9 points)
    ----> [1, 3, 3, 3, 1] (1*1=1 points)
    ----> [1, 1] (3*3=9 points)
    ----> [] (2*2=4 points)

    Input: boxes = [1,1,1]      Output: 9

    Input: boxes = [1]          Output: 1
     */


    public int removeBoxes(int[] boxes) {
        int[][][] memo = new int[100][100][100];
        return dp(boxes, memo, 0, boxes.length - 1, 0);
    }


    // memo[l][r][k] , TLE 20 / 63
    private int dp(int[] boxes, int[][][] memo, int l, int r, int k) {
        if (l > r) return 0;
        if (memo[l][r][k] != 0) return memo[l][r][k];

        // Optimize k
        while (r > l && boxes[r] == boxes[r - 1]) {
            r--;
            k++;
        }

        memo[l][r][k] = dp(boxes, memo, l, r - 1, 0) + (k + 1) * (k + 1);

        for (int i = l; i < r; i++) {
            if (boxes[i] == boxes[r]) {
                memo[l][r][k] = Math.max(memo[l][r][k],
                        dp(boxes, memo, l, i, k + 1) + dp(boxes, memo, i + 1, r - 1, 0));
            }
        }

        return memo[l][r][k];
    }

    public static void main(String[] args) {
        RemoveBoxes solution = new RemoveBoxes();
        int[] boxes = {1, 3, 2, 2, 2, 3, 4, 3, 1};
        System.out.println("Maximum points after removing boxes: " + solution.removeBoxes(boxes));
    }


}
