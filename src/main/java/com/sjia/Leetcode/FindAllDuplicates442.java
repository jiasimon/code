package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllDuplicates442 {
    // #442. Find All Duplicates in an Array https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
    // #interview

    /*
    Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.

    You must write an algorithm that runs in O(n) time and uses only constant extra space.

    Input: nums = [4,3,2,7,8,2,3,1]     Output: [2,3]
    Input: nums = [1,1,2]               Output: [1]
    Input: nums = [1]                   Output: []
     */



    // !seen.add(num)
    // 14 ms, 37.15%; 54.4 MB, 14.81%
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        HashSet<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (!seen.add(num)) {
                result.add(num);
            }
        }

        return result;
    }



    // set.contains(n)
    // 17 ms, 32.71%; 54.5 MB, 12.56%
    public List<Integer> findDuplicates_set(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for ( int n : nums) {
            if( set.contains(n)) {
                res.add(n);
            } else {
                set.add(n);
            }
        }
        return res;

    }


    public static void main(String[] args) {
        FindAllDuplicates442 solution = new FindAllDuplicates442();
        int[] nums = {4, 3, 2, 7, 8, 2, 1};
        List<Integer> duplicates = solution.findDuplicates(nums);
        System.out.println("Duplicates: " + duplicates); // Output: [2]
    }

}
