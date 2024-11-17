package com.sjia.Leetcode700;

import java.util.Arrays;

public class KthSmallestPair {
    // #719. Find K-th Smallest Pair Distance   https://leetcode.com/problems/find-k-th-smallest-pair-distance/description/

    /*
    Sorting:

    Sort the array nums to easily find the pair distances.

    Binary Search on Distance:

        We are interested in the k-th smallest distance, so we use binary search on the possible distances.
        The minimum possible distance is 0 (when two elements are the same), and the maximum possible distance is nums[n-1] - nums[0] (when comparing the smallest and largest element).

    Counting Pairs with Two Pointers:

        For a given mid (distance), count how many pairs have a distance less than or equal to mid.
        If the count is greater than or equal to k, it means the k-th smallest distance is less than or equal to mid.

    Adjusting the Binary Search:

        If the count is sufficient, reduce the upper bound.
        If not, increase the lower bound.
     */

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0;
        int right = nums[n - 1] - nums[0];

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Count how many pairs have a distance <= mid
            int count = countPairs(nums, mid);

            // If count >= k, reduce the upper bound
            if (count >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private int countPairs(int[] nums, int mid) {
        int count = 0;
        int n = nums.length;
        int left = 0;

        // Use two pointers to count pairs with distance <= mid
        for (int right = 0; right < n; right++) {
            while (nums[right] - nums[left] > mid) {
                left++;
            }
            count += right - left;
        }

        return count;
    }

    public static void main(String[] args) {
        KthSmallestPair solution = new KthSmallestPair();

        // Test Case 1
        int[] nums1 = {1, 3, 1};
        int k1 = 1;
        System.out.println(solution.smallestDistancePair(nums1, k1)); // Output: 0

        // Test Case 2
        int[] nums2 = {1, 6, 1};
        int k2 = 3;
        System.out.println(solution.smallestDistancePair(nums2, k2)); // Output: 5

        // Test Case 3
        int[] nums3 = {1, 2, 3, 4};
        int k3 = 5;
        System.out.println(solution.smallestDistancePair(nums3, k3)); // Output: 2
    }


}
