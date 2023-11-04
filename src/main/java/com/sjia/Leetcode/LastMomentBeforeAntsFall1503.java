package com.sjia.Leetcode;

public class LastMomentBeforeAntsFall1503 {
    // #1503. Last Moment Before All Ants Fall Out of a Plank
    // https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/description/?envType=daily-question&envId=2023-11-04

    /*
    Input: n = 4, left = [4,3], right = [0,1]       Output: 4
    Input: n = 7, left = [], right = [0,1,2,3,4,5,6,7]  Output: 7

    1 <= n <= 10000
    0 <= left.length <= n + 1
    0 <= left[i] <= n
    0 <= right.length <= n + 1
    0 <= right[i] <= n
    1 <= left.length + right.length <= n + 1
     */

    public int getLastMoment(int n, int[] left, int[] right) {
        int lastMoment = 0;

        for (int l : left) {
            lastMoment = Math.max(lastMoment, l);
        }

        for (int r : right) {
            lastMoment = Math.max(lastMoment, n - r);
        }

        return lastMoment;
    }

    
    public static void main(String[] args) {
        LastMomentBeforeAntsFall1503 solution = new LastMomentBeforeAntsFall1503();
        int n = 4;
        int[] left = {4};
        int[] right = {0};

        int lastMoment = solution.getLastMoment(n, left, right);
        System.out.println("Last Moment: " + lastMoment);
    }


}
