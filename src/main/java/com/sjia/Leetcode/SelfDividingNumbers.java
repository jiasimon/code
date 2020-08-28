package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {
    // #728 https://leetcode.com/problems/self-dividing-numbers/
    // For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.


    // Runtime: 1 ms, faster than 99.95% of Java online submissions for Self Dividing Numbers.
    //Memory Usage: 37.3 MB, less than 65.58% of Java online submissions for Self Dividing Numbers.
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int i= left; i <=right; i++) {
            if ( checkselfDiv(i) ) result.add(i);
        }
        return result;
    }

    private boolean checkselfDiv(int i) {
        int tmp = i;
        while (tmp >0) {
            int r = tmp % 10;
            tmp /= 10;
            if (r==0 || i % r >0) return false;
        }
        return true;
    }


    public static void main(String[] args) {

        int testData1  = 1;
        int testData2  = 200;
        SelfDividingNumbers solution = new SelfDividingNumbers();

        List<Integer> result = solution.selfDividingNumbers(testData1, testData2);

        System.out.printf(" input1: %s , input2: %s , selfDividingNumbers: %s ", testData1, testData2,
                result);
    }


}
