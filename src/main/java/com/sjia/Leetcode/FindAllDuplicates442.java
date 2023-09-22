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



    // nums[x - 1] = -nums[x - 1]
    // 5 ms, 95.34%; 52.9 MB, 92.99%
    public List<Integer> findDuplicates_negative(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i) {
            int x = Math.abs(nums[i]);
            if (nums[x - 1] > 0) {
                nums[x - 1] = -nums[x - 1];
            } else {
                res.add(x);
            }
        }
        return res;

    }



    // swap nums[i]  to value -1 position
    public List<Integer> findDuplicates_swap(int[] nums) {

        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            while (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i) {
            if (nums[i] - 1 != i) {
                ans.add(nums[i]);
            }
        }
        return ans;
    }

    public void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        FindAllDuplicates442 solution = new FindAllDuplicates442();
        int[] nums = {4, 3, 2, 7, 8, 2, 1};
        List<Integer> duplicates = solution.findDuplicates(nums);
        System.out.println("Duplicates: " + duplicates); // Output: [2]
    }

}
