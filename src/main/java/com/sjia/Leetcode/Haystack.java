package com.sjia.Leetcode;

public class Haystack {

    // #28 Find the Index of the First Occurrence in a String https://leetcode.com/problems/implement-strstr/

    // haystack = "hello", needle = "ll", haystack = "aaaaa", needle = "bba"
    // Input: haystack = "sadbutsad", needle = "sadbutsad"
    // 1 <= haystack.length, needle.length <= 104
    // haystack and needle consist of only lowercase English characters.


    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Implement strStr().
    //Memory Usage: 39.9 MB, less than 5.21% of Java online submissions for Implement strStr().

    // if needle is "", return 0; with  substring, no need to check

    // KMB, Rabin Karp hash,

    // brute force
    static int strStr(String haystack, String needle) {
        int h = haystack.length(), x = needle.length();
        for ( int i = 0; i< h-x+1; i++ ) {
            if(needle.equals(haystack.substring(i, i+x))) return i;
        }
        return -1;

    }


    public static void main(String[] args) {
        String haystack = "sadbutsad";
        String needle = "sad";
        int result = strStr(haystack, needle);
        System.out.printf("The index of needle %s is: %d", needle, result);

    }


}
