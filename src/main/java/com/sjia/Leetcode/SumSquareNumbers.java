package com.sjia.Leetcode;

public class SumSquareNumbers {
    // #633 https://leetcode.com/problems/sum-of-square-numbers/

    // Runtime: 3 ms, faster than 76.02% of Java online submissions for Sum of Square Numbers.
    //Memory Usage: 36 MB, less than 92.75% of Java online submissions for Sum of Square Numbers.
/*
    public boolean judgeSquareSum(int c) {
        for (long i =0; i*i <= c; i++ ) {
            double j = Math.sqrt(c -i*i);
            if ( j == (int)j ) return true;
        }
        return false;
    }*/


    // two pointer
    // Runtime: 2 ms, faster than 97.69% of Java online submissions for Sum of Square Numbers.
    //Memory Usage: 35.9 MB, less than 93.86% of Java online submissions for Sum of Square Numbers.
    public boolean judgeSquareSum_old(int c) {
        if (c <0) return false;
        int left=0, right = (int)Math.sqrt(c);
        while(left <= right) {
            int sum = left*left + right * right;
            if (sum<c) left++;
            else if (sum>c) right--;
            else return true;
        }
        return false;
    }

    // 124 / 127 testcases passed
    // c = 2147483600
    public boolean judgeSquareSum(int c) {
        if (c <=2) return true;
        int left=0, right = (int)Math.sqrt(c);
        while(left <= right) {
            int sum = left*left + right * right;
            if (sum<c) left++;
            else if (sum>c) right--;
            else return true;
        }
        return false;
    }


    public static void main(String[] args) {
        SumSquareNumbers solution = new SumSquareNumbers();

        // Test Cases
        int num1 = 5;
        int num2 = 3;
        int num3 = 2147483600;
        System.out.println("Test Case 1: " + solution.judgeSquareSum(num1)); // Output: true
        System.out.println("Test Case 2: " + solution.judgeSquareSum(num2)); // Output: false
        System.out.println("Test Case 3: " + solution.judgeSquareSum(num3)); // Output: false
    }


}
