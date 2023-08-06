package com.sjia.Leetcode;

import java.util.*;

public class PalindromePairs {
    // #336. Palindrome Pairs   https://leetcode.com/problems/palindrome-pairs/
    /*
    You are given a 0-indexed array of unique strings words.

    A palindrome pair is a pair of integers (i, j) such that:

    0 <= i, j < words.length,
    i != j, and
    words[i] + words[j] (the concatenation of the two strings) is a
    palindrome
    .
    Return an array of all the palindrome pairs of words.

    Input: words = ["abcd","dcba","lls","s","sssll"]    Output: [[0,1],[1,0],[3,2],[2,4]]
    Explanation: The palindromes are ["abcddcba","dcbaabcd","slls","llssssll"]


     */



    // brute force
    // TLE 134 / 136
    public List<List<Integer>> palindromePairs_brute(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        int n = words.length;

        for (int i=0; i < n; i++) {
            for (int j= i+1; j < n; j++) {
                if (isPalindrome(words[i]+words[j])) {
                    res.add(Arrays.asList(i, j));
                }
                if (isPalindrome(words[j]+words[i])) {
                    res.add(Arrays.asList(j, i));
                }
            }
        }
        return res;

    }

    private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    // 3 Cases, prefix, suffix
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        Map<String, Integer> wordIndexMap = new HashMap<>();

        // Build a map of reversed words along with their indices
        for (int i = 0; i < words.length; i++) {
            wordIndexMap.put(new StringBuilder(words[i]).reverse().toString(), i);
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int wordLen = word.length();

            // Case 1: Check if the word itself is a palindrome, and there exists an empty string in the list
            if (wordIndexMap.containsKey("") && isPalindrome(word) && wordIndexMap.get("") != i) {
                result.add(Arrays.asList(i, wordIndexMap.get("")));
                result.add(Arrays.asList(wordIndexMap.get(""), i));
            }

            // Case 2: Check if the reverse of the current word exists in the list
//            String reversedWord = new StringBuilder(word).reverse().toString();
            if (wordIndexMap.containsKey(word) && wordIndexMap.get(word) != i) {
                result.add(Arrays.asList(i, wordIndexMap.get(word)));
            }

            // Case 3: Check for palindrome prefixes and suffixes
            for (int j = 1; j < wordLen; j++) {
                String prefix = word.substring(0, j);
                String suffix = word.substring(j);

                if (isPalindrome(prefix) && wordIndexMap.containsKey(suffix) && wordIndexMap.get(suffix) != i) {
                    result.add(Arrays.asList(wordIndexMap.get(suffix), i));
                }

                if (isPalindrome(suffix) && wordIndexMap.containsKey(prefix) && wordIndexMap.get(prefix) != i) {
                    result.add(Arrays.asList(i, wordIndexMap.get(prefix)));
                }
            }
        }

        return result;
    }



    public List<List<Integer>> palindromePairs2(String[] words) {
        List<List<Integer>> ret = new ArrayList<>();
        if (words == null || words.length < 2) return ret;
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i=0; i<words.length; i++) map.put(words[i], i);
        for (int i=0; i<words.length; i++) {
            for (int j=0; j<=words[i].length(); j++) { // notice it should be "j <= words[i].length()"
                String str1 = words[i].substring(0, j);
                String str2 = words[i].substring(j);
                if (isPalindrome(str1)) {
                    String str2rvs = new StringBuilder(str2).reverse().toString();
                    if (map.containsKey(str2rvs) && map.get(str2rvs) != i) {
//                        List<Integer> list = new ArrayList<Integer>();
//                        list.add(map.get(str2rvs));
//                        list.add(i);
//                        ret.add(list);
                        // System.out.printf("isPal(str1): %s\n", list.toString());
                    }
                }
                if (isPalindrome(str2)) {
                    String str1rvs = new StringBuilder(str1).reverse().toString();
                    // check "str.length() != 0" to avoid duplicates
                    if (map.containsKey(str1rvs) && map.get(str1rvs) != i && str2.length()!=0) {
//                        List<Integer> list = new ArrayList<Integer>();
//                        list.add(i);
//                        list.add(map.get(str1rvs));
//                        ret.add(list);
                        // System.out.printf("isPal(str2): %s\n", list.toString());
                    }
                }
            }
        }
        return ret;
    }


    public static void main(String[] args) {
        PalindromePairs solution = new PalindromePairs();
        String[] words = {"abcd", "dcba", "lls", "s", "sssll"};
        List<List<Integer>> result = solution.palindromePairs(words);
        System.out.println(result); // Output: [[0, 1], [1, 0], [3, 2], [2, 4]]

        String[] words2 = {"a", ""};
        result = solution.palindromePairs(words2);
        System.out.println(result);
    }


}
