package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class MajorityElement {

    // #169 https://leetcode.com/problems/majority-element/

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


    // Runtime: 3 ms, faster than 62.79% of Java online submissions for Majority Element.
    //Memory Usage: 50.6 MB, less than 5.06% of Java online submissions for Majority Element.
/*
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }*/



    // Runtime: 1 ms, faster than 99.89% of Java online submissions for Majority Element.
    //Memory Usage: 42.9 MB, less than 57.33% of Java online submissions for Majority Element.
    public int majorityElement(int[] nums) {
        int count =0, tmp=0;
        for (int num: nums) {
            if (count ==0) tmp =num;
            count += (num == tmp) ? 1:-1;
        }
        return tmp;

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
