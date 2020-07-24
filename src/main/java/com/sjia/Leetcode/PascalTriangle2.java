package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle2 {
    // #119 https://leetcode.com/problems/pascals-triangle-ii/


    // Runtime: 1 ms, faster than 84.24% of Java online submissions for Pascal's Triangle II.
    //Memory Usage: 37 MB, less than 53.89% of Java online submissions for Pascal's Triangle II.

    public List<Integer> getRow(int rowIndex) {
        if (rowIndex==0) return Arrays.asList(1);
        int pre = 1;
        List<Integer> result = new ArrayList<>();
        result.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i - 1; j > 0; j--) {
                result.set(j, result.get(j - 1) + result.get(j));
            }
            result.add(1);
        }
        return result;

    }

    public static void main(String[] args) {

        // int testData  = 4; //{1, 4, 6, 4, 1}
        int testData  = 4;
        PascalTriangle2 solution = new PascalTriangle2();
        List<Integer> result = solution.getRow(testData);

        System.out.printf(" testData %s Subsets result is %s \n", testData, result);
    }

}
