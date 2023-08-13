package com.sjia.hackerRank;

import java.util.*;

public class MaximumSubarraySumMod {
    // https://www.hackerrank.com/challenges/maximum-subarray-sum/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=search

    /*
    maximumSum_success
    ===
    846930887   846930887   null        846930887
    1681692778  724334281   846930887   1681692778
    1714636916  634681813   724334281   1714636916
    1745498720  788140223   846930887   1957747794


    maximumSum_failed
    ====
    846930887	846930887	0		846930887
    1681692778	724334281	846930887	1681692778
    1681692778	634681813	846930887	1714636916
    1745498720	788140223	846930887	1957747794
     */

    public static long maximumSum_failed(List<Long> a, long m) {
        // Write your code here
        long prefix = 0;
        long res = 0;
        Set<Long> set = new HashSet<>();
        set.add(0L);

        for (Long tmp : a) {
            prefix = (prefix + tmp) % m;
            res = Math.max(res, prefix);

//            long p = 0;
            long p = Long.MAX_VALUE;

            for (long j : set) {
                if (j >= prefix + 1) {
//                    p = j;
                    p = Math.min(p, j);
                }


            }

//            if (p != 0)
            if (p != Long.MAX_VALUE)
            {
                res = Math.max(res, (prefix - p + m ) );
            }
            set.add(prefix);
        }
        return res;
    }



    public static long maximumSum_binary(List<Long> a, long m) {
        // Write your code here
        long prefix = 0;
        long res = 0;
        List<Long> list = new ArrayList<>();

        for (Long tmp : a) {
            prefix = (prefix + tmp) % m;
            res = Math.max(res, prefix);

            int index = Collections.binarySearch(list, prefix + 1);
            if ( index < 0) index = -(index+1);
            if ( index < list.size()) {
                res = Math.max(res, (prefix - list.get(index) + m ) );
            }


            list.add(prefix);
            Collections.sort(list);
        }
        return res;
    }


    public static void main(String[] args) {
//        List<Integer> test1 = Arrays.asList(3,3,9,9,5);

        List<Long> test1 = Arrays.asList(846930887L, 1681692778L, 1714636916L, 1957747794L, 424238336L, 719885387L, 1649760493L, 596516650L, 1189641422L, 1025202363L, 1350490028L, 783368691L, 1102520060L, 2044897764L, 1967513927L, 1365180541L, 1540383427L, 304089173L, 1303455737L, 35005212L, 521595369L, 294702568L, 1726956430L, 336465783L, 861021531L, 278722863L, 233665124L, 2145174068L, 468703136L, 1101513930L, 1801979803L, 1315634023L, 635723059L, 1369133070L, 1125898168L, 1059961394L, 2089018457L, 628175012L, 1656478043L, 1131176230L, 1653377374L, 859484422L, 1914544920L, 608413785L, 756898538L, 1734575199L, 1973594325L, 149798316L, 2038664371L, 1129566414L);

        System.out.println(test1 + " MaximumSubarraySum Mod: " + maximumSum_binary(test1,1804289384));
        // init return :  Mod: 1799709226;   expected: 1802192837
    }


}
