package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryPrefixDivisibleBy5 {
    // #1018 https://leetcode.com/problems/binary-prefix-divisible-by-5/
    // 1 <= A.length <= 30000
    // A[i] is 0 or 1

    // Input: [0,1,1]   Output: [true,false,false],  0, 01, 011; which are 0, 1, and 3
    // Input: [0,1,1,1,1,1] [true,false,false,false,true,false]


    // Runtime: 2 ms, faster than 100.00% of Java online submissions for Binary Prefix Divisible By 5.
    // Memory Usage: 39.5 MB, less than 18.71% of Java online submissions for Binary Prefix Divisible By 5.
    public List<Boolean> prefixesDivBy5(int[] A) {
        List <Boolean> res = new ArrayList<>();
        int tmp = 0 ;
        for (int i : A) {
            tmp  = (tmp * 2 + i) %5;
            if (tmp==0) res.add(true);
            else res.add(false);
        }
        return res;
    }


    // Runtime: 3 ms, faster than 67.31% of Java online submissions for Binary Prefix Divisible By 5.
    //Memory Usage: 39.3 MB, less than 18.71% of Java online submissions for Binary Prefix Divisible By 5.
/*    public List<Boolean> prefixesDivBy5(int[] A) {
        List <Boolean> res = new ArrayList<>();
        int tmp = 0 ;
        for (int i : A) {
            tmp  = (tmp * 2 + i) %5;
            res.add(tmp==0);
        }
        return res;
    }*/



}
