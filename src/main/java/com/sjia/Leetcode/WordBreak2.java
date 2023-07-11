package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak2 {
    // #140. Word Break II  https://leetcode.com/problems/word-break-ii/
    /*
    Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word.
    Return all such possible sentences in any order.

    Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]   Output: ["cats and dog","cat sand dog"]
    Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
    Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]

    1 <= s.length <= 20
    1 <= wordDict.length <= 1000
     */

    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, List<String>> memo = new HashMap<>();
        return wordBreakHelper(s, wordDict, 0, memo);
    }

    private List<String> wordBreakHelper(String s, List<String> wordDict, int start, Map<Integer, List<String>> memo) {
        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        List<String> result = new ArrayList<>();
        if (start == s.length()) {
            result.add("");
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String substring = s.substring(start, end);
            if (wordDict.contains(substring)) {
                List<String> nextWords = wordBreakHelper(s, wordDict, end, memo);
                for (String nextWord : nextWords) {
                    String space = nextWord.isEmpty() ? "" : " ";
                    result.add(substring + space + nextWord);
                }
            }
        }

        memo.put(start, result);
        return result;
    }





}
