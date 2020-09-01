package com.sjia.Leetcode;

import java.util.HashMap;

public class TwoSum {

    // #1 TwoSum https://leetcode.com/problems/two-sum/

/*    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; ++i) {
            m.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; ++i) {
            int t = target - nums[i];
            if (m.containsKey(t) && m.get(t) != i) {
                res[0] = i;
                res[1] = m.get(t);
                break;
            }
        }
        return res;
    }*/


    // Runtime: 6 ms, faster than 43.76% of Java online submissions for Two Sum.
    //Memory Usage: 41.7 MB, less than 5.44% of Java online submissions for Two Sum.

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> tmp = new HashMap<>();
        for (int i=0; i< nums.length; i++) {
            if ( tmp.containsKey(target- nums[i]) ) {
                result[1] = i;
                result[0] = tmp.get(target- nums[i]);
                return result;
            } else {
                tmp.put(nums[i], i);
            }
        }
        return result;
    }

/*
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i=0; i< nums.length; i++)
            for (int j=i+1; j< nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] =i;
                    result[1] =j;
                    return result;
                }
            }
        return result;
    }*/


    public static void main(String[] args) {
        int[] testData = { 2, 7, 11, 15, 20, 25, 30 };
        int target = 41;
        TwoSum mySolution = new TwoSum();
        int[] result = mySolution.twoSum(testData, target);
        System.out.println("The result is: " + result[0] + " and " + result[1]);

    }

}
