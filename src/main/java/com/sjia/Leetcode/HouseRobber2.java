package com.sjia.Leetcode;

public class HouseRobber2 {
    // #213. House Robber II    https://leetcode.com/problems/house-robber-ii/
    /*
    All houses at this place are arranged in a circle.
    and it will automatically contact the police if two adjacent houses were broken into on the same night.

    Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

    Input: nums = [2,3,2]   Output: 3
    Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.

     */


    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // If there's only one house, we can only rob that house
        if (nums.length == 1) {
            return nums[0];
        }

        // We split the problem into two cases:
        // Case 1: Rob houses from index 0 to n-2
        // Case 2: Rob houses from index 1 to n-1
        // The maximum result will be the larger value between the two cases

        int maxCase1 = robHelper(nums, 0, nums.length - 2);
        int maxCase2 = robHelper(nums, 1, nums.length - 1);

        return Math.max(maxCase1, maxCase2);
    }

    private int robHelper(int[] nums, int start, int end) {
        int prevMax = 0;
        int currMax = 0;

        for (int i = start; i <= end; i++) {
            int temp = currMax;
            currMax = Math.max(currMax, prevMax + nums[i]);
            prevMax = temp;
        }

        return currMax;
    }

    // Test the code
    public static void main(String[] args) {
        HouseRobber2 houseRobberII = new HouseRobber2();

        int[] nums1 = {2, 3, 2}; // The maximum amount we can rob is 3 (either house 1 or house 3).
        int result1 = houseRobberII.rob(nums1);
        System.out.println("Maximum amount that can be robbed: " + result1);

        int[] nums2 = {1, 2, 3, 1}; // The maximum amount we can rob is 4 (house 1 + house 3).
        int result2 = houseRobberII.rob(nums2);
        System.out.println("Maximum amount that can be robbed: " + result2);
    }


}
