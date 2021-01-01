package com.sjia.Leetcode;

import java.util.HashSet;
import java.util.Set;

public class NumberGoodSplitString {
    // #1525    https://leetcode.com/problems/number-of-good-ways-to-split-a-string/

    // a split is called good if you can split s into 2 non-empty strings p and q
    // where its concatenation is equal to s and the number of distinct letters in p and q are the same.

    // Input: s = "aacaba"  Output: 2
    // ("aac", "aba") Left string and right string contains 2 and 2 different letters respectively (good split).
    // ("aaca", "ba") Left string and right string contains 2 and 2 different letters respectively (good split).

    // s contains only lowercase English letters.
    //1 <= s.length <= 10^5

    // prefix and suffix, 3 loop
    // Runtime: 15 ms, faster than 57.83% of Java online submissions for Number of Good Ways to Split a String.
    // Memory Usage: 39.4 MB, less than 74.10% of Java online submissions for Number of Good Ways to Split a String.
    public int numSplits(String s) {
        Set<Character> tmp = new HashSet<>();
        int res=0;

        int n = s.length();
        int[] prefix = new int[n], suffix = new int[n];

        for (int i=0; i<n; i++) {
            tmp.add(s.charAt(i));
            prefix[i] = tmp.size();
        }
        tmp.clear();

        for (int i=n-1; i>=0; i--) {
            tmp.add(s.charAt(i));
            suffix[i] = tmp.size();
        }

        for (int i=1; i<n-1; i++) {
            if (prefix[i-1] == suffix[i]) res++;
        }
        return res;

    }


}
