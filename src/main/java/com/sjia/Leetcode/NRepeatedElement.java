package com.sjia.Leetcode;

import java.util.HashSet;
import java.util.Set;

public class NRepeatedElement {
    // #961 https://leetcode.com/problems/n-repeated-element-in-size-2n-array/
    // Return the element repeated N times.
    // 4 <= A.length <= 10000
    // 0 <= A[i] < 10000
    // A.length is even


    // Runtime: 0 ms, faster than 100.00% of Java online submissions for N-Repeated Element in Size 2N Array.
    //Memory Usage: 39.7 MB, less than 92.72% of Java online submissions for N-Repeated Element in Size 2N Array.
    public int repeatedNTimes(int[] A) {
        Set<Integer> tmp = new HashSet<>();
        for (Integer n : A) {
            if(tmp.contains(n)) return n;
            else tmp.add(n);
        }
        return 0;
    }

    // new int array, less memory
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for N-Repeated Element in Size 2N Array.
    // Memory Usage: 39 MB, less than 99.95% of Java online submissions for N-Repeated Element in Size 2N Array.
/*    public int repeatedNTimes(int[] A) {
        int[] count = new int[10000];
        for (Integer n : A) {
            if (count[n]++ == 1) return n;
        }
        return -1;
    }*/




}
