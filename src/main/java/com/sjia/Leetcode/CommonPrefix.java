package com.sjia.Leetcode;


import java.util.Arrays;

public class CommonPrefix {
    // https://leetcode.com/problems/longest-common-prefix/

    //Runtime: 1 ms, faster than 65.55% of Java online submissions for Longest Common Prefix.
    //Memory Usage: 39.3 MB, less than 18.02% of Java online submissions for Longest Common Prefix.




    static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        Arrays.sort(strs);
        int i = 0;
        int length = Math.min(strs[0].length(), strs[strs.length-1].length());
        for (i=0; i < length; ++i) {
            if (strs[0].charAt(i) != strs[strs.length-1].charAt(i)) {
                return ( i>=1 ? strs[0].substring(0,i) : "" ) ;
            }
        }
        return strs[0].substring(0, length);
    }

    public static void main(String[] args) {

        String[] testData  = {"flower","flow","flight"};
        String result = longestCommonPrefix(testData);

        System.out.printf(" longest Common Prefix is %s \n", result);
    }
}
