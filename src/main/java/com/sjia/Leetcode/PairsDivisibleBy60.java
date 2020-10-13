package com.sjia.Leetcode;

public class PairsDivisibleBy60 {

    // #1010 https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/

    // 1 <= time.length <= 60000
    // 1 <= time[i] <= 500


    // new int[60]
    // Runtime: 2 ms, faster than 99.41% of Java online submissions for Pairs of Songs With Total Durations Divisible by 60.
    // Memory Usage: 44.3 MB, less than 8.49% of Java online submissions for Pairs of Songs With Total Durations Divisible by 60.
    public int numPairsDivisibleBy60(int[] time) {
        int[] tmp = new int[60];
        for ( int t: time){
            tmp[t%60]++;
        }
        int res = tmp[0]* (tmp[0]-1)/2 + tmp[30]* (tmp[30]-1)/2;
        for (int i=1; i<30; i++) {
            res += tmp[i] * tmp[60-i];
        }
        return res;
    }


}
