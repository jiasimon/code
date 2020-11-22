package com.sjia.Leetcode;

import java.util.*;

public class WordBreak {
    // #139 https://leetcode.com/problems/word-break/   #fb #dp

    // dp[i] 表示字符串 s 前 i 个字符组成的字符串 s[0..i−1]是否能被空格拆分成若干个字典中出现的单词

    // Input: s = "applepenapple", wordDict = ["apple", "pen"]
    // Output: true     Note that you are allowed to reuse a dictionary word


    // list to Hashset, dynamic Programming
    // Runtime: 6 ms, faster than 60.71% of Java online submissions for Word Break.
    //Memory Usage: 39.4 MB, less than 43.23% of Java online submissions for Word Break.
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() +1];
        dp[0] = true;
        for (int i=1; i< s.length() + 1 ; i++) {
            for (int j=0; j < i; j++) {
                if(dp[j] && wordSet.contains(s.substring(j,i))){
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }


    // Optimize, use maxLength in wordDict, reverse check
    // Runtime: 1 ms, faster than 97.93% of Java online submissions for Word Break.
    //Memory Usage: 37.2 MB, less than 97.05% of Java online submissions for Word Break.
    public boolean wordBreak2(String s, List<String> wordDict) {
        int maxL =0;
        Set<String> wordSet = new HashSet<>(wordDict);
        for (String word : wordDict) {
            maxL = Math.max(maxL, word.length());
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i-1; j >=0 && j >= i - maxL; j--) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }



/*    public boolean wordBreak(String s, Set<String> dict) {

        boolean[] f = new boolean[s.length() + 1];

        f[0] = true;

        *//* First DP
        for(int i = 1; i <= s.length(); i++){
            for(String str: dict){
                if(str.length() <= i){
                    if(f[i - str.length()]){
                        if(s.substring(i-str.length(), i).equals(str)){
                            f[i] = true;
                            break;
                        }
                    }
                }
            }
        }*//*

        //Second DP
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && dict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }

        return f[s.length()];
    }*/





}
