package com.sjia.Leetcode;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseWords {
    // #804 https://leetcode.com/problems/unique-morse-code-words/
    // {".-","-...","-.-.","-..",".","..-.","--.",
    //                         "....","..",".---","-.-",".-..","--","-.",
    //                         "---",".--.","--.-",".-.","...","-","..-",
    //                         "...-",".--","-..-","-.--","--.."};

    // Runtime: 1 ms, faster than 100.00% of Java online submissions for Unique Morse Code Words.
    //Memory Usage: 37.3 MB, less than 90.25% of Java online submissions for Unique Morse Code Words.
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = new String[] {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> res = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                sb.append(morse[ c - 'a']);
            }
            res.add(sb.toString());
        }
        return res.size();
    }


}
