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
            if (prefix[i-1] > suffix[i]) break;
        }
        return res;

    }


    // int[26]
    // Runtime: 9 ms, faster than 70.68% of Java online submissions for Number of Good Ways to Split a String.
    // Memory Usage: 39.1 MB, less than 85.34% of Java online submissions for Number of Good Ways to Split a String.
    public int numSplits2(String s) {
        int[] l=new int[26], r=new int[26];
        int count_l=0, count_r=0, res=0;
        for (char c: s.toCharArray()){
            ++r[c -'a'];
            if (r[c -'a']==1) count_r++;
        }
        for (int i=0; i < s.length(); i++){
            ++l[s.charAt(i)-'a'];
            if (l[s.charAt(i)-'a']==1) count_l++;
            --r[s.charAt(i) - 'a'];
            if(r[s.charAt(i) - 'a']==0) count_r--;
            if (count_l== count_r) res++;
        }
        return res;

    }


    // Runtime: 7 ms, faster than 79.32% of Java online submissions for Number of Good Ways to Split a String.
    // Memory Usage: 39 MB, less than 89.76% of Java online submissions for Number of Good Ways to Split a String.
    public int numSplits3(String s) {
        int[] l=new int[26], r=new int[26];
        int count_l=0, count_r=0, res=0;
        for (char c: s.toCharArray()){
            if (++r[c -'a']==1) count_r++;
        }
        for (int i=0; i < s.length(); i++){
            if (++l[s.charAt(i)-'a'] == 1) count_l++;
            if (--r[s.charAt(i) - 'a'] ==0) count_r--;
            if (count_l== count_r) res++;
        }
        return res;
    }


}
