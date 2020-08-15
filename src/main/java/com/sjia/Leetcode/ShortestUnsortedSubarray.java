package com.sjia.Leetcode;

import java.util.Arrays;

public class ShortestUnsortedSubarray {
    // #581 https://leetcode.com/problems/shortest-unsorted-continuous-subarray/

    // Runtime: 6 ms, faster than 54.25% of Java online submissions for Shortest Unsorted Continuous Subarray.
    //Memory Usage: 40.8 MB, less than 63.51% of Java online submissions for Shortest Unsorted Continuous Subarray.
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] tmp = nums.clone();
        Arrays.sort(tmp);
        int i =0, j = n-1;
        for (; i<n; i++ ) {
            if(nums[i] != tmp[i]) break;
        }
        for (; j>=0 && j>i; j-- ) {
            if(nums[j] != tmp[j]) break;
        }

        return j-i+1;

    }


    //Runtime: 6 ms, faster than 54.25% of Java online submissions for Shortest Unsorted Continuous Subarray.
    //Memory Usage: 40.9 MB, less than 52.61% of Java online submissions for Shortest Unsorted Continuous Subarray.
/*
    public int findUnsortedSubarray(int[] nums) {
        int[] tmp = nums.clone();
        Arrays.sort(tmp);
        int start = tmp.length, end = 0;
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] != nums[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        return (end - start >= 0 ? end - start + 1 : 0);
    }*/



    public static void main(String[] args) {
        int[] testData  = {2, 6, 4, 8, 10, 9, 15};
        ShortestUnsortedSubarray solution = new ShortestUnsortedSubarray();
        int result = solution.findUnsortedSubarray(testData);

        System.out.printf(" testData %s , findUnsortedSubarray length is: %s \n", Arrays.toString(testData),result);
    }


}
