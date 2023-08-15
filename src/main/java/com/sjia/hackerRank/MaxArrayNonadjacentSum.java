package com.sjia.hackerRank;

public class MaxArrayNonadjacentSum {
    // https://www.hackerrank.com/challenges/max-array-sum/problem?isFullScreen=true&h_l=interview&playlist_slugs[]=interview-preparation-kit&playlist_slugs[]=dynamic-programming

    static int maxSubsetSum(int[] arr) {
        int n = arr.length;

        if ( n==0) return 0;

        if ( n==1) return Math.max(0, arr[0]);

        int[] dp = new int[n];
        dp[0] = Math.max(0, arr[0]);
        dp[1] = Math.max(dp[0], arr[1]);


        for ( int i=2; i < n; i++) {
            dp[i] = Math.max(dp[i-2]+arr[i], dp[i-1]);
        }

        return  Math.max(dp[n-1], dp[n-2]);

    }

    public static void main(String[] args) {
        int[] test1 = {-2,1,3,-4,5};
        int result = maxSubsetSum(test1);
        System.out.println(test1 + " MaxArrayNonadjacentSum : " + result);
    }



}
