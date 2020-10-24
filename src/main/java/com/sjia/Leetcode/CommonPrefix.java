package com.sjia.Leetcode;


import java.util.Arrays;

public class CommonPrefix {
    // #14 https://leetcode.com/problems/longest-common-prefix/

    //Runtime: 1 ms, faster than 65.55% of Java online submissions for Longest Common Prefix.
    //Memory Usage: 39.3 MB, less than 18.02% of Java online submissions for Longest Common Prefix.

    // add strs.length == 1 check
    //Runtime: 2 ms, faster than 38.54% of Java online submissions for Longest Common Prefix.
    //Memory Usage: 39.4 MB, less than 15.77% of Java online submissions for Longest Common Prefix.
/*
    static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        Arrays.sort(strs);
        int i = 0;
        int length = Math.min(strs[0].length(), strs[strs.length-1].length());
        for (i=0; i < length; ++i) {
            if (strs[0].charAt(i) != strs[strs.length-1].charAt(i)) {
                return ( i>=1 ? strs[0].substring(0,i) : "" ) ;
            }
        }
        return strs[0].substring(0, length);
    }*/


    // Runtime: 4 ms, faster than 24.30% of Java online submissions for Longest Common Prefix.
    //Memory Usage: 39.2 MB, less than 21.06% of Java online submissions for Longest Common Prefix.

/*    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int j = 0; j < strs[0].length(); ++j) {
            for (int i = 0; i < strs.length; ++i) {
                if (j >= strs[i].length() || strs[i].charAt(j) != strs[0].charAt(j)) {
                    return strs[i].substring(0, j);
                }
            }
        }
        return strs[0];
    }*/


    // Runtime: 1 ms, faster than 57.19% of Java online submissions for Longest Common Prefix.
    //Memory Usage: 36.8 MB, less than 11.98% of Java online submissions for Longest Common Prefix.
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length==0) return "";
        if (strs.length == 1) return strs[0];
        for (int i=0; i< strs[0].length(); i++)
            for (int j=0; j < strs.length; j++) {
                if ( i >= strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i) ) {
                    return strs[j].substring(0,i);
                }
            }
        return strs[0];
    }



    public static void main(String[] args) {

        //String[] testData  = {"flower","flow","flight"};
        String[] testData  = {"ab","a"};
        String result = longestCommonPrefix(testData);

        System.out.printf(" longest Common Prefix is %s \n", result);
    }
}
