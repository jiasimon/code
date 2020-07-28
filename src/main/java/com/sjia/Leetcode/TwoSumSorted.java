package com.sjia.Leetcode;

import java.util.HashMap;

public class TwoSumSorted {

    // #167 https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

    // Runtime: 3 ms, faster than 20.18% of Java online submissions for Two Sum II - Input array is sorted.
    //Memory Usage: 39.8 MB, less than 20.92% of Java online submissions for Two Sum II - Input array is sorted.
/*
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> tmp = new HashMap<>();
        for (int i = 0 ; i< numbers.length; i++) {
            if (tmp.containsKey(target - numbers[i])) {
                result[1] = i+1;
                result[0] = tmp.get(target - numbers[i])+1;
            } else {
                tmp.put(numbers[i],i);
            }
        }
        return result;
    }*/


    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Two Sum II - Input array is sorted.
    //Memory Usage: 39.8 MB, less than 15.38% of Java online submissions for Two Sum II - Input array is sorted.
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int left = 0, right = numbers.length-1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                result[0] = left +1;
                result[1] = right +1;
                return result;
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] testData = { 2, 7, 11, 15, 20, 25, 30 };
        int target = 41;
        TwoSumSorted mySolution = new TwoSumSorted();
        int[] result = mySolution.twoSum(testData, target);
        System.out.println("The result is: " + result[0] + " and " + result[1]);

    }

}
