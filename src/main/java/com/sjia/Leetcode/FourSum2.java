package com.sjia.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class FourSum2 {
    // #454. 4Sum II    https://leetcode.com/problems/4sum-ii/description/

    /*
    Given four integer arrays nums1, nums2, nums3, and nums4 all of length n, return the number of tuples (i, j, k, l) such that:

    0 <= i, j, k, l < n
    nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
    Input: nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]    Output: 2
    Explanation:
    The two tuples are:
    1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
    2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0

    Input: nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]       Output: 1

    -2^28 <= nums1[i], nums2[i], nums3[i], nums4[i] <= 2^28
     */

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> sumAB = new HashMap<>();
        int count = 0;

        // Calculate sums of pairs from arrays A and B
        for (int a : A) {
            for (int b : B) {
                int sum = a + b;
                sumAB.put(sum, sumAB.getOrDefault(sum, 0) + 1);
            }
        }

        // Check sums of pairs from arrays C and D and find their complements in sumAB
        for (int c : C) {
            for (int d : D) {
                int target = -(c + d);
                if (sumAB.containsKey(target)) {
                    count += sumAB.get(target);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        FourSum2 solution = new FourSum2();
        int[] A = {1, 2};
        int[] B = {-2, -1};
        int[] C = {-1, 2};
        int[] D = {0, 2};
        int count = solution.fourSumCount(A, B, C, D);
        System.out.println("Number of combinations: " + count); // Output: 2
    }
    

}
