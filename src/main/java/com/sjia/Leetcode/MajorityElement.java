package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class MajorityElement {

    // #169. Majority Element https://leetcode.com/problems/majority-element/

    // Runtime: 4 ms, faster than 54.89% of Java online submissions for Majority Element.
    //Memory Usage: 51.1 MB, less than 5.06% of Java online submissions for Majority Element.
/*
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        for (int i=1; i< nums.length ; i++) {
            if (nums[i] == nums[i-1]) {
                count++;
                if (count >= nums.length/2+1)
                    return nums[i];
            } else {
                count=1;
            }
        }
        return nums[nums.length-1];
    }*/



    // Arrays.sort
    // 3 ms, 51.17%; 48.6 MB, 49.41%
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }



    // Moore Voting Algorithm
    // 1 ms, 99.79% ; 48.8 MB, 32.62%
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }





    public static void main(String[] args) {
        // int[] testData = { 2,2,1,1,1,2,2 };
        // int[] testData = { 3,3,4};
        int[] testData = { 3,4,4};
        MajorityElement mySolution = new MajorityElement();
        int result = mySolution.majorityElement(testData);
        System.out.printf("The majority of testData %s is: %s" , Arrays.toString(testData),result );

    }

}
