package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
    // #118. Pascal's Triangle  https://leetcode.com/problems/pascals-triangle/

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


    public List<List<Integer>> generatePascalTriangle(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        if (numRows == 0) {
            return res;
        }

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        res.add(firstRow);

        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = res.get(i - 1);

            row.add(1);

            for (int j = 1; j < i; j++) {
                int num = prevRow.get(j - 1) + prevRow.get(j);
                row.add(num);
            }

            row.add(1);

            res.add(row);
        }

        return res;
    }


    public static void main(String[] args) {

        // [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1]]
        int testData  = 4;
        PascalTriangle solution = new PascalTriangle();
        List<List<Integer>> result = solution.generate(testData);

        System.out.printf(" testData %s Subsets result is %s \n", testData,result);
    }

}
