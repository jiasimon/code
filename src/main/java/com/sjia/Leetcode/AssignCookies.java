package com.sjia.Leetcode;

import java.util.Arrays;

public class AssignCookies {

    // #455 https://leetcode.com/problems/assign-cookies/

    // Runtime: 6 ms, faster than 99.95% of Java online submissions for Assign Cookies.
    //Memory Usage: 40.1 MB, less than 87.02% of Java online submissions for Assign Cookies.
    public int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0, j=0;
        while ( i < g.length && j < s.length ) {
            if ( g[i] <= s[j] ) i++;
            j++;
        }
        return i;
    }

}
