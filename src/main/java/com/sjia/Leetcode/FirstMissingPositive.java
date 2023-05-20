package com.sjia.Leetcode;

public class FirstMissingPositive {
    // #41. First Missing Positive https://leetcode.com/problems/first-missing-positive/

    // Given an unsorted integer array nums, return the smallest missing positive integer.
    // You must implement an algorithm that runs in O(n) time and uses constant extra space.


    // Input: nums = [1,2,0]  Output: 3
    // Input: nums = [3,4,-1,1]  Output: 2
    // Input: nums = [7,8,9,11,12]  Output: 1
    // 1 <= nums.length <= 105
    // -2^31 <= nums[i] <= 2^31 - 1


    // O(N) space
    // failed for Input: nums = [1]  Output: 1
    public int firstMissingPositive(int[] nums) {
        int[] res = new int[nums.length + 1];
        for ( int i : nums) {
            if ( i > 0 && i <= nums.length) {
                res[i] =1;
            }
        }
        for (int i=1 ; i <res.length; i++ ) {
            if (res[i] !=1) {
                return i;
            }
        }
        return nums.length+1;

    }


    public static void main(String[] args) {
        FirstMissingPositive solution = new FirstMissingPositive();
//        int[] nums = {3, 4, -1, 1};
        int[] nums = {3};
        int result = solution.firstMissingPositive(nums);
        System.out.println(result);
    }



}
