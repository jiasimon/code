package com.sjia.Leetcode;

public class Haystack {

    // #28 https://leetcode.com/problems/implement-strstr/
    // haystack = "hello", needle = "ll", haystack = "aaaaa", needle = "bba"

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Implement strStr().
    //Memory Usage: 39.9 MB, less than 5.21% of Java online submissions for Implement strStr().

    static int strStr(String haystack, String needle) {
        if( needle.isEmpty()) return 0;
        int len = haystack.length(), x = needle.length();
        for (int i=0; i< len-x+1; i++) {
            if ( needle.equals(haystack.substring(i, i+x)) ) return i;
        }
        return -1;
    }


    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        int result = strStr(haystack, needle);
        System.out.printf("The index of needle %s is: %d", needle, result);

    }


}
