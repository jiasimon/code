package com.sjia.Leetcode700;

public class SubarrayProduct {
    //#713. Subarray Product Less Than K    https://leetcode.com/problems/subarray-product-less-than-k/description/
    /*

     */

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;

        int product = 1;
        int count = 0;
        int left = 0;

        // Use a sliding window to find subarrays
        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];

            // If product is greater than or equal to k, shrink the window from the left
            while (product >= k) {
                product /= nums[left];
                left++;
            }

            // All subarrays ending at 'right' with starting points between 'left' and 'right' are valid
            count += (right - left + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        SubarrayProduct solution = new SubarrayProduct();

        // Test Case 1
        int[] nums1 = {10, 5, 2, 6};
        int k1 = 100;
        System.out.println(solution.numSubarrayProductLessThanK(nums1, k1)); // Output: 8

        // Test Case 2
        int[] nums2 = {1, 2, 3};
        int k2 = 0;
        System.out.println(solution.numSubarrayProductLessThanK(nums2, k2)); // Output: 0

        // Test Case 3
        int[] nums3 = {1, 1, 1};
        int k3 = 2;
        System.out.println(solution.numSubarrayProductLessThanK(nums3, k3)); // Output: 6
    }






}
