package com.sjia.Leetcode;

import java.util.Arrays;

public class MaxElementAfterDecreasing {
    // #1846. Maximum Element After Decreasing and Rearranging
    // https://leetcode.com/problems/maximum-element-after-decreasing-and-rearranging/

    /*
    You are given an array of positive integers arr. Perform some operations (possibly none) on arr so that it satisfies these conditions:

    The value of the first element in arr must be 1.
    The absolute difference between any 2 adjacent elements must be less than or equal to 1. In other words, abs(arr[i] - arr[i - 1]) <= 1 for each i where 1 <= i < arr.length (0-indexed). abs(x) is the absolute value of x.
    There are 2 types of operations that you can perform any number of times:

    Decrease the value of any element of arr to a smaller positive integer.
    Rearrange the elements of arr to be in any order.
    Return the maximum possible value of an element in arr after performing the operations to satisfy the conditions.

    Input: arr = [2,2,1,2,1]    Output: 2
    Input: arr = [100,1,1000]   Output: 3
    Input: arr = [1,2,3,4,5]    Output: 5

     */


    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        arr[0] = 1; // Ensure the first element is 1

        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1] + 1) {
                arr[i] = arr[i - 1] + 1;
            }
        }

        return arr[n - 1];
    }


    public static void main(String[] args) {
        MaxElementAfterDecreasing solution = new MaxElementAfterDecreasing();
        int[] arr = {2, 2, 1, 2, 1};

        int result = solution.maximumElementAfterDecrementingAndRearranging(arr);
        System.out.println("Maximum Element: " + result);  // 2
    }
}
