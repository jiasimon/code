package com.sjia.hackerRank;

import java.util.Arrays;

public class TripleSum3Arrays {
    // https://www.hackerrank.com/challenges/triple-sum/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=search

    /*
    3 arrays a, b, c;  p from a, q from b, r from c;
    p <=q, q >=r
    eg:
    1 3 5 7
    5 7 9
    7 9 11 13
     */

    static long triplets(int[] a, int[] b, int[] c) {
        int[] sortedSetA = buildSortedSet(a);
        int[] sortedSetB = buildSortedSet(b);
        int[] sortedSetC = buildSortedSet(c);

        long res = 0;

        if (sortedSetB[sortedSetB.length - 1] < sortedSetA[0]
                || sortedSetB[sortedSetB.length - 1] < sortedSetC[0]) return 0;

        for (int i = sortedSetB.length - 1; i >= 0; i--) {
            int tmp1 = Arrays.binarySearch(sortedSetA, sortedSetB[i]);
            if (tmp1 >= 0) {
                tmp1++;
            } else {
                tmp1 = -(tmp1 + 1);
            }

            int tmp2 = Arrays.binarySearch(sortedSetC, sortedSetB[i]);
            if (tmp2 >= 0) {
                tmp2++;
            } else {
                tmp2 = -(tmp2 + 1);
            }
            res += tmp1 * tmp2;
        }


        return res;
    }

    static int[] buildSortedSet(int[] x) {
        return Arrays.stream(x).distinct().sorted().toArray();
    }


    public static void main(String[] args) {

//        int[] a = {1,3,5,7};
//        int[] b = {5,7,9};
//        int[] c = {7,9,11,13};

        int[] a = {9, 4, 5};
        int[] b = {2, 3, 3};
        int[] c = {9, 2, 3};

        System.out.println(" TripleSum3Arrays: " + triplets(a, b, c));
    }


}
