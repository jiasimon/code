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
    public int firstMissingPositive2(int[] nums) {
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

    // It took 2ms, slower than above 1ms
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // Step 1: Transform the array to satisfy the condition: nums[i] = i + 1
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
            }
        }
        // Step 2: Find the first missing positive number
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        // Step 3: All positive numbers from 1 to n are present, so the first missing positive is n + 1
        return n + 1;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }



    public static void main(String[] args) {
        FirstMissingPositive solution = new FirstMissingPositive();
        int[] nums = {3, 4, -1, 6, 1};
//        int[] nums = {7,8,9,11,12};
        int result = solution.firstMissingPositive(nums);
        System.out.println(result);
    }



}
