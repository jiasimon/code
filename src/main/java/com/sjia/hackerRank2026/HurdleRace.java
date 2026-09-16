package com.sjia.hackerRank2026;

import java.util.Collections;
import java.util.List;

public class HurdleRace {
    // https://www.hackerrank.com/challenges/the-hurdle-race

    // Collections.max(height)
    // Collections.max(height) throws NoSuchElementException if height is empty
    public static int hurdleRace(int k, List<Integer> height) {
        int maxHeight = Collections.max(height);
        if (k >= maxHeight) {
            return 0;
        } else {
            return maxHeight-k;
        }
    }

}
