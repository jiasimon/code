package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SingleNumber3 {
    // #260. Single Number III  https://leetcode.com/problems/single-number-iii/
    /*
    Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice.
    Find the two elements that appear only once. You can return the answer in any order.

    You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.
     */


    // Set contains and remove
    // 4ms, 46.96%; 44.69mb, 19.80%
    public int[] singleNumber2(int[] nums) {
        int[] res = new int[2];
        Set<Integer> set = new HashSet<>();
        for (int n: nums) {
            if (set.contains(n)) {
                set.remove(n);
            } else {
                set.add(n);
            }
        }

        // convert Set of Integers to int[]
        int i = 0;
        for (int num : set) {
            res[i++] = num;
        }
        return res;
    }


    // Hashset, !set.add(n), set to list to int[]
    // 4ms, 46.96%, 44.54mb, 34.58%
    public int[] singleNumberHashSet(int[] nums) {
        int[] res = new int[2];
        Set<Integer> tmp = new HashSet<>();
        for (int n : nums) {
            if (!tmp.add(n)) {
                tmp.remove(n);
            }
        }
        List list = new ArrayList<>(tmp);
        res[0] = (int)list.get(0);
        res[1] = (int)list.get(1);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 2, 5};
        SingleNumber3 solution = new SingleNumber3();
        int[] result = solution.singleNumberHashSet(nums);
        System.out.println("The two distinct numbers are: " + result[0] + " and " + result[1]);
        // Output: The two distinct numbers are: 3 and 5
    }
}
