package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistance2 {
    // #244. Shortest Word Distance II  https://leetcode.ca/2016-07-31-244-Shortest-Word-Distance-II/   #premium


    /*
    Design a data structure that will be initialized with a string array,
    and then it should answer queries of the shortest distance between two different strings from the array.
     */



    // HashMap,  two pointer

    private Map<String, List<Integer>> wordPositions;

    public ShortestWordDistance2(String[] words) {
        wordPositions = new HashMap<>();

        // Preprocess the words and store their positions in the wordPositions map
        for (int i = 0; i < words.length; i++) {
            wordPositions.putIfAbsent(words[i], new ArrayList<>());
            wordPositions.get(words[i]).add(i);
        }
    }

    public int shortest(String[] words, String word1, String word2) {

/*
        Map<String, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            map.putIfAbsent(words[i], new ArrayList<>());
            map.get(words[i]).add(i);
        }
*/

        List<Integer> index1 = wordPositions.get(word1);
        List<Integer> index2 = wordPositions.get(word2);

        int res = Integer.MAX_VALUE;
        // use two pointer

        int i=0, j=0;
        while ( i < index1.size() && j < index2.size() ) {
            int p1 = index1.get(i);
            int p2 = index2.get(j);
            res = Math.min (res, Math.abs(p1 -p2));
            if (p1 < p2) {
                i++;
            } else {
                j++;
            }
        }

        return res;

    }



}
