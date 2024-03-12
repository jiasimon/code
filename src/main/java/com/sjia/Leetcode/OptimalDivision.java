package com.sjia.Leetcode;

public class OptimalDivision {
    // #553. Optimal Division   https://leetcode.com/problems/optimal-division/description/
    /*
    You are given an integer array nums. The adjacent integers in nums will perform the float division.
	• For example, for nums = [2,3,4], we will evaluate the expression "2/3/4".
    However, you can add any number of parenthesis at any position

    Input: nums = [1000,100,10,2]       Output: "1000/(100/10/2)"

    Input: nums = [2,3,4]       Output: "2/(3/4)"

    1 <= nums.length <= 10
    2 <= nums[i] <= 1000
     */

    public String optimalDivision(int[] nums) {
        int n = nums.length;
        if (n == 1) return Integer.toString(nums[0]);
        if (n == 2) return nums[0] + "/" + nums[1];

        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]).append("/(").append(nums[1]);
        for (int i = 2; i < n; i++) {
            sb.append("/").append(nums[i]);
        }
        sb.append(")");
        return sb.toString();
    }

    public static void main(String[] args) {
        OptimalDivision solution = new OptimalDivision();
        int[] test1 = {1000, 100, 10, 2};
        int[] test2 = {5, 2, 6, 3};

        System.out.println("Test Case 1: " + solution.optimalDivision(test1)); // Output: "1000/(100/10/2)"
        System.out.println("Test Case 2: " + solution.optimalDivision(test2)); // Output: "5/(2/6/3)"
    }
}
