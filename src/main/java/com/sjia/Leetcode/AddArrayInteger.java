package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AddArrayInteger {
    // #989 https://leetcode.com/problems/add-to-array-form-of-integer/
    // Given the array-form A of a non-negative integer X, return the array-form of the integer X+K.
    // 1 <= A.length <= 10000
    // 0 <= A[i] <= 9
    // 0 <= K <= 10000
    // If A.length > 1, then A[0] != 0
    // A = [2,7,4], K = 181
    // A = [2,1,5], K = 806    1021

    // refer #2


    // Runtime: 3 ms, faster than 94.69% of Java online submissions for Add to Array-Form of Integer.
    // Memory Usage: 40.6 MB, less than 79.45% of Java online submissions for Add to Array-Form of Integer.
/*    public List<Integer> addToArrayForm(int[] A, int K) {
        int n = A.length , i= n-1;
        int tmp = K;
        List <Integer> res = new ArrayList<>();
        while (i>=0 || tmp >0  ) {
            if (i>=0) tmp += A[i];
            res.add( tmp % 10 );
            tmp /= 10;
            i--;
        }
        Collections.reverse(res);
        return res;
    }*/


    // for loop with K>0
    // Runtime: 4 ms, faster than 68.76% of Java online submissions for Add to Array-Form of Integer.
    //Memory Usage: 40.3 MB, less than 93.28% of Java online submissions for Add to Array-Form of Integer.
    public List<Integer> addToArrayForm(int[] A, int K) {
        int n = A.length;
        List <Integer> res = new ArrayList<>();
        for (int i=n-1; i>=0 || K>0; i--) {
            if (i >= 0) K += A[i];
            res.add( K % 10 );
            K /= 10;
        }
        Collections.reverse(res);
        return res;
    }


    public static void main(String[] args) {
        int[] testData = {0};
        int K = 10000;
        AddArrayInteger solution = new AddArrayInteger();
        List<Integer> result = solution.addToArrayForm(testData, K);
        System.out.printf( "input %s plus %s  is : %s ", Arrays.toString(testData), K, result);
    }

}
