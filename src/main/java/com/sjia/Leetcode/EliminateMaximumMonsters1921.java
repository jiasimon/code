package com.sjia.Leetcode;

import java.util.Arrays;

public class EliminateMaximumMonsters1921 {
    // #1921. Eliminate Maximum Number of Monsters  https://leetcode.com/problems/eliminate-maximum-number-of-monsters/description/

    /*
    You are playing a video game where you are defending your city from a group of n monsters. You are given a 0-indexed integer array dist of size n, where dist[i] is the initial distance in kilometers of the ith monster from the city.

    The monsters walk toward the city at a constant speed. The speed of each monster is given to you in an integer array speed of size n, where speed[i] is the speed of the ith monster in kilometers per minute.

    You have a weapon that, once fully charged, can eliminate a single monster. However, the weapon takes one minute to charge.The weapon is fully charged at the very start.

    You lose when any monster reaches your city. If a monster reaches the city at the exact moment the weapon is fully charged, it counts as a loss, and the game ends before you can use your weapon.

    Return the maximum number of monsters that you can eliminate before you lose, or n if you can eliminate all the monsters before they reach the city.

    Input: dist = [1,3,4], speed = [1,1,1]      Output: 3
    Input: dist = [1,1,2,3], speed = [1,1,1,1]  Output: 1
     */



    //
    // 21 ms, 60.53%; 56.1 MB, 39.47%
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;

        // Calculate the time it takes for each monster to reach you
        double[] times = new double[n];
        for (int i = 0; i < n; i++) {
            times[i] = (double) dist[i] / speed[i];
        }

        // Sort the monsters by the time it takes to reach you
        Arrays.sort(times);

        // Find the first monster that arrives at or after you
        int time = 0;
        for (int i = 0; i < n; i++) {
            if (times[i] <= time) {
                return i; // You are eliminated before or at the same time as this monster
            }
            time++; // You eliminate one monster per minute
        }

        return n; // You eliminate all monsters
    }






    public static void main(String[] args) {
        EliminateMaximumMonsters1921 solution = new EliminateMaximumMonsters1921();
        int[] dist = {3, 5, 7};
        int[] speed = {2, 3, 4};
        int eliminated = solution.eliminateMaximum(dist, speed);
        System.out.println("Maximum number of monsters eliminated: " + eliminated);

        int[] dist2 = {3,2,4};
        int[] speed2 = {5,3,2};
        eliminated = solution.eliminateMaximum(dist2, speed2);
        System.out.println("Maximum number of monsters eliminated: " + eliminated);
    }
}
