package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class SortArrayByParity2 {
    // #922 https://leetcode.com/problems/sort-array-by-parity-ii/
    // 2 <= A.length <= 20000
    // A.length % 2 == 0
    // 0 <= A[i] <= 1000

    // Runtime: 5 ms, faster than 20.52% of Java online submissions for Sort Array By Parity II.
    // Memory Usage: 43 MB, less than 33.19% of Java online submissions for Sort Array By Parity II.
/*    public int[] sortArrayByParityII(int[] A) {
        List<Integer> odd = new ArrayList<>(), even = new ArrayList<>();
        for (int i : A) {
            if( i%2 ==0 ) even.add(i);
            else odd.add(i);
        }

        int [] res = new int[A.length];
        int i=0, j=0;
        for (int x = 0 ; x < A.length; x++) {
            if (x%2==0) res[x] = even.get(i++);
            else res[x] = odd.get(j++);
        }
        return res;
    }*/



    // new int[A.length]
    // Runtime: 2 ms, faster than 99.60% of Java online submissions for Sort Array By Parity II.
    //Memory Usage: 41.9 MB, less than 68.66% of Java online submissions for Sort Array By Parity II.
    public int[] sortArrayByParityII(int[] A) {
        int [] res = new int[A.length];
        int i=0, j=1;
        for (int x = 0 ; x < A.length; x++) {
            if (A[x] %2 ==0) {
                res[i] = A[x];
                i += 2;
            } else {
                res[j] = A[x];
                j +=2;
            }
        }
        return res;
    }


    // two pointers , no additional space, if we can modify input
    // Runtime: 2 ms, faster than 99.60% of Java online submissions for Sort Array By Parity II.
    //Memory Usage: 40.6 MB, less than 92.18% of Java online submissions for Sort Array By Parity II.
/*    public int[] sortArrayByParityII(int[] A) {
        int i=0, j=1;
        while (i< A.length && j < A.length) {
            if (A[i] %2 == 0) i += 2;
            else if (A[j] %2 == 1) j += 2;
            else {
                int tmp = A[i];
                A[i] = A[j];
                A[j] =tmp;
            }
        }
        return A;
    }*/



}
