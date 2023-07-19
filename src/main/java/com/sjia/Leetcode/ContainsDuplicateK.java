package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class ContainsDuplicateK {
    // #219. Contains Duplicate II  https://leetcode.com/problems/contains-duplicate-ii/

    /*
    there are two distinct indices i and j in the array
    such that nums[i] = nums[j] and the absolute difference between i and j is at most k

    Input: nums = [1,2,3,1], k = 3  Output: true
    Input: nums = [1,0,1,1], k = 1  Output: true
    Input: nums = [1,2,3,1,2,3], k = 2  Output: false

     */



    // Runtime: 6 ms, faster than 76.44% of Java online submissions for Contains Duplicate II.
    //Memory Usage: 43.2 MB, less than 56.72% of Java online submissions for Contains Duplicate II.
/*
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> tmp = new HashSet<>();
        for (int i=0; i< nums.length; i++) {
            if(tmp.contains(nums[i])) return true;
            else tmp.add(nums[i]);
            if (tmp.size() > k ) tmp.remove(nums[i-k]);
        }
        return false;
    }*/


    // Runtime: 10 ms, faster than 46.12% of Java online submissions for Contains Duplicate II.
    //Memory Usage: 50.4 MB, less than 5.47% of Java online submissions for Contains Duplicate II.
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> tmp = new HashMap<>();
        for (int i=0; i< nums.length; i++) {
            if (!tmp.containsKey(nums[i])) tmp.put(nums[i], i);
            else if(tmp.containsKey(nums[i]) &&  i - tmp.get(nums[i]) <= k ) return true;
            else tmp.put(nums[i], i);
        }
        return false;
    }



    public static void main(String[] args) {
        int[] testData  = {1,2,3,1,2,3};
        int k =2;
        ContainsDuplicateK solution = new ContainsDuplicateK();
        boolean result = solution.containsNearbyDuplicate(testData, k);
        System.out.printf("array %s  in %s contain duplicate : %s", Arrays.toString(testData), k, result);
        System.out.println();

        int[] nums2 = {1, 0, 1, 1}; // true, since 1 and 1 are duplicates and their distance is 3 - 2 = 1 <= 1 (k).
        System.out.println(solution.containsNearbyDuplicate(nums2, 1));

        int[] nums3 = {1, 2, 3, 4, 5}; // false, no duplicates with distance <= 3 (k).
        System.out.println(solution.containsNearbyDuplicate(nums3, 3));

    }



}
