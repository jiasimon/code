package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestWordDic {
    // #720 https://leetcode.com/problems/longest-word-in-dictionary/
    // return the longest word with the smallest lexicographical order.
    // words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]

    //["b","br","bre","brea","break","breakf","breakfa","breakfas","breakfast","l","lu","lun","lunc","lunch","d","di","din","dinn","dinne","dinner"]

    // Runtime: 23 ms, faster than 40.85% of Java online submissions for Longest Word in Dictionary.
    //Memory Usage: 46.3 MB, less than 25.55% of Java online submissions for Longest Word in Dictionary.
    public String longestWord(String[] words) {
        String result = "";
        Arrays.sort(words);
        Set<String> tmp = new HashSet<>();
        for (String str: words) {
            if ( str.length()==1 || tmp.contains(str.substring(0, str.length()-1 ))) {
                if ( str.length() > result.length() ) {
                    result = str;
                }
                tmp.add(str);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        String[] testData  = { "ts", "e", "x"};
        //String[] testData  = { "a", "banana", "app", "appl", "ap", "apply", "apple" };
        // String[] testData  = { "b","br","bre","brea","break","breakf","breakfa","breakfas","breakfast",
                "l","lu","lun","lunc","lunch","d","di","din","dinn","dinne","dinner"};

        LongestWordDic solution = new LongestWordDic();

        String result = solution.longestWord(testData);

        System.out.printf(" input %s longestWord: %s ", Arrays.toString(testData), result);
    }

}
