package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class HappyNumber {
    // #202. Happy Number https://leetcode.com/problems/happy-number/submissions/
    /*
    A happy number is a number defined by the following process:
    Starting with any positive integer, replace the number by the sum of the squares of its digits.
    Input: n = 19   Output: true
    1^2 + 9^2 = 82
    8^2 + 2^2 = 68
    6^2 + 8^2 = 100
    1^2 + 0^2 + 0^2 = 1

    Input: n = 2    Output: false

     */



    public static boolean isHappyHashset(int n) {
        HashSet<Integer> set = new HashSet<>();

        while (n != 1) {
            int current = n;
            int sum = 0;

            while (current != 0) {
                int digit = current % 10;
                sum += digit * digit;
                current /= 10;
            }

            if (set.contains(sum)) {
                return false;
            }

            set.add(sum);
            n = sum;
        }

        return true;
    }





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


    // private static HashSet<Integer> tmp =
    //        new HashSet<>(Arrays.asList(4, 16, 37, 58, 89, 145, 42, 20));


    // update while loop
    // Runtime: 2 ms, faster than 41.71% of Java online submissions for Happy Number.
    //Memory Usage: 36.7 MB, less than 35.32% of Java online submissions for Happy Number.
    public boolean isHappy(int n) {
        HashSet<Integer> tmp = new HashSet<>();
        while(n !=1 && !tmp.contains(n)) {
            tmp.add(n);
            n = getNextNumber(n);
        }
        return n==1;
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
