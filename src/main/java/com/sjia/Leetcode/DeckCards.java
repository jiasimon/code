package com.sjia.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class DeckCards {
    // #914 https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/

    // Runtime: 11 ms, faster than 20.44% of Java online submissions for X of a Kind in a Deck of Cards.
    //Memory Usage: 49.3 MB, less than 17.44% of Java online submissions for X of a Kind in a Deck of Cards.
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : deck) {
            map.put(x,map.getOrDefault(x,0)+1);
        }
        int result =0;
        for ( int v : map.values()) {
            result = gcd(result, v);
            if (result ==1 ) return false;
        }
        return result > 1;
    }

    private int gcd(int a, int b) {
        if (b==0) return a;
        else return gcd(b, a%b);
    }


    // Runtime: 7 ms, faster than 67.23% of Java online submissions for X of a Kind in a Deck of Cards.
    //Memory Usage: 39.4 MB, less than 90.92% of Java online submissions for X of a Kind in a Deck of Cards.
/*    private int gcd(int a, int b) {
        return b==0 ? a : gcd (b, a%b);
    }*/




}
