package com.sjia.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class KDiffPairs {
    // #532. K-diff Pairs in an Array   https://leetcode.com/problems/k-diff-pairs-in-an-array/description/

    /*
    Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.

    A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:

    0 <= i, j < nums.length
    i != j
    |nums[i] - nums[j]| == k
    Notice that |val| denotes the absolute value of val.

    Input: nums = [3,1,4,1,5], k = 2    Output: 2
    Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
    Although we have two 1s in the input, we should only return the number of unique pairs.

    Input: nums = [1,2,3,4,5], k = 1    Output: 4

    Input: nums = [1,3,1,5,4], k = 0    Output: 1
    Explanation: There is one 0-diff pair in the array, (1, 1).

    1 <= nums.length <= 10000
    -10^7 <= nums[i] <= 10^7
    0 <= k <= 10^7
     */


    // k==0 , Map.Entry<Integer, Integer>
    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0;

        Map<Integer, Integer> countMap = new HashMap<>();
        int pairsCount = 0;

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();

            if (k == 0) {
                if (count > 1) {
                    pairsCount++;
                }
            } else {
                if (countMap.containsKey(num + k)) {
                    pairsCount++;
                }
            }
        }

        return pairsCount;
    }

    public static void main(String[] args) {
        KDiffPairs solution = new KDiffPairs();

        int[] nums = {3, 1, 4, 1, 5};
        int k = 2;

        int pairsCount = solution.findPairs(nums, k);
        System.out.println("Number of k-diff pairs in the array: " + pairsCount);
    }
}
