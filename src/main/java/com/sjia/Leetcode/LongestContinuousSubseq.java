package com.sjia.Leetcode;

import java.util.Arrays;

public class LongestContinuousSubseq {
    // #674 https://leetcode.com/problems/longest-continuous-increasing-subsequence/
    // 1,2   2,1   1,2,4,3    2,2,2,2

    // Runtime: 1 ms, faster than 99.84% of Java online submissions for Longest Continuous Increasing Subsequence.
    //Memory Usage: 40 MB, less than 86.69% of Java online submissions for Longest Continuous Increasing Subsequence.
    public int findLengthOfLCIS(int[] nums) {
        int result=0, stop=0, i=0;
        for ( i=0; i< nums.length; i++) {
            if ( i>0 && nums[i] <= nums[i-1]) {
                stop = i;
            } else {
                result = Math.max(result, i-stop+1);
            }
        }
        return Math.max(result, i-stop);
    }


    

/*    public int findLengthOfLCIS(int[] nums) {
        int ans = 0, anchor = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i-1] >= nums[i]) anchor = i;
            ans = Math.max(ans, i - anchor + 1);
        }
        return ans;

    }*/


    public static void main(String[] args) {
        //int[] testData  = {2,2,2,2};
        int[] testData  = {2,1};
        LongestContinuousSubseq solution = new LongestContinuousSubseq();
        int result = solution.findLengthOfLCIS(testData);
        System.out.printf("array %s  LongestContinuousSubseq is : %s", Arrays.toString(testData), result);

    }

}
