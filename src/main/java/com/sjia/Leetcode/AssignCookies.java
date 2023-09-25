package com.sjia.Leetcode;

import java.util.Arrays;

public class AssignCookies {

    // #455. Assign Cookies https://leetcode.com/problems/assign-cookies/
    /*
    Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie.

    Each child i has a greed factor g[i], which is the minimum size of a cookie that the child will be content with; and each cookie j has a size s[j]. If s[j] >= g[i], we can assign the cookie j to the child i, and the child i will be content.
    Your goal is to maximize the number of your content children and output the maximum number.

    Input: g = [1,2,3], s = [1,1]       Output: 1
    Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3.
    And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
    You need to output 1.

    Input: g = [1,2], s = [1,2,3]       Output: 2
    1 <= g[i], s[j] <= 2^31 - 1
     */

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



    // sort, for loop
    // 9 ms, 35.83%; 43.9 MB, 91.13%
    public int findContentChildren_sort(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i=0;
        for ( int j=0; i < g.length && j < s.length; j++) {
            if (g[i] <= s[j]){
                i++;
            }
        }

        return i;

    }

    public static void main(String[] args) {
        AssignCookies solution = new AssignCookies();
        int[] children = {1, 2, 3};
        int[] cookies = {1, 1};
        int satisfiedChildren = solution.findContentChildren(children, cookies);
        System.out.println("Satisfied children: " + satisfiedChildren); // Output: 1
    }


}
