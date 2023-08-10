package com.sjia.hackerRank;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AngryChildren {
    // https://www.hackerrank.com/challenges/angry-children/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=greedy-algorithms
    // MinMax  Unfairness   #greedy

    /*
    [1,4,7,2]  k=2
     */

    static int maxMin(int k, List<Integer> arr) {
        Collections.sort(arr);
        int minUnfairness = Integer.MAX_VALUE;

        for (int i = 0; i <= arr.size() - k; i++) {
            int unfairness = arr.get(i + k - 1)  - arr.get(i);
            minUnfairness = Math.min(minUnfairness, unfairness);
        }

        return minUnfairness;
    }

    public static void main(String[] args) {
        List<Integer> test1 = Arrays.asList(1,4,7,2);
        int k =2;
        int result = maxMin(k, test1);

        System.out.println(test1 + " K is: " + k + " MinMax  Unfairness: " + result);



    }


}
