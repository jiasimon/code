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


}
