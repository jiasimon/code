package com.sjia.Leetcode;

import static java.lang.Math.abs;

public class ShortestWordDistance {

    // #243 https://leetcode.com/problems/shortest-word-distance/
    public int shortestDistance(String[] words, String word1, String word2) {
        int a = -1, b = -1, result = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i])) a = i;
            else if (word2.equals(words[i])) {
                b = i;
            }
            if (a != -1 && b != -1) {
                result = Math.min(result, Math.abs(b - a));
                if (result == 1) return result;
            }

        }
        return result;
    }

}
