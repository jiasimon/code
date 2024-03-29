package com.sjia.Leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class JumpGame7 {
    // #1871. Jump Game VII  https://leetcode.com/problems/jump-game-vii/

    /*
    You are given a 0-indexed binary string s and two integers minJump and maxJump. In the beginning, you are standing at index 0, which is equal to '0'. You can move from index i to index j if the following conditions are fulfilled:

    i + minJump <= j <= min(i + maxJump, s.length - 1), and
    s[j] == '0'.
    Return true if you can reach index s.length - 1 in s, or false otherwise.
     */

    // Input: s = "011010", minJump = 2, maxJump = 3  In the first step, move from index 0 to index 3. In the second step, move from index 3 to index 5.
    // Input: s = "01101110", minJump = 2, maxJump = 3
    // 2 <= s.length <= 10^5 , s[i] is either '0' or '1'. s[0] == '0' , 1 <= minJump <= maxJump < s.length

    public static boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        boolean[] dp = new boolean[n];
        dp[0] = true;

        int prevTrueCount = 0;

        for (int i = 1; i < n; i++) {
            if (i >= minJump && dp[i - minJump]) {
                prevTrueCount++;
            }
            if (i > maxJump && dp[i - maxJump - 1]) {
                prevTrueCount--;
            }
            dp[i] = prevTrueCount > 0 && s.charAt(i) == '0';
        }

        return dp[n - 1];
    }


    // DP,  counting the number of ways
    // i-maxJump  to i-minJump
    // TLE for all 0, long string input
    public static boolean canReach2(String s, int minJump, int maxJump) {
        int n= s.length(), dp[]= new int[n];
        dp[0]= 1;
        for(int i=1; i<n; i++){
            if(s.charAt(i)=='0') {
                for (int j = Math.max(0, i - maxJump), j2 = i - minJump; j <= j2; j++)
                    dp[i] += dp[j];
            }
        }
        return dp[n-1]>0;
    }




    // (Backward) Quadratic DP , flagging instead of counting all ways
    // TLE
    public static boolean canReach3(String s, int minJump, int maxJump) {
        int n= s.length();
        int[] dp= new int[n];
        dp[0]= 1;
        for(int i=1; i<n; i++){
            if(s.charAt(i)=='0') {
                for (int j = Math.max(0, i - maxJump), j2 = i - minJump; j <= j2; j++){
//                    dp[i] += dp[j];
                    if ( dp[j] ==1) {
                        dp[i] = 1;
                        break;
                    }
                }

            }
        }
        return dp[n-1]>0;
    }


    // Runtime 17 ms  Memory 44.7 MB
    // Linear DP, sliding window
    public static boolean canReach4(String s, int minJump, int maxJump) {
        int n= s.length();
        int[] dp= new int[n];
        dp[0]= 1;
        int psDiff = 0;
        for(int i=1; i<n; i++){
            int j = i-maxJump-1, k = i- minJump ;  // i-maxJump-1
            if ( j > -1) {
                psDiff -= dp[j];

            }
            if ( k > -1) {
                psDiff += dp[k];
            }
            if(s.charAt(i)=='0') {
                dp[i]= psDiff > 0 ? 1 : 0;
            }

        }
        return dp[n-1]>0;
    }



    // DP sliding window , boolean array
    // "011010"
    public static boolean canReach5(String s, int minJump, int maxJump) {
        int n = s.length(), pre = 0; // pre: the number of previous position that we can jump from
        boolean[] dp = new boolean[n];
        dp[0] = true;   // other array member default value to false
        for (int i = 1; i < n; ++i) {
            if (i >= minJump && dp[i - minJump]) // i >= minJump  for initial boundary
                pre++;
            if (i > maxJump && dp[i - maxJump - 1])
                pre--;
            dp[i] = ( pre > 0 && s.charAt(i) == '0');
        }
        return dp[n - 1];
    }



    public static void main(String[] args) {
        String s1 = "011010";
//        String s1 = "0110000000010";  // dp[n-1] = 5
        int minJump1 = 2;
        int maxJump1 = 3;
        System.out.println("Can reach the last index: " + canReach5(s1, minJump1, maxJump1)); // Output: true

        String s2 = "01101110";
        int minJump2 = 2;
        int maxJump2 = 3;
        System.out.println("Can reach the last index: " + canReach4(s2, minJump2, maxJump2)); // Output: false

        String s3 = "010010";
        int minJump3 = 1;
        int maxJump3 = 2;
        System.out.println("Can reach the last index: " + canReach4(s3, minJump3, maxJump3)); // Output: true
    }



}
