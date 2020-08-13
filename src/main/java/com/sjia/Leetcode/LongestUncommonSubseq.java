package com.sjia.Leetcode;

public class LongestUncommonSubseq {
    // #521 https://leetcode.com/problems/longest-uncommon-subsequence-i/

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Longest Uncommon Subsequence I .
    //Memory Usage: 37.3 MB, less than 64.94% of Java online submissions for Longest Uncommon Subsequence I .
    public int findLUSlength(String a, String b) {
        if (a.length() != b.length()) return Math.max(a.length(), b.length());
        else if (a.equals(b) ) return -1;
        else return a.length();
    }

}
