package com.sjia.hackerRank;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumAbsoluteDifferenceInArray {
    // https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=greedy-algorithms

    /*
    {3, -7, 0}  Output: 3
    3- (-7) = 10, 3-0=3; 0-(-7) =7,  min = 3
     */

    public static int minimumAbsoluteDifference(List<Integer> arr) {
        // Write your code here
        int res = Integer.MAX_VALUE;
        Collections.sort(arr);
        for ( int i=1; i < arr.size() ; i++) {
            res = Math.min(res, Math.abs(arr.get(i) -arr.get(i-1)));
        }
        return res;

    }


    public static void main(String[] args) throws IOException {
        List test1 = Arrays.asList(3, -7, 0);

        System.out.println(test1 + " minimumAbsoluteDifference: " + minimumAbsoluteDifference(test1));

    }

}
