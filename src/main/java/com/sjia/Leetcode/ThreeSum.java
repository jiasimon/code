package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
    // #15 https://leetcode.com/problems/3sum/
    // Given an array nums of n integers, are there elements a, b, c in nums
    // such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

    //ArrayList, Runtime: 32 ms, faster than 51.21% of Java online submissions for 3Sum.
    //Memory Usage: 56.5 MB, less than 9.93% of Java online submissions for 3Sum.

    //LinkedList Runtime: 41 ms, faster than 38.43% of Java online submissions for 3Sum.
    //Memory Usage: 56.6 MB, less than 9.42% of Java online submissions for 3Sum.

    // add "if (num.length < 2 ) return new ArrayList<>();"
    // Runtime: 31 ms, faster than 53.37% of Java online submissions for 3Sum.
    //Memory Usage: 56.5 MB, less than 10.35% of Java online submissions for 3Sum.

    // if (num[0] > 0 || num[num.length -1] < 0 ) return new ArrayList<>();
    // Memory Usage: 43.4 MB, less than 74.51% of Java online submissions for 3Sum.

    static List<List<Integer>> threeSum(int[] num) {
        if (num.length < 2 ) return new ArrayList<>();
        Arrays.sort(num);
        if (num[0] > 0 || num[num.length-1] < 0 || (num[0]==0 && num[1]!=0) ||
                (num[num.length-1] ==0 && num[num.length-2] != 0) ) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        //System.out.printf("[ %d %d %d ]", num[i], num[lo], num[hi]);
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++; hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;

    }





    public static void main(String[] args) {

        // {-1, 0, 1, 2, -1, -4}
        // [ -1 -1 2 ][ -1 0 1 ]

        int[] testData = {1, 1, 2, 4 ,8 ,10};
        //int[] testData  = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(testData);

        System.out.printf(" Three sum result is %s \n", result);
    }

}
