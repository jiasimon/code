package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SingleNumberInArray {

    // #136 https://leetcode.com/problems/single-number/

    // leetcode was down for some time today. Runtime: 6 ms, faster than 39.12% of Java online submissions for Single Number.
    //Memory Usage: 40.3 MB, less than 59.60% of Java online submissions for Single Number.

    public int singleNumber(int[] nums) {
        HashSet<Integer> result = new HashSet<>();
        for (int num : nums) {
            if (result.contains(num)) result.remove(num);
            else result.add(num);
        }
        return result.stream().findFirst().get();
    }


    public static void main(String[] args) {

        int[] testData  = {7,1,7,1,6};
        //int[] testData  = {7,6,4,3,1};
        SingleNumberInArray solution = new SingleNumberInArray();

        int result = solution.singleNumber(testData);

        System.out.printf("BuySellStock multi time, testData %s the max profit is %s \n", Arrays.toString(testData),result);
    }

}
