package com.sjia.Leetcode;

import java.util.*;

public class PositionsLargeGroups {

    // #830 https://leetcode.com/problems/positions-of-large-groups/
    // S = "aaabbxxxxzyy"


    // Runtime: 2 ms, faster than 53.51% of Java online submissions for Positions of Large Groups.
    //Memory Usage: 39.7 MB, less than 67.28% of Java online submissions for Positions of Large Groups.
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        int i=0, j=0;
        while( i <s.length() ) {
            for (j=i+1; j< s.length() ; j++ ) {
                if(s.charAt(j) != s.charAt(i)) break;
            }
            if (j-i >= 3) res.add( Arrays.asList(new Integer[]{i,j-1}));
            i = j;
        }
        return res;

    }


    public static void main(String[] args) {
        String testData  = "aaa"; // "aaa"

        PositionsLargeGroups solution = new PositionsLargeGroups();
        List<List<Integer>>  result = solution.largeGroupPositions(testData);

        System.out.printf("testData %s add digits is %s \n", testData,result);
    }

}
