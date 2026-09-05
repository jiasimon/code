package com.sjia.hackerRank2026;

import java.util.Arrays;
import java.util.List;

public class CandiesMin {
    // https://www.hackerrank.com/challenges/candies/problem

    // dp, left to right , right to left
    public static long candies(int n, List<Integer> arr) {
        // Write your code here
        int[] dp = new int[arr.size()];

        Arrays.fill(dp, 1);
//        for (int i=0; i<arr.size(); i++ ){
//            dp[i] = 1;
//        }

        for (int i=1; i< arr.size(); i++) {
            if (arr.get(i) > arr.get(i-1)){
                dp[i] = dp[i-1] + 1;
            }
        }
        for (int i=arr.size()-2; i>=0; i--) {
            if (arr.get(i)>arr.get(i+1)) {
                dp[i] = Math.max(dp[i],dp[i+1]+1);
            }
        }

        long res=0;
        for (int d: dp){
            res += d;
        }
        return res;
    }

}
