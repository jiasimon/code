package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RelativeRanks {
    // #506. Relative Ranks     https://leetcode.com/problems/relative-ranks/

    /*
    You are given an integer array score of size n, where score[i] is the score of the ith athlete in a competition. All the scores are guaranteed to be unique.

    The athletes are placed based on their scores, where the 1st place athlete has the highest score, the 2nd place athlete has the 2nd highest score, and so on. The placement of each athlete determines their rank:

    The 1st place athlete's rank is "Gold Medal".
    The 2nd place athlete's rank is "Silver Medal".
    The 3rd place athlete's rank is "Bronze Medal".
    For the 4th place to the nth place athlete, their rank is their placement number (i.e., the xth place athlete's rank is "x").
    Return an array answer of size n where answer[i] is the rank of the ith athlete.

    Input: score = [5,4,3,2,1]      Output: ["Gold Medal","Silver Medal","Bronze Medal","4","5"]
    Input: score = [10,3,8,9,4]     Output: ["Gold Medal","5","Bronze Medal","Silver Medal","4"]

    1 <= n <= 10000,
    0 <= score[i] <= 1000000
    All the values in score are unique.
     */


    // sort
    // 7 ms, 90.9%; 45.2 MB, 17.43%
    public String[] findRelativeRanks(int[] nums) {
        int n = nums.length;
        String[] result = new String[n];

        // Create a copy of the array to sort
        int[] sorted = Arrays.copyOf(nums, n);
        Arrays.sort(sorted);

        // Create a map to store ranks
        Map<Integer, Integer> rankMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            rankMap.put(sorted[i], n - i);
        }

        for (int i = 0; i < n; i++) {
            int rank = rankMap.get(nums[i]);

            if (rank == 1) {
                result[i] = "Gold Medal";
            } else if (rank == 2) {
                result[i] = "Silver Medal";
            } else if (rank == 3) {
                result[i] = "Bronze Medal";
            } else {
                result[i] = String.valueOf(rank);
            }
        }

        return result;
    }



    public static void main(String[] args) {
        RelativeRanks solution = new RelativeRanks();

        int[] nums = {5, 4, 3, 2, 1};

        String[] ranks = solution.findRelativeRanks(nums);
        System.out.println("Relative Ranks: " + Arrays.toString(ranks));
    }

}
