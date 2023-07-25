package com.sjia.Leetcode;

import java.util.Arrays;

public class HIndex {
    // #274. H-Index    https://leetcode.com/problems/h-index/description/
    /*
    Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return the researcher's h-index.

    According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.

    Input: citations = [3,0,6,1,5]      Input: citations = [3,0,6,1,5]
    Input: citations = [1,3,1]          Output: 1

    1 <= n <= 5000
    0 <= citations[i] <= 1000
     */

    public int hIndex(int[] citations) {


        return -1;
    }

    public static void main(String[] args) {
        HIndex solution = new HIndex();

        int[] citations = {3, 0, 6, 1, 5};
        int hIndex = solution.hIndex(citations);
        System.out.println("The H-Index is: " + hIndex); // Output: The H-Index is: 3

        int[] citations2 = {3, 0, 6, 1, 5,21, 15};
        int hIndex2 = solution.hIndex(citations2);
        System.out.println("The H-Index is: " + hIndex2); // Output: The H-Index is: 4
    }

}
