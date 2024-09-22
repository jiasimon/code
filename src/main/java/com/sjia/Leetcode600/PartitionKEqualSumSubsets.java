package com.sjia.Leetcode600;

import java.util.Arrays;

public class PartitionKEqualSumSubsets {
    // #698. Partition to K Equal Sum Subsets   https://leetcode.com/problems/partition-to-k-equal-sum-subsets/description/
    /*
    Input: nums = [4,3,2,3,5,2,1], k = 4        Output: true
    4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.

    Input: nums = [1,2,3,4], k = 3              Output: false

    1 <= k <= nums.length <= 16
    1 <= nums[i] <= 10^4

     */


    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;  // If the sum is not divisible by k, return false

        int target = sum / k;  // The target sum for each subset
        boolean[] visited = new boolean[nums.length];  // Track visited elements
        Arrays.sort(nums);  // Sorting helps optimization by starting from larger elements
        return backtrack(nums, visited, k, 0, 0, target);
    }

    private boolean backtrack(int[] nums, boolean[] visited, int k, int currentSum, int startIndex, int target) {
        // If k == 0, it means we've successfully created k subsets with the required sum
        if (k == 0) return true;

        // If current subset's sum equals the target, move on to the next subset
        if (currentSum == target) return backtrack(nums, visited, k - 1, 0, 0, target);

        // Try to assign numbers to the current subset
        for (int i = startIndex; i < nums.length; i++) {
            if (!visited[i] && currentSum + nums[i] <= target) {
                // Mark the element as visited and try to form a valid subset
                visited[i] = true;
                if (backtrack(nums, visited, k, currentSum + nums[i], i + 1, target)) {
                    return true;
                }
                // Unmark the element for backtracking
                visited[i] = false;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        PartitionKEqualSumSubsets solution = new PartitionKEqualSumSubsets();

        // Test case 1
        int[] nums1 = {4, 3, 2, 3, 5, 2, 1};
        int k1 = 4;
        System.out.println("Test case 1: " + solution.canPartitionKSubsets(nums1, k1));  // Expected output: true

        // Test case 2
        int[] nums2 = {1, 2, 3, 4};
        int k2 = 3;
        System.out.println("Test case 2: " + solution.canPartitionKSubsets(nums2, k2));  // Expected output: false

        // Test case 3
        int[] nums3 = {2, 2, 2, 2, 3, 4, 5};
        int k3 = 4;
        System.out.println("Test case 3: " + solution.canPartitionKSubsets(nums3, k3));  // Expected output: false

        // Test case 4
        int[] nums4 = {1, 1, 1, 1, 1, 1, 1, 1};
        int k4 = 4;
        System.out.println("Test case 4: " + solution.canPartitionKSubsets(nums4, k4));  // Expected output: true
    }


}
