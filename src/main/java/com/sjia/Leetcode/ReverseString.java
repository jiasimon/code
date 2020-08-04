package com.sjia.Leetcode;

public class ReverseString {
    // #344 https://leetcode.com/problems/reverse-string/


    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse String.
    //Memory Usage: 46.7 MB, less than 15.45% of Java online submissions for Reverse String.
    public void reverseString(char[] s) {
        if (s==null || s.length==0) return;
        int left=0, right =s.length-1;
        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }

    }

}
