package com.sjia.Leetcode;

import java.util.HashSet;
import java.util.Set;

public class JewelsStones {
    // #771 https://leetcode.com/problems/jewels-and-stones/
    // Input: J = "aA", S = "aAAbbbb",  Output: 3

    // Runtime: 1 ms, faster than 82.03% of Java online submissions for Jewels and Stones.
    //Memory Usage: 37.9 MB, less than 77.33% of Java online submissions for Jewels and Stones.
    public int numJewelsInStones(String J, String S) {
        int result=0;
        Set<Character> jewel = new HashSet<>();
        for( char c : J.toCharArray()) {
            jewel.add(c);
        }
        for(char s : S.toCharArray()) {
            if (jewel.contains(s)) result++;
        }
        return result;
    }


    // use array is faster
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Jewels and Stones.
    //Memory Usage: 37.9 MB, less than 73.41% of Java online submissions for Jewels and Stones.
/*
    public int numJewelsInStones(String J, String S) {
        int result=0;
        int[] tmp = new int[58];  // 'z' - 'A' is 58
        for( char c : J.toCharArray()) {
            tmp[c - 'A'] = 1;
        }
        for(char s : S.toCharArray()) {
            result += tmp[s - 'A'];
        }
        return result;
    }*/



}
