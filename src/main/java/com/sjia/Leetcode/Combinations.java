package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    // #77. Combinations  https://leetcode.com/problems/combinations/

    /*
    Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

    You may return the answer in any order.

    refer to #39 #46
     */

    // Input: n = 4, k = 2
    // Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]


    //
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>();

        backtrack(res, currentCombination, 1, n, k);

        return res;
    }

    private static void backtrack(List<List<Integer>> combinations, List<Integer> currentCombination, int start, int n, int k) {
        if (currentCombination.size() == k) {
            combinations.add(new ArrayList<>(currentCombination));
            return;
        }

        for (int i = start; i <= n; i++) {
            currentCombination.add(i);
            backtrack(combinations, currentCombination, i + 1, n, k);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        List<List<Integer>> combinations = combine(n, k);

        System.out.println("Combinations of " + n + " numbers, taken " + k + " at a time:");
        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }



}
