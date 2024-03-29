package com.sjia.Leetcode;


import java.util.Arrays;

public class LongestCommonPrefix {
    // #14 Longest Common Prefix https://leetcode.com/problems/longest-common-prefix/

    //Runtime: 1 ms, faster than 65.55% of Java online submissions for Longest Common Prefix.
    //Memory Usage: 39.3 MB, less than 18.02% of Java online submissions for Longest Common Prefix.

    // add strs.length == 1 check
    //Runtime: 2 ms, faster than 38.54% of Java online submissions for Longest Common Prefix.
    //Memory Usage: 39.4 MB, less than 15.77% of Java online submissions for Longest Common Prefix.

    static String longestCommonPrefix2(String[] strs) {
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
    }




    // Runtime: 1 ms, faster than 57.19% of Java online submissions for Longest Common Prefix.
    //Memory Usage: 36.8 MB, less than 11.98% of Java online submissions for Longest Common Prefix.
    public static String longestCommonPrefix3(String[] strs) {
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


    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Longest Common Prefix.
    //Memory Usage: 37 MB, less than 11.98% of Java online submissions for Longest Common Prefix.
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String pre = strs[0];
        for (int i = 1; i < strs.length; i++)
            while ( !strs[i].startsWith(pre))
                pre = pre.substring(0, pre.length() - 1);
        return pre;
    }


    public static void main(String[] args) {

        //String[] testData  = {"flower","flow","flight"};
        String[] testData  = {"ab","a"};
        String[] testData2  = {"让我跑","让我们"};
        String result = longestCommonPrefix(testData2);

        System.out.printf(" longest Common Prefix is %s \n", result);
    }
}
