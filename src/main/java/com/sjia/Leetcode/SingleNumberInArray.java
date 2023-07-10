package com.sjia.Leetcode;

import java.util.*;

public class SingleNumberInArray {

    // #136. Single Number  https://leetcode.com/problems/single-number/
    /*
    Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
    You must implement a solution with a linear runtime complexity and use only constant extra space.
    Input: nums = [2,2,1]   Output: 1
    Input: nums = [4,1,2,1,2]   Output: 4

     */

    // leetcode was down for some time today. Runtime: 6 ms, faster than 39.12% of Java online submissions for Single Number.
    //Memory Usage: 40.3 MB, less than 59.60% of Java online submissions for Single Number.
/*
    public int singleNumber(int[] nums) {
        HashSet<Integer> result = new HashSet<>();
        for (int num : nums) {
            if (result.contains(num)) result.remove(num);
            else result.add(num);
        }
        return result.stream().findFirst().get();
    }*/


    //Runtime: 1 ms, faster than 73.39% of Java online submissions for Single Number.
    //Memory Usage: 43.6 MB, less than 5.10% of Java online submissions for Single Number.

    public int singleNumber(int[] nums) {
        int result =0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }


    // sort, 6 ms, 42.20%; 44.7 MB, 49.4%
    public int singleNumberSort(int[] nums) {
        Arrays.sort(nums);
        for (int i=1; i< nums.length; i+=2){
            if(nums[i] != nums[i-1]) {
                return nums[i-1];
            }
        }
        return nums[nums.length-1];
    }


    // HashMap
    // 12 ms, 27.77%; 44.1 MB, 74.24%
    public int singleNumberHashMap(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            if(hashMap.containsKey(num)) {
                hashMap.put(num,2);
            } else {
                hashMap.put(num,1);
            }
        }

        for(Map.Entry<Integer, Integer> set : hashMap.entrySet()) {
            if (set.getValue() == 1) {
                return set.getKey();
            }
        }
        return -1;
    }


    public static void main(String[] args) {

        int[] testData  = {7,1,7,1,6};
        //int[] testData  = {7,6,4,3,1};
        SingleNumberInArray solution = new SingleNumberInArray();

        int result = solution.singleNumberHashMap(testData);

        System.out.printf(" array testData %s the singleNumberis %s \n", Arrays.toString(testData),result);
    }

}
