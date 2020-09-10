package com.sjia.Leetcode;

import java.util.*;

public class MostCommonWord {
    // #819 https://leetcode.com/problems/most-common-word/
    // remove all punctuations
    //change to lowercase
    //words count for each word not in banned set
    //return the most common word

    // Runtime: 17 ms, faster than 50.19% of Java online submissions for Most Common Word.
    //Memory Usage: 39.9 MB, less than 51.88% of Java online submissions for Most Common Word.
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned) );

        Map<String, Integer> count = new HashMap<>();

        String[] words = paragraph.replaceAll("\\W+" , " ")
                .toLowerCase().split("\\s+");

        for (String word : words){
            if(!bannedSet.contains(word)) {
                count.put(word, count.getOrDefault(word,0)+1 );
            }
        }

        String result = Collections.max(count.entrySet(), Map.Entry.comparingByValue()).getKey();
        return result;

    }


}
