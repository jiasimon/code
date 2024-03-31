package com.sjia.Leetcode;

import java.util.HashSet;

public class DistributeCandies {
    // #575. Distribute Candies https://leetcode.com/problems/distribute-candies/

    // Given an integer array with even length, where different numbers in this array represent different kinds of candies.
    // You need to distribute these candies equally in number to brother and sister.
    // Return the maximum number of kinds of candies the sister could gain.

    // Runtime: 33 ms, faster than 79.45% of Java online submissions for Distribute Candies.
    //Memory Usage: 41.3 MB, less than 76.05% of Java online submissions for Distribute Candies.
    public int distributeCandies(int[] candies) {
        HashSet<Integer> tmp = new HashSet<>();
        for (int n : candies ) {
            tmp.add(n);
        }
        return Math.min(candies.length/2, tmp.size());
    }


    //Runtime: 85 ms, faster than 8.61% of Java online submissions for Distribute Candies.
    //Memory Usage: 114.6 MB, less than 25.00% of Java online submissions for Distribute Candies.
/*
    public int distributeCandies(int[] candies) {
        return Math.min(candies.length / 2, ((int) Arrays.stream(candies).distinct().count()));
    }*/


    // HashSet, 30ms
    public int distributeCandies_Set(int[] candies) {
        int n = candies.length;
        HashSet set = new HashSet<>();
        for (int c : candies) {
            set.add(c);
        }
        return Math.min(n/2, set.size());
    }

    public static void main(String[] args) {
        DistributeCandies solution = new DistributeCandies();

        int[] testCandies1 = {1, 1, 2, 2, 3, 3};
        int[] testCandies2 = {1, 1, 2, 3};

        System.out.println("Test Case 1: " + solution.distributeCandies(testCandies1)); // Output: 3
        System.out.println("Test Case 2: " + solution.distributeCandies(testCandies2)); // Output: 2
    }

}
