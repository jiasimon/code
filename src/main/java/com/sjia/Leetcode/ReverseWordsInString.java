package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.Collections;

public class ReverseWordsInString {
    // #151 https://leetcode.com/problems/reverse-words-in-a-string/

    // Input: s = "  hello world  " Output: "world hello"
    // Input: s = "a good   example"    Output: "example good a"
    // Input: s = "  Bob    Loves  Alice   "    Output: "Alice Loves Bob"
    // 1 <= s.length <= 104
    // s contains English letters (upper-case and lower-case), digits, and spaces ' '.
    // There is at least one word in s.

    // Runtime: 8 ms, faster than 45.07% of Java online submissions for Reverse Words in a String.
    // Memory Usage: 39.3 MB, less than 54.46% of Java online submissions for Reverse Words in a String.
    public String reverseWords(String s) {
        String[] tmp = s.trim().split("\\s+");
        Collections.reverse(Arrays.asList(tmp));
        return String.join(" ", tmp);

    }

}
