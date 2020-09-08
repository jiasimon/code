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


}
