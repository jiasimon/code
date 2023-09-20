package com.sjia.Leetcode;

public class LCP06GrabCoin {
    // #LCP06   https://leetcode.cn/problems/na-ying-bi/

    /*
    N pile coins, can get 1 or 2 coin for one pile,
    Minimum number to remove all coins
     */

    public int minCount(int[] coins) {
        int res = 0;
        for ( int c : coins) {
            res += (c + 1) /2;
        }
        return res;

    }

    
}
