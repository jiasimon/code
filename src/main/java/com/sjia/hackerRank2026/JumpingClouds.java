package com.sjia.hackerRank2026;

import java.util.List;

public class JumpingClouds {
    // https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem

    public static int jumpingOnClouds(List<Integer> c) {
        int res=0;
        int i =0;
        while (i < c.size()-1) {
            if (i+2 < c.size() && c.get(i+2)==0) {
                i +=2;
            } else {
                i++;
            }
            res++;
        }
        return res;
    }

    

}
