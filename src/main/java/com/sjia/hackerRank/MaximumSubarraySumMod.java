package com.sjia.hackerRank;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaximumSubarraySumMod {
    // https://www.hackerrank.com/challenges/maximum-subarray-sum/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=search

    /*

     */

    public static long maximumSum(List<Integer> a, long m) {
        // Write your code here
        long prefix = 0;
        long res = 0;
        Set<Long> set = new HashSet<Long>();
        set.add(0L);

        for (Integer tmp : a) {
            prefix = (prefix + tmp) % m;
            res = Math.max(res, prefix);
            long p = 0;

            for (long j : set) {
                if (j >= prefix + 1)
                    p = j;
            }

            if (p != 0)
            {
                res = Math.max(res, prefix - p + m);
            }
            set.add(prefix);
        }
        return res;
    }


    public static void main(String[] args) {
//        List<Integer> test1 = Arrays.asList(3,3,9,9,5);

        List<Integer> test1 = Arrays.asList(846930887, 1681692778, 1714636916, 1957747794, 424238336, 719885387, 1649760493, 596516650, 1189641422, 1025202363, 1350490028, 783368691, 1102520060, 2044897764, 1967513927, 1365180541, 1540383427, 304089173, 1303455737, 35005212, 521595369, 294702568, 1726956430, 336465783, 861021531, 278722863, 233665124, 2145174068, 468703136, 1101513930, 1801979803, 1315634023, 635723059, 1369133070, 1125898168, 1059961394, 2089018457, 628175012, 1656478043, 1131176230, 1653377374, 859484422, 1914544920, 608413785, 756898538, 1734575199, 1973594325, 149798316, 2038664371, 1129566414);

        System.out.println(test1 + " MaximumSubarraySum Mod: " + maximumSum(test1,1804289384));
    }


}
