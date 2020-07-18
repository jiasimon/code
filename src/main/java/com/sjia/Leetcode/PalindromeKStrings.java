package com.sjia.Leetcode;

import java.util.HashSet;
import java.util.Set;

public class PalindromeKStrings {

    // #1400 Construct K Palindrome Strings
    // https://leetcode.com/problems/construct-k-palindrome-strings/

    // 1 <= s.length <= 10^5
    //All characters in s are lower-case English letters.
    //1 <= k <= 10^5
    // yzyzyzyzyzyzyzy 2   ; true 4 ; leetcode 3


    // hashset, Runtime: 33 ms, faster than 15.81% of Java online submissions for Construct K Palindrome Strings.
    //Memory Usage: 40.2 MB, less than 54.39% of Java online submissions for Construct K Palindrome Strings.

/*
    public boolean canConstruct(String s, int k) {
        if (k > s.length()) return false;
        Set<Character> tmp = new HashSet<>();
        for (int i=0; i < s.length(); i++){
            if (!tmp.contains(s.charAt(i))) tmp.add(s.charAt(i));
            else tmp.remove(s.charAt(i));
        }
        int left = Math.max(1, tmp.size());
        return k>= left;
    }*/


    // Array for lowercase
    // Runtime: 13 ms, faster than 41.24% of Java online submissions for Construct K Palindrome Strings.
    //Memory Usage: 40.2 MB, less than 45.61% of Java online submissions for Construct K Palindrome Strings.

    // second run, Runtime: 13 ms, faster than 41.24% of Java online submissions for Construct K Palindrome Strings.
    //Memory Usage: 39.9 MB, less than 76.61% of Java online submissions for Construct K Palindrome Strings.
    
    public boolean canConstruct(String s, int k) {
        if (k > s.length()) return false;
        int odd = 0;
        int count[] = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            count[s.charAt(i) - 'a'] ^= 1;
            odd += count[s.charAt(i) - 'a'] > 0 ? 1 : -1;
        }
        return odd <= k;
    }


    public static void main(String[] args) {

        //String testData = "leetcode";
        String testData  = "";
        int k = 1;
        PalindromeKStrings solution = new PalindromeKStrings();
        boolean result = solution.canConstruct(testData, k);

        System.out.printf(" input %s canConstruct %d Palindrome: %b ", testData,k, result);
    }

}
