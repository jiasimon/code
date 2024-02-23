package com.sjia.Leetcode;

public class SingleElementInSortedArray {
    // #540. Single Element in a Sorted Array   https://leetcode.com/problems/single-element-in-a-sorted-array/description/

    /*
    You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

    Return the single element that appears only once.

    Your solution must run in O(log n) time and O(1) space.

    Input: nums = [1,1,2,3,3,4,4,8,8]       Output: 2
    Input: nums = [3,3,7,7,10,11,11]        Output: 10

    1 <= nums.length <= 10^5
    0 <= nums[i] <= 10^5
     */



    // unsorted array, xor
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length ;
        int res = nums[0];
        for (int i=1; i < n; i++) {
            res = res ^ nums[i];
        }
        return res;
    }


    public static void main(String[] args) {
        SingleElementInSortedArray solution = new SingleElementInSortedArray();

        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        int singleElement = solution.singleNonDuplicate(nums);
        System.out.println("Single element in the sorted array: " + singleElement);
    }

}
