package com.sjia.Leetcode;

public class RepeatedSubstringPattern {
    // #459. Repeated Substring Pattern https://leetcode.com/problems/repeated-substring-pattern/

    /*
    Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.

    Input: s = "abab"       Output: true
    Input: s = "aba"        Output: false
    Input: s = "abcabcabcabc"   Output: true

    1 <= s.length <= 10^4
    s consists of lowercase English letters.
     */

    // Runtime: 72 ms, faster than 38.27% of Java online submissions for Repeated Substring Pattern.
    //Memory Usage: 39.9 MB, less than 76.97% of Java online submissions for Repeated Substring Pattern.
    public boolean repeatedSubstringPattern(String s) {
        String tmp = s + s;
        return tmp.substring(1,tmp.length()-1).contains(s);
    }



    // faster than (s + s).substring
    // 35 ms, 72.19%; 43.8 MB, 91.45%
    public boolean repeatedSubstringPattern_twoLoop(String s) {
        int n = s.length();

        for (int len = 1; len <= n / 2; len++) {
            if (n % len == 0) {
                String substring = s.substring(0, len);
                StringBuilder repeated = new StringBuilder();
                int repeats = n / len;

                for (int i = 0; i < repeats; i++) {
                    repeated.append(substring);
                }

                if (repeated.toString().equals(s)) {
                    return true;
                }
            }
        }

        return false;
    }


    public static void main(String[] args) {
        RepeatedSubstringPattern solution = new RepeatedSubstringPattern();
        String s1 = "abab";
        String s2 = "aba";
        String s3 = "abcabcabcabc";

        System.out.println(solution.repeatedSubstringPattern(s1)); // Output: true
        System.out.println(solution.repeatedSubstringPattern(s2)); // Output: false
        System.out.println(solution.repeatedSubstringPattern(s3)); // Output: true
    }


}
