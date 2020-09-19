package com.sjia.Leetcode;

public class MonotonicArray {

    // #896 https://leetcode.com/problems/monotonic-array/

    // Runtime: 1 ms, faster than 100.00% of Java online submissions for Monotonic Array.
    //Memory Usage: 47.2 MB, less than 81.84% of Java online submissions for Monotonic Array.
    public boolean isMonotonic(int[] A) {
        if (A.length <3) return true;
        int flag = 0;
        for (int i=1; i< A.length; i++) {
            if ( A[i] != A[i-1]) {
                if (A[i] > A[i-1]) {
                    if (flag==0) flag=1;
                    else if (flag == -1) return false;
                } else if (A[i] < A[i-1]) {
                    if (flag==0) flag = -1;
                    else if (flag == 1) return false;
                }
            }

        }
        return true;
    }

}
