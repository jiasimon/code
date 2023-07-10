package com.sjia.Leetcode;

import java.util.*;

public class WordBreak {
    // #139. Word Break  https://leetcode.com/problems/word-break/   #fb #dp

    // dp[i] 表示字符串 s 前 i 个字符组成的字符串 s[0..i−1]是否能被空格拆分成若干个字典中出现的单词

    /*
    Input: s = "applepenapple", wordDict = ["apple", "pen"]
    Output: true     Note that you are allowed to reuse a dictionary word

    Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
    Output: false

    1 <= s.length <= 300
    1 <= wordDict.length <= 1000
    1 <= wordDict[i].length <= 20
    s and wordDict[i] consist of only lowercase English letters.
     */




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



    // BFS , queue
    // 10 ms, 28.19% ; 43.7 MB, 37.98%
    public boolean wordBreakQueue(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] seen = new boolean[s.length() + 1];
        queue.add(0);


        while (!queue.isEmpty()) {
            int start = queue.poll();
            if (start == s.length()) {
                return true;
            }

            for (int end = start + 1; end <= s.length(); end++) {
                if (seen[end]) {
                    continue;
                }

                if (words.contains(s.substring(start, end))) {
                    queue.add(end);
                    seen[end] = true;
                }
            }
        }

        return false;
    }


    // recursive, TLE
    public boolean wordBreakRecursive(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        return wb(s, set);
    }
    private boolean wb(String s, Set<String> set) {
        int len = s.length();
        if (len == 0) {
            return true;
        }
        for (int i = 1; i <= len; ++i) {
            if (set.contains(s.substring(0, i)) && wb(s.substring(i), set)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        WordBreak solution = new WordBreak();

        // Test case
        String s = "leetcodeleet";
        List<String> wordDict = Arrays.asList("leet", "code");
        boolean result = solution.wordBreakRecursive(s, wordDict);

        // Print the result
        System.out.println("Can Break Word: " + s + " , result: "  + result);  // Output: true

        String s2 = "catsandog";
        List<String> wordDict2 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        boolean result2 = solution.wordBreakRecursive(s2, wordDict2);
        System.out.println("Can Break Word: " + s2 + " , result: " + result2);  // Output: false

    }



}
