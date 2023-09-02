package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExtraCharactersInString {
    // #2707. Extra Characters in a String  https://leetcode.com/problems/extra-characters-in-a-string/?envType=daily-question&envId=2023-09-02

    /*
    You are given a 0-indexed string s and a dictionary of words dictionary. You have to break s into one or more non-overlapping substrings such that each substring is present in dictionary. There may be some extra characters in s which are not present in any of the substrings.

    Return the minimum number of extra characters left over if you break up s optimally.

    Input: s = "leetscode", dictionary = ["leet","code","leetcode"]     Output: 1
    Explanation: We can break s in two substrings: "leet" from index 0 to 3 and "code" from index 5 to 8. There is only 1 unused character (at index 4), so we return 1.

    Input: s = "sayhelloworld", dictionary = ["hello","world"]          Output: 3
    Explanation: We can break s in two substrings: "hello" from index 3 to 7 and "world" from index 8 to 12. The characters at indices 0, 1, 2 are not used in any substring and thus are considered as extra characters. Hence, we return 3.
     */



    // dp[j] + i-j)
    // 43 ms, 65.43%; 44.4 MB, 40%
    public int minExtraChar(String s, String[] dictionary) {
        final int n = s.length();

        Set<String> dictSet = new HashSet<>(Arrays.asList(dictionary));

        // dp[i] : min extra characters if breaking up s[0:i] optimally
        int[] dp = new int[n+1];
        Arrays.fill(dp, n);
        dp[0] = 0;

        for (int i = 1; i<= n; i++) {
            for ( int j=0; j < i ; j++) {
                // s[j..i) is in dictionarySet.
                if (dictSet.contains(s.substring(j,i))) {
                    dp[i] = Math.min(dp[i], dp[j]);
                } else {
                    dp[i] = Math.min(dp[i] , dp[j] + i-j);
                }

            }
        }

        return dp[n];
    }



    public int minExtraCharacters(String s, List<String> dictionary) {
        Set<String> dictSet = new HashSet<>(dictionary);
        int n = s.length();
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = i; // Initialize to the worst case: all characters are extra
            for (int j = 0; j < i; j++) {
                String substring = s.substring(j, i);
                if (dictSet.contains(substring)) {
                    dp[i] = Math.min(dp[i], dp[j]);
                } else {
                    dp[i] = Math.min(dp[i], dp[j] + i - j);
                }
            }
        }

        return dp[n];
    }



    public static void main(String[] args) {
        ExtraCharactersInString solution = new ExtraCharactersInString();
        String s1 = "leetscode";
//        List<String> dictionary1 = List.of("leet", "code", "leetcode");

        List<String> dictionary1 = Arrays.asList("leet", "code", "leetcode");
        int result1 = solution.minExtraCharacters(s1, dictionary1);
        System.out.println("Output 1: " + result1); // Output: 1

        String s2 = "sayhelloworld";
//        List<String> dictionary2 = List.of("hello", "world");
        List<String> dictionary2 = Arrays.asList("hello", "world");
        int result2 = solution.minExtraCharacters(s2, dictionary2);
        System.out.println("Output 2: " + result2); // Output: 3
    }


}
