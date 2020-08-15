package com.sjia.Leetcode;

import java.util.HashSet;

public class DistributeCandies {
    // #575 https://leetcode.com/problems/distribute-candies/

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


}
