package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle2 {
    // #119. Pascal's Triangle II  https://leetcode.com/problems/pascals-triangle-ii/

    /*
    Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

    In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
     */


    public List<Integer> getRowPascalTriangle(int rowIndex) {
        return generate(rowIndex+1).get(rowIndex);
    }

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

    // Runtime: 1 ms, faster than 84.24% of Java online submissions for Pascal's Triangle II.
    //Memory Usage: 37 MB, less than 53.89% of Java online submissions for Pascal's Triangle II.
    public List<Integer> getPascalRow(int rowIndex) {
        if (rowIndex==0) return Arrays.asList(1);
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


    // Arrays.fill
    public List<Integer> getRow(int k) {
        Integer[] arr = new Integer[k + 1];
        Arrays.fill(arr, 0);
        arr[0] = 1;

        for (int i = 1; i <= k; i++)
            for (int j = i; j > 0; j--)
                arr[j] = arr[j] + arr[j - 1];

        return Arrays.asList(arr);
    }


    // pre * (N - k + 1) / k
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Pascal's Triangle II.
    //Memory Usage: 36.6 MB, less than 92.40% of Java online submissions for Pascal's Triangle II.

    public List<Integer> getRow2(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        long pre = 1;
        result.add(1);
        for (int k = 1; k <= rowIndex; k++) {
            long cur = pre * (rowIndex - k + 1) / k;
            result.add((int) cur);
            pre = cur;
        }
        return result;
    }



    public static void main(String[] args) {

        // [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1]]
        // int testData  = 4; //{1, 4, 6, 4, 1}
        int testData  = 4;
        PascalTriangle2 solution = new PascalTriangle2();
        List<Integer> result = solution.getRowPascalTriangle(testData);

        System.out.printf(" testData %s Subsets result is %s \n", testData, result);
    }

}
