package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class ContainsDuplicateK {
    // #219 https://leetcode.com/problems/contains-duplicate-ii/
    // there are two distinct indices i and j in the array
    // such that nums[i] = nums[j] and the absolute difference between i and j is at most k


    // Runtime: 6 ms, faster than 76.44% of Java online submissions for Contains Duplicate II.
    //Memory Usage: 43.2 MB, less than 56.72% of Java online submissions for Contains Duplicate II.
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> tmp = new HashSet<>();
        for (int i=0; i< nums.length; i++) {
            if(tmp.contains(nums[i])) return true;
            else tmp.add(nums[i]);
            if (tmp.size() > k ) tmp.remove(nums[i-k]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] testData  = {1,2,3,1,2,3};
        int k =2;
        ContainsDuplicateK solution = new ContainsDuplicateK();
        boolean result = solution.containsNearbyDuplicate(testData, k);
        System.out.printf("array %s  in %s contain duplicate : %s", Arrays.toString(testData), k, result);

    }



}