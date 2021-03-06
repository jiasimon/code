package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SortArrayByParity {
    // #905 https://leetcode.com/problems/sort-array-by-parity/
    // return an array consisting of all the even elements of A,
    // followed by all the odd elements of A.


    // Runtime: 1 ms, faster than 99.59% of Java online submissions for Sort Array By Parity.
    //Memory Usage: 40.4 MB, less than 59.79% of Java online submissions for Sort Array By Parity.

    public int[] sortArrayByParity(int[] A) {
        List<Integer> odd = new ArrayList<>(), even = new ArrayList<>();
        for (int i : A) {
            if( i%2 ==0 ) even.add(i);
            else odd.add(i);
        }

        int [] result = new int[A.length];
        int i=0;
        for (; i<even.size(); i++) result[i] = even.get(i);
        for (int j=0; j< odd.size(); j++) result[i++] = odd.get(j);
        return result;
    }




    // Runtime: 1 ms, faster than 99.60% of Java online submissions for Sort Array By Parity.
    //Memory Usage: 40.4 MB, less than 65.25% of Java online submissions for Sort Array By Parity.
/*    public int[] sortArrayByParity(int[] A) {
        int [] res = new int[A.length];
        int i=0, j = A.length-1 ;
        for (int x = 0 ; x < A.length; x++) {
            if (A[x] %2 ==0) res[i++] = A[x];
            else res[j--] = A[x];
        }
        return res;
    }*/


    // Stream
    // Runtime: 11 ms, faster than 5.61% of Java online submissions for Sort Array By Parity.
    //Memory Usage: 40.3 MB, less than 75.62% of Java online submissions for Sort Array By Parity.
/*
    public int[] sortArrayByParity(int[] A) {
        return Arrays.stream(A)
                     .boxed()
                     .sorted((a, b) -> Integer.compare(a%2, b%2))
                     .mapToInt(i -> i)
                     .toArray();
    }*/




    // Runtime: 6 ms, faster than 8.07% of Java online submissions for Sort Array By Parity.
    //Memory Usage: 40.2 MB, less than 77.57% of Java online submissions for Sort Array By Parity.
/*    public int[] sortArrayByParity(int[] A) {
        List<Integer> odd = new ArrayList<>(), even = new ArrayList<>();
        for (int i : A) {
            if( i%2 ==0 ) even.add(i);
            else odd.add(i);
        }

        even.addAll(odd);

        return even.stream().mapToInt(x-> x).toArray();


    }*/



    //
    // Runtime: 2 ms, faster than 36.55% of Java online submissions for Sort Array By Parity.
    // Memory Usage: 40.4 MB, less than 63.78% of Java online submissions for Sort Array By Parity.
/*
    public int[] sortArrayByParity(int[] A) {
        List<Integer> odd = new ArrayList<>(), even = new ArrayList<>();
        for (int i : A) {
            if( i%2 ==0 ) even.add(i);
            else odd.add(i);
        }

        even.addAll(odd);

        int [] result = new int[A.length];

        for (int i=0; i<A.length; i++) result[i] = even.get(i);
        return result;
    }*/



    // two pointers, swap
    // Runtime: 1 ms, faster than 99.60% of Java online submissions for Sort Array By Parity.
    //Memory Usage: 40.3 MB, less than 73.14% of Java online submissions for Sort Array By Parity.
/*    public int[] sortArrayByParity(int[] A) {
        int i = 0, j = A.length-1;
        while (i < j) {
            if (A[i] %2 ==0) i++;
            else {
                if (A[j]%2==1) j--;
                else {
                    int tmp = A[j];
                    A[j] = A[i];
                    A[i] = tmp;
                    i++;
                    j--;
                }

            }
        }
        return A;
    }*/



}
