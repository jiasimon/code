package com.sjia.Leetcode;

public class ChampagneTower {
    // #799. Champagne Tower    https://leetcode.com/problems/champagne-tower/

    /*
    We stack glasses in a pyramid, where the first row has 1 glass, the second row has 2 glasses, and so on until the 100th row.  Each glass holds one cup of champagne.

    Then, some champagne is poured into the first glass at the top.  When the topmost glass is full, any excess liquid poured will fall equally to the glass immediately to the left and right of it.  When those glasses become full, any excess champagne will fall equally to the left and right of those glasses, and so on.  (A glass at the bottom row has its excess champagne fall on the floor.)

    For example, after one cup of champagne is poured, the top most glass is full.  After two cups of champagne are poured, the two glasses on the second row are half full.  After three cups of champagne are poured, those two cups become full - there are 3 full glasses total now.  After four cups of champagne are poured, the third row has the middle glass half full, and the two outside glasses are a quarter full, as pictured below.

    Input: poured = 1, query_row = 1, query_glass = 1   Output: 0.00000
    Explanation: We poured 1 cup of champange to the top glass of the tower (which is indexed as (0, 0)). There will be no excess liquid so all the glasses under the top glass will remain empty.

    Input: poured = 2, query_row = 1, query_glass = 1   Output: 0.50000
    Explanation: We poured 2 cups of champange to the top glass of the tower (which is indexed as (0, 0)). There is one cup of excess liquid. The glass indexed as (1, 0) and the glass indexed as (1, 1) will share the excess liquid equally, and each will get half cup of champange.

    Input: poured = 100000009, query_row = 33, query_glass = 17     Output: 1.00000
    0 <= poured <= 10^9
    0 <= query_glass <= query_row < 100
     */


    // Simulation
    // 2 ms, 98.73%; 43.2 MB, 63.64%
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] tower = new double[query_row + 1][query_row + 1];
        tower[0][0] = poured; // Pour champagne into the top glass

        for (int i = 0; i < query_row; i++) {
            for (int j = 0; j <= i; j++) {
                double excess = (tower[i][j] - 1.0) / 2.0; // Calculate excess champagne
                if (excess > 0) {
                    tower[i + 1][j] += excess; // Distribute excess to the left glass below
                    tower[i + 1][j + 1] += excess; // Distribute excess to the right glass below
                }
            }
        }

        return Math.min(1.0, tower[query_row][query_glass]); // Cap the result at 1.0 (maximum capacity)
    }


    public static void main(String[] args) {
        ChampagneTower solver = new ChampagneTower();
        int poured = 2;
        int query_row = 1;
        int query_glass = 1;
        double result = solver.champagneTower(poured, query_row, query_glass);
        System.out.println("Champagne in the glass: " + result); // Output: 0.5
    }


}
