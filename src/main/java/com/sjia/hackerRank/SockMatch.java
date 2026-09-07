package com.sjia.hackerRank;

import java.util.List;

public class SockMatch {
    // https://www.hackerrank.com/challenges/one-month-preparation-kit-sock-merchant

    public static int sockMerchant(int n, List<Integer> ar) {
        int[] count = new int[101];
        for (int tmp : ar) {
            count[tmp]++;
        }
        int res=0;
        for (int d : count){
            if (d !=0) {
                res += d/2;
            }
        }
        return res;

    }

}
