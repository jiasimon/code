package com.sjia.hackerRank2026;

public class ArrayMinRemovalsForTargetSum {
    // give int[] and a target, remove either left most or right most, find the minimum removal

        // totalSum - k,  
        public static int minOperations(int[] nums, int k) {
            int totalSum = 0;
            int n = nums.length;

            for (int num : nums) {
                totalSum += num;
            }

            // The sum of the remaining middle subarray needed
            int targetSubarraySum = totalSum - k;

            // If target is less than 0, k is larger than the total array sum
            if (targetSubarraySum < 0) {
                return -1;
            }

            // If targetSubarraySum is 0,  must remove all elements
            if (targetSubarraySum == 0) {
                return n;
            }

            int maxLen = -1;

            for (int i = 0; i < n; i++) {
                int currentSum = 0;

                for (int j = i; j < n; j++) {
                    currentSum += nums[j];

                    // If we find a matching sum, update the maximum length
                    if (currentSum == targetSubarraySum) {
                        maxLen = Math.max(maxLen, j - i + 1);
                    }
                }
            }

            // 4. Minimum removals = total length - maximum remaining window length
            return maxLen == -1 ? -1 : n - maxLen;


        }

        public static void main(String[] args) {
            int[] arr1 = {3, 4, 1, 3, 2};
            int k1 = 5;
            System.out.println("Result: " + minOperations(arr1, k1)); // Output: 2

            int[] arr2 = {1, 1, 3, 1, 2};
            int k2 = 4;
            System.out.println("Result: " + minOperations(arr2, k2)); // Output: 3

            int[] arr3 = {5, 4, 1, 3, 2};
            int k3 = 5;
            System.out.println("Result: " + minOperations(arr3, k3)); // Output: 1
        }

}
