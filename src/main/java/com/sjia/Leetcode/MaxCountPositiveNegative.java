package com.sjia.Leetcode;

public class MaxCountPositiveNegative {
    // #2529. Maximum Count of Positive Integer and Negative Integer    https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/description/
    /*
    Given an array nums sorted in non-decreasing order, return the maximum between the number of positive integers and the number of negative integers.

    In other words, if the number of positive integers in nums is pos and the number of negative integers is neg, then return the maximum of pos and neg.
    Note that 0 is neither positive nor negative.
     */

    public int maximumCount(int[] nums) {
        int p=0, n=0;
        for ( int num : nums) {
            if (num > 0) {
                p++;
            } else if (num < 0) {
                n++;
            }
        }
        return Math.max(p,n);
    }

    
}
