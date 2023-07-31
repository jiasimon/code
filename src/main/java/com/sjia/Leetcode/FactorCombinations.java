package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class FactorCombinations {
    // #254. Factor Combinations    https://leetcode.com/problems/factor-combinations/
    /*
    https://grandyang.com/leetcode/254/
    Numbers can be regarded as product of its factors. For example,
    Write a function that takes an integer  n  and return all possible combinations of its factors.

    You may assume that  n  is always positive.
    Factors should be greater than 1 and less than  n.

    Input: 1        Output: []
    Input: 37       Output:[]
    Input: 12
    Output:
    [
      [2, 6],
      [2, 2, 3],
      [3, 4]
    ]
     */



    // backtrack, i = start ; i <= n;
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> path = new ArrayList<>();
        backtrack(n, 2, path, res);

        return res;
    }

    private void backtrack(int n, int start, List<Integer> current, List<List<Integer>> result) {
        if( n==1 && current.size() > 1) {  //  not >=1
            result.add(new ArrayList<>(current));
            return;
        }

        for ( int i = start ; i <= n; i++) {
            if( n%i == 0) {
                current.add(i);
                backtrack( n/i, i, current, result);
                current.remove(current.size() - 1);
            }
        }

    }

    public static void main(String[] args) {
        int n = 12;
        FactorCombinations solution = new FactorCombinations();
        List<List<Integer>> result = solution.getFactors(n);
        System.out.println("Factor combinations for " + n + ":");
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }

        System.out.println(result);
        /* Output:
           Factor combinations for 12:
           [2, 2, 3]
           [2, 6]
           [3, 4]
         */
    }


}
