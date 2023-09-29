package com.sjia.Leetcode;

public class MonotonicArray896 {
    // #896. Monotonic Array    https://leetcode.com/problems/monotonic-array/description/?envType=daily-question&envId=2023-09-29
    /*
    An array is monotonic if it is either monotone increasing or monotone decreasing.

    An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j]. An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].

    Given an integer array nums, return true if the given array is monotonic, or false otherwise.

    Input: nums = [1,2,2,3]     Output: true
    Input: nums = [6,5,4,4]     Output: true
    Input: nums = [1,3,2]       Output: false
     */


    public boolean isMonotonic(int[] A) {
        int n = A.length;
        boolean increasing = false; // Indicates if it's a non-decreasing sequence
        boolean decreasing = false; // Indicates if it's a non-increasing sequence

        for (int i = 1; i < n; i++) {
            if (A[i] > A[i - 1]) {
                increasing = true;
            } else if (A[i] < A[i - 1]) {
                decreasing = true;
            }

            // If both increasing and decreasing flags are set, it's not monotonic
            if (increasing && decreasing) {
                return false;
            }
        }

        // If either flag is set, it's monotonic
        return true;
    }

    public static void main(String[] args) {
        MonotonicArray solution = new MonotonicArray();
        int[] A1 = {1, 2, 2, 3};
        int[] A2 = {6, 5, 4, 4};
        int[] A3 = {1, 3, 2};

        System.out.println(solution.isMonotonic(A1)); // Output: true
        System.out.println(solution.isMonotonic(A2)); // Output: true
        System.out.println(solution.isMonotonic(A3)); // Output: false
    }
}
