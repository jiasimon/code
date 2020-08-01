package com.sjia.Leetcode;

import java.util.stream.Stream;

public class MissingNumber {
    // #268 https://leetcode.com/problems/missing-number/

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Missing Number.
    //Memory Usage: 40.4 MB, less than 8.72% of Java online submissions for Missing Number.
 /*
    public int missingNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result += num;
        }
        return (nums.length + 1) * nums.length/2 - result;
    }*/


    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Missing Number.
    //Memory Usage: 39.8 MB, less than 77.76% of Java online submissions for Missing Number.
    public int missingNumber(int[] nums) {
        int result = nums.length;
        for (int i = 0 ; i < nums.length; i++) {
            result += i-nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] testData = { 9,6,4,2,3,5,7,0,1 };
        MissingNumber solution = new MissingNumber();
        int result = solution.missingNumber(testData);
        System.out.println("The result is: " +  result);

    }

}
