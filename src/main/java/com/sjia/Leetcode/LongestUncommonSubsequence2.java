package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestUncommonSubsequence2 {
    // #522. Longest Uncommon Subsequence II    https://leetcode.com/problems/longest-uncommon-subsequence-ii/

    /*
    Given an array of strings strs, return the length of the longest uncommon subsequence between them. If the longest uncommon subsequence does not exist, return -1.

    Input: strs = ["aba","cdc","eae"]   Output: 3
    Input: strs = ["aaa","aaa","aa"]    Output: -1

    2 <= strs.length <= 50
    1 <= strs[i].length <= 10
    strs[i] consists of lowercase English letters.
     */


    // Arrays.sort, set
    // 3 ms, 18.52%; 40.7 MB, 31.48%
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, (a, b) -> b.length() - a.length());

        Set<String> duplicates = findDuplicates(strs);

        for (int i = 0; i < strs.length; i++) {
            if (!duplicates.contains(strs[i])) {
                if (i == 0) {
                    return strs[0].length();
                }

                for (int j = 0; j < i; j++) {
                    if (isSubsequence(strs[j], strs[i])) {
                        break;
                    }
                    if (j == i - 1) {
                        return strs[i].length();
                    }
                }
            }
        }

        return -1;
    }

    private boolean isSubsequence(String a, String b) {
        int i = 0, j = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == b.length();
    }

    private Set<String> findDuplicates(String[] strs) {
        Set<String> duplicates = new HashSet<>();
        Set<String> seen = new HashSet<>();

        for (String str : strs) {
            if (!seen.add(str)) {
                duplicates.add(str);
            }
        }

        return duplicates;
    }

    public static void main(String[] args) {
        LongestUncommonSubsequence2 solution = new LongestUncommonSubsequence2();

        String[] input = {"aba", "cdc", "eae"};

        int length = solution.findLUSlength(input);
        System.out.println("Length of the longest uncommon subsequence: " + length);
    }


}
