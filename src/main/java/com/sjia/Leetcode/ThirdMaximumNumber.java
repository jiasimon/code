package com.sjia.Leetcode;

public class ThirdMaximumNumber {

    // #414 https://leetcode.com/problems/third-maximum-number/
    // [2, 2, 3, 1] , return Output: 1
    // Given a non-empty array of integers,return the third maximum number
    // If it does not exist, return the maximum number.

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Third Maximum Number.
    //Memory Usage: 39.5 MB, less than 18.33% of Java online submissions for Third Maximum Number.

    // add flag for [1,2,-2147483648]
/*
    public int thirdMax(int[] nums) {
        int first = Integer.MIN_VALUE, second =Integer.MIN_VALUE, third = Integer.MIN_VALUE;
        boolean flag = true;
        for (int n : nums) {
            if ( n > first) {
                third = second;
                second =first;
                first = n;
            } else if ( n < first && n > second) {
                third = second;
                second = n;
            } else if ( n < second && n > third) {
                third = n;
            } else if ( n== Integer.MIN_VALUE) flag = false;
        }
        if ((third == Integer.MIN_VALUE && flag ) || third == second) return first;
        else return third;
    }*/


    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Third Maximum Number.
    //Memory Usage: 39.6 MB, less than 12.08% of Java online submissions for Third Maximum Number.
    public int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE, second = Long.MIN_VALUE, third = Long.MIN_VALUE;
        for (int n : nums) {
            if (n > first) {
                third = second;
                second = first;
                first = n;
            } else if (n < first && n > second) {
                third = second;
                second = n;
            } else if (n < second && n > third) {
                third = n;
            }
        }
        if (third == Long.MIN_VALUE || third == second) return (int) first;
        else return (int) third;
    }


}
