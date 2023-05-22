package com.sjia.Leetcode;

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


        return dp[n - 1];
    }

    public static void main(String[] args) {
        String s1 = "011010";
        int minJump1 = 2;
        int maxJump1 = 3;
        System.out.println("Can reach the last index: " + canReach(s1, minJump1, maxJump1)); // Output: true

        String s2 = "01101110";
        int minJump2 = 2;
        int maxJump2 = 3;
        System.out.println("Can reach the last index: " + canReach(s2, minJump2, maxJump2)); // Output: false

        String s3 = "010010";
        int minJump3 = 1;
        int maxJump3 = 2;
        System.out.println("Can reach the last index: " + canReach(s3, minJump3, maxJump3)); // Output: false
    }



}
