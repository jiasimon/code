package com.sjia.Leetcode;

import java.util.*;

public class KdiffPairsInArray {
    // #532. K-diff Pairs in an Array   https://leetcode.com/problems/k-diff-pairs-in-an-array/description/
    /*
    Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.

    A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:

    0 <= i, j < nums.length
    i != j
    |nums[i] - nums[j]| == k

    Input: nums = [3,1,4,1,5], k = 2    Output: 2
    Input: nums = [1,2,3,4,5], k = 1    Output: 4
    Input: nums = [1,3,1,5,4], k = 0    Output: 1

    Note: Although we have two 1s in the input, we should only return the number of unique pairs.
     */


    // k==0 , Map.Entry<Integer, Integer>
    // 12ms, 34.03%; 44.32mb, 33.55%
    public int findPairs(int[] nums, int k) {
        int res = 0;
        if ( k < 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        for ( int n : nums) {
            map.put(n, map.getOrDefault(n,0) + 1);
        }

        if ( k == 0) {
            for (  Map.Entry<Integer, Integer> entry :  map.entrySet()) {
                if( entry.getValue() > 1) {
                    res++;
                }
            }
            return res;
        } else {
            for ( Map.Entry<Integer, Integer> entry: map.entrySet() ) {
                if (map.containsKey(entry.getKey() + k)) {
                    res++;
                }
            }
        }
        return res;

    }





    // two HashSets
    // 9ms, 72.33%; 45.34mb, 6.41%
    public int findPairs_TwoSets(int[] nums, int k) {
        Set<Integer> visited = new HashSet<Integer>();
        Set<Integer> res = new HashSet<Integer>();
        for (int num : nums) {
            if (visited.contains(num - k)) {
                res.add(num - k);
            }
            if (visited.contains(num + k)) {
                res.add(num);
            }
            visited.add(num);
        }
        return res.size();
    }



    // sort , binary search
    public int findPairs_binarySearch(int[] nums, int k) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();

        int n = nums.length;
        for ( int i = 0 ; i < n; i++) {
            if (Arrays.binarySearch(nums, i+1, n, nums[i] + k) > 0 ) {
                set.add(nums[i]);
            }
        }

        return set.size();

    }


    public static void main(String[] args) {
        KdiffPairsInArray solution = new KdiffPairsInArray();
        int[] nums = {3, 1, 4, 1, 5};
        int k = 2;
        int pairsCount = solution.findPairs(nums, k);
        System.out.println("Count of K-diff pairs: " + pairsCount); // Output: 2
    }


}
