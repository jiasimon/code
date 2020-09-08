package com.sjia.Leetcode;

public class RotateString {
    // #796 https://leetcode.com/problems/rotate-string/
    // For example, if A = 'abcde', then it will be 'bcdea' after one shift on A
    // Return True if and only if A can become B after some number of shifts on A

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate String.
    //Memory Usage: 37.4 MB, less than 63.71% of Java online submissions for Rotate String.
    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) return false;
        return (A+A).contains(B);
    }



}
