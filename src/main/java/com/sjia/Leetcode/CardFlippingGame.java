package com.sjia.Leetcode;

import java.util.HashSet;
import java.util.Set;

public class CardFlippingGame {
    // #822 https://leetcode.com/problems/card-flipping-game/

    /*
    On a table are N cards, with a positive integer printed on the front and back
    We flip any number of cards, and after we choose one card.
    If the number X on the back of the chosen card is not on the front of any card, then this number X is good.
    If no number is good, output 0.

     */

    // Input: fronts = [1,2,4,4,7], backs = [1,3,4,1,3]     Output: 2

    // 1 <= fronts.length == backs.length <= 1000.
    // 1 <= fronts[i] <= 2000.
    // 1 <= backs[i] <= 2000

    // Runtime: 2 ms, faster than 86.49% of Java online submissions for Card Flipping Game.
    // Memory Usage: 38.7 MB, less than 83.78% of Java online submissions for Card Flipping Game.
    public int flipgame(int[] fronts, int[] backs) {
        Set<Integer> tmp = new HashSet<>();
        for (int i=0; i < fronts.length; i++) {
            if(fronts[i] == backs[i]) tmp.add(fronts[i]);
        }

        int res= 2000;

        for (int j : fronts) {
            if(!tmp.contains(j)) res = Math.min(res, j);
        }
        for (int k: backs) {
            if(!tmp.contains(k)) res = Math.min(res, k);
        }
        return res % 2000;

    }



    // Runtime: 2 ms, faster than 86.49% of Java online submissions for Card Flipping Game.
    // Memory Usage: 39.2 MB, less than 37.84% of Java online submissions for Card Flipping Game.
    public int flipgame2(int[] fronts, int[] backs) {
        Set<Integer> tmp = new HashSet<>();
        for (int i=0; i < fronts.length; i++) {
            if(fronts[i] == backs[i]) tmp.add(fronts[i]);
        }

        int res= 2000;


        for (int i=0; i < fronts.length; i++) {
            if(!tmp.contains(fronts[i])) res = Math.min(res, fronts[i]);
            if(!tmp.contains(backs[i])) res = Math.min(res, backs[i]);
        }
        return res % 2000;

    }


}
