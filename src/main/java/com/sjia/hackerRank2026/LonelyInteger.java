package com.sjia.hackerRank2026;

import java.util.List;

public class LonelyInteger {
    public static int lonelyinteger(List<Integer> a) {
        int size = a.size();
//        if (size < 2) return a.get(0);
        int res = a.get(0);
        for(int i=1; i< size; i++ ){
            res ^= a.get(i);
        }
        return res;
    }

}
