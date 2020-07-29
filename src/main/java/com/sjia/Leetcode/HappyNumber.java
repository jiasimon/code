package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class HappyNumber {
    // #202 https://leetcode.com/problems/happy-number/submissions/

    //Runtime: 2 ms, faster than 41.71% of Java online submissions for Happy Number.
    //Memory Usage: 38.4 MB, less than 8.40% of Java online submissions for Happy Number.
/*    HashSet<Integer> tmp = new HashSet<>();

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
    }*/


    // 4, 16, 37, 58, 89,

    //Runtime: 4 ms, faster than 13.94% of Java online submissions for Happy Number.
    //Memory Usage: 38.6 MB, less than 6.83% of Java online submissions for Happy Number.
    public boolean isHappy(int n) {
        HashSet<Integer> tmp = new HashSet<>();
        while(true) {
            int result = getNextNumber(n);
            if ( result ==1) return true;
            else if (tmp.contains(result)) return false;
            else {
                tmp.add(result);
                n = result;
            }
        }
    }

    private int getNextNumber(int n) {
        int result =0;
        while (n >0) {
            result +=  (n %10)*(n %10);
            n /= 10 ;
        }
        return result;
    }


    public static void main(String[] args) {

        //int testData  = {0,0};
        int testData = 2;

        HappyNumber solution = new HappyNumber();
        boolean result = solution.isHappy(testData);

        System.out.printf(" testData  %s is happy: %s \n",testData, result);
    }

}
