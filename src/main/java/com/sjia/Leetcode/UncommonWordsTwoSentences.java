package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UncommonWordsTwoSentences {
    // #884 https://leetcode.com/problems/uncommon-words-from-two-sentences/


    // Runtime: 1 ms, faster than 100.00% of Java online submissions for Uncommon Words from Two Sentences.
    //Memory Usage: 37.9 MB, less than 92.78% of Java online submissions for Uncommon Words from Two Sentences.
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> count = new HashMap<>();
        for (String word: A.split(" ")) {
            count.put(word, count.getOrDefault(word,0)+1);
        }
        for (String word: B.split(" ")) {
            count.put(word, count.getOrDefault(word,0)+1);
        }
        List<String> res = new ArrayList<>();
        for (String w : count.keySet()) {
            if(count.get(w) == 1) {
                res.add(w);
            }
        }
        return res.toArray(new String[res.size()]);

    }


    // use List<String> res = new LinkedList<>();
    // Runtime: 2 ms, faster than 75.02% of Java online submissions for Uncommon Words from Two Sentences.
    //Memory Usage: 37.8 MB, less than 98.20% of Java online submissions for Uncommon Words from Two Sentences.

}
