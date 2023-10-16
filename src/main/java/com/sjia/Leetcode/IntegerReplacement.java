package com.sjia.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class IntegerReplacement {
    // #397. Integer Replacement    https://leetcode.com/problems/integer-replacement/

    /*
    Given a positive integer n, you can apply one of the following operations:

    If n is even, replace n with n / 2.
    If n is odd, replace n with either n + 1 or n - 1.
    Return the minimum number of operations needed for n to become 1.

     */


    // recursive
    // java.lang.StackOverflowError
    public int integerReplacement_recursive_failed(int n) {
        if (n == 1) {
            return 0;
        } else if (n % 2 == 0) {
            return 1 + integerReplacement_recursive_failed(n / 2);
        } else {
            return 1 + Math.min(integerReplacement_recursive_failed(n + 1), integerReplacement_recursive_failed(n - 1));
        }
    }

    public int integerReplacement_recursive(int n) {
        if (n == 1) {
            return 0;
        } else if (n % 2 == 0) {
            return 1 + integerReplacement_recursive(n / 2);
        } else {
            return 2 + Math.min(integerReplacement_recursive(n/2), integerReplacement_recursive(n/2 + 1));
        }

    }


    public int integerReplacement_long(int n) {
        long num = n;
        return (int) dfs_long(num);

    }


    public long dfs_long(long n) {
        if (n == 1) {
            return 0;
        } else if (n % 2 == 0) {
            return 1 + dfs_long(n / 2);
        } else {
            return 1 + Math.min(dfs_long(n + 1), dfs_long(n - 1));
        }

    }



    // memo, Hashmap
    // 1 ms, 58.87%; 39.6 MB, 18.83%
    Map<Integer, Integer> memo = new HashMap<Integer, Integer>();

    public int integerReplacement(int n) {
        if (n == 1) {
            return 0;
        }
        if (!memo.containsKey(n)) {
            if (n % 2 == 0) {
                memo.put(n, 1 + integerReplacement(n / 2));
            } else {
                memo.put(n, 2 + Math.min(integerReplacement(n / 2), integerReplacement(n / 2 + 1)));
            }
        }
        return memo.get(n);
    }



    // if((temp&3)==3&&temp!=3)
    public int integerReplacement_bit(int n) {
        long temp=n;
        int count=0;
        while(temp!=1){
            if((temp&3)==3&&temp!=3){
                temp++;
            }
            else if((temp&1)==1){
                temp--;
            }
            else{
                temp=temp>>1;
            }
            count++;
        }
        return count;

    }


    // (n >>> 1) & 1) == 0
    public int integerReplacement_faster(int n) {
        int c = 0;
        while (n != 1) {
            if ((n & 1) == 0) {
                n >>>= 1;
            } else if (n == 3 || ((n >>> 1) & 1) == 0) {
                --n;
            } else {
                ++n;
            }
            ++c;
        }
        return c;

    }


    public static void main(String[] args) {
        IntegerReplacement solution = new IntegerReplacement();
        int n = 8;
        int steps = solution.integerReplacement_recursive(n);
        System.out.println("Steps needed to convert " + n + " to 1: " + steps); // Output: 3
    }

}
