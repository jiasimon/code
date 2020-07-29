package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class HappyNumber {
    // #202 https://leetcode.com/problems/happy-number/submissions/

    //Runtime: 2 ms, faster than 41.71% of Java online submissions for Happy Number.
    //Memory Usage: 38.4 MB, less than 8.40% of Java online submissions for Happy Number.
    HashSet<Integer> tmp = new HashSet<>();

    public boolean isHappy(int n) {
        int result =0;
        //HashSet<Integer> tmp = new HashSet<>();
        while (n >0) {
            result +=  (n %10)*(n %10);
            n /= 10 ;
        }
        if ( result ==1) return true;
        else {
            if (tmp.contains(result)) return false;
            else {
                tmp.add(result);
                return isHappy(result);
            }
        }
    }

    

    public static void main(String[] args) {

        //int testData  = {0,0};
        int testData = 2;

        HappyNumber solution = new HappyNumber();
        boolean result = solution.isHappy(testData);

        System.out.printf(" testData  %s is happy: %s \n",testData, result);
    }

}
