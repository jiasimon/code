package com.sjia.Leetcode;

import java.util.Arrays;

public class HIndex2 {
    // #275. H-Index II     https://leetcode.com/problems/h-index-ii/
    /*
    and citations is sorted in ascending order

    Input: citations = [0,1,3,5,6]  Output: 3
    Input: citations = [1,2,100]    Output: 2
     */


    // use HIndex method
    public int hIndex2(int[] citations) {
        int n = citations.length;

        for ( int i= n-1; i>=0; i--) {
            if ( citations[i] < (n-i)) {
                return (n-i-1);
            }
        }
        return n;

    }


    // binary search, l < r
    public int hIndex(int[] citations) {
        int n = citations.length;
        int l = 0;
        int r = n;

        while ( l < r) {
            int m = ( l + r) /2 ;
            if ( citations[m] >= n -m) {
                r = m;
            } else {
                l = m+1;
            }
        }
        return n-l;
    }


    public static void main(String[] args) {
        HIndex2 solution = new HIndex2();

        int[] citations = {0,1,3,5,6};
        int hIndex = solution.hIndex(citations);
        System.out.println("The H-Index is: " + hIndex); // Output: The H-Index is: 3

        int[] citations2 = {0,1, 3, 5, 6,15, 21};
        int hIndex2 = solution.hIndex(citations2);
        System.out.println("The H-Index is: " + hIndex2); // Output: The H-Index is: 4


        int[] citations3 = {6, 6, 6, 6, 6, 6};
        int hIndex3 = solution.hIndex(citations3);
        System.out.println("The H-Index is: " + hIndex3); // Output: The H-Index is: 4
    }


}
