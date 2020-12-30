package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class OccurrencesAfterBigram {
    // #1078    https://leetcode.com/problems/occurrences-after-bigram/

    /*
        1 <= text.length <= 1000
        text consists of space separated words, where each word consists of lowercase English letters.
        1 <= first.length, second.length <= 10
        first and second consist of lowercase English letters.

     */

    // Input: text = "alice is a good girl she is a good student", first = "a", second = "good"
    // Output: ["girl","student"]
    // put: text = "we will we will rock you", first = "we", second = "will"
    // Output: ["we","rock"]

    // Runtime: 3 ms, faster than 17.98% of Java online submissions for Occurrences After Bigram.
    // Memory Usage: 37.4 MB, less than 41.41% of Java online submissions for Occurrences After Bigram.
    public String[] findOcurrences(String text, String first, String second) {
        String[] tmp = text.split("\\s+");
        List<String> res = new ArrayList<>();
        for (int i=2; i< tmp.length; i++) {
            if(tmp[i-2].equals(first) && tmp[i-1].equals(second)){
                res.add(tmp[i]);
            }
        }
        return res.toArray(new String[0]);
    }


    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Occurrences After Bigram.
    //Memory Usage: 37.3 MB, less than 57.57% of Java online submissions for Occurrences After Bigram.
    public String[] findOcurrences2(String text, String first, String second) {
        String[] tmp = text.split(" ");
        List<String> res = new ArrayList<>();
        for (int i=2; i< tmp.length; i++) {
            if(tmp[i-2].equals(first) && tmp[i-1].equals(second)){
                res.add(tmp[i]);
            }
        }
        return res.toArray(new String[0]);
    }


}
