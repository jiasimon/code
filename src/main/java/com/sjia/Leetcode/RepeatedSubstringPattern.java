package com.sjia.Leetcode;

public class RepeatedSubstringPattern {
    // #459 https://leetcode.com/problems/repeated-substring-pattern/

    // Runtime: 72 ms, faster than 38.27% of Java online submissions for Repeated Substring Pattern.
    //Memory Usage: 39.9 MB, less than 76.97% of Java online submissions for Repeated Substring Pattern.
    public boolean repeatedSubstringPattern(String s) {
        String tmp = s + s;
        return tmp.substring(1,tmp.length()-1).contains(s);
    }

    

}
