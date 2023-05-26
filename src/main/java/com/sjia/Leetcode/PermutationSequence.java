package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    //  #60. Permutation Sequence  https://leetcode.com/problems/permutation-sequence/
    //  The set [1, 2, 3, ..., n] contains a total of n! unique permutations.
    //  Given n and k, return the kth permutation sequence.
    // "123", "132", "213", "231", "312", "321"
    // Input: n = 3, k = 3  Output: "213"
    // Input: n = 3, k = 1  Output: "123"
    // Input: n = 4, k = 9  Output: "2314"

    // 1 <= n <= 9,  1 <= k <= n!


    public static String getPermutation(int n, int k) {
        List <Integer> numbers = new ArrayList<>();
        int[] fact = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

        StringBuilder sb = new StringBuilder();

        // Create a list of numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }


        // Adjust k to be 0-based index
        k--;

        for (int i = n; i > 0; i--) {
            int index = k / fact[i - 1];
            sb.append(numbers.get(index));
            numbers.remove(index);
            k -= index * fact[i - 1];
        }

        return sb.toString();
    }






    public static void main(String[] args) {
//        int n = 3;
//        int k = 3; //  Output: "213"
        int n = 4;
        int k = 9; //  Output: "2314"
        String permutation = getPermutation(n, k);
        System.out.println(permutation);
    }


}
