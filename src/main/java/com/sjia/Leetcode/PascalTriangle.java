package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
    // #118 https://leetcode.com/problems/pascals-triangle/

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Pascal's Triangle.
    //Memory Usage: 37.2 MB, less than 29.43% of Java online submissions for Pascal's Triangle.

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for ( int i =0; i<numRows; i++ ) {
            List <Integer> tmp = new ArrayList<Integer>();
            for (int j=0; j<=i; j++) {
                if ( ( j==0) || ( j==i) ) tmp.add(1);
                else {
                    tmp.add(result.get(i-1).get(j-1) +  result.get(i-1).get(j));
                }

            }
            result.add(tmp);
        }
        return  result;
    }


    public static void main(String[] args) {

        // int[] testData  = {1,2,3};
        int testData  = 4;
        PascalTriangle solution = new PascalTriangle();
        List<List<Integer>> result = solution.generate(testData);

        System.out.printf(" testData %s Subsets result is %s \n", testData,result);
    }

}
