package com.sjia.Leetcode600;

public class KnightProbability {
    // #688. Knight Probability in Chessboard   https://leetcode.com/problems/knight-probability-in-chessboard/description/
    /*
    The rows and columns are 0-indexed, so the top-left cell is (0, 0), and the bottom-right cell is (n - 1, n - 1).

    Return the probability that the knight remains on the board after it has stopped moving.

    Input: n = 3, k = 2, row = 0, column = 0    Output: 0.06250


     */

    private final int[][] directions = {
            {-2, -1}, {-1, -2}, {1, -2}, {2, -1},
            {2, 1}, {1, 2}, {-1, 2}, {-2, 1}
    };

    public double knightProbability(int N, int K, int r, int c) {
        // dp[k][i][j] will represent the probability of being on cell (i, j) after k moves
        double[][][] dp = new double[K + 1][N][N];
        dp[0][r][c] = 1;

        for (int k = 1; k <= K; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int[] direction : directions) {
                        int prevRow = i + direction[0];
                        int prevCol = j + direction[1];
                        if (prevRow >= 0 && prevRow < N && prevCol >= 0 && prevCol < N) {
                            dp[k][i][j] += dp[k - 1][prevRow][prevCol] / 8.0;
                        }
                    }
                }
            }
        }

        double result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result += dp[K][i][j];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        KnightProbability solution = new KnightProbability();

        // Test Case 1
        int N1 = 3, K1 = 2, r1 = 0, c1 = 0;
        System.out.println("Test Case 1: " + solution.knightProbability(N1, K1, r1, c1)); // Expected output: 0.0625

        // Test Case 2
        int N2 = 8, K2 = 3, r2 = 6, c2 = 4;
        System.out.println("Test Case 2: " + solution.knightProbability(N2, K2, r2, c2)); // Expected output: 0.4277 (approximately)

        // Test Case 3
        int N3 = 4, K3 = 1, r3 = 2, c3 = 2;
        System.out.println("Test Case 3: " + solution.knightProbability(N3, K3, r3, c3)); // Expected output: 0.5
    }

}
