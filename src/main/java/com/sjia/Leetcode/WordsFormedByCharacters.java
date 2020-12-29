package com.sjia.Leetcode;

public class WordsFormedByCharacters {
    // #1160  https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/

    // Input: words = ["cat","bt","hat","tree"], chars = "atach"    Output: 6
    // strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.

    // Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr" Output: 10
    // strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10

    // 1 <= words.length <= 1000
    // 1 <= words[i].length, chars.length <= 100
    // All strings contain lowercase English letters only.


    // Runtime: 6 ms, faster than 77.80% of Java online submissions for Find Words That Can Be Formed by Characters.
    // Memory Usage: 39.4 MB, less than 78.19% of Java online submissions for Find Words That Can Be Formed by Characters.
    public int countCharacters(String[] words, String chars) {
        int[] count = new int[26];
        int res =0;

        for (char c : chars.toCharArray()){
            count[c -'a']++;
        }

        for (String word : words) {
            int[] tmp = count.clone();
            boolean flag = true;
            for (char c : word.toCharArray()) {
                tmp[c-'a']--;
                if (tmp[c-'a']<0) {
                    flag = false;
                    break;
                }
            }
            if (flag) res += word.length();
        }
        return res;

    }


    // continue outer
    // Runtime: 6 ms, faster than 77.80% of Java online submissions for Find Words That Can Be Formed by Characters.
    //Memory Usage: 39 MB, less than 99.44% of Java online submissions for Find Words That Can Be Formed by Characters.
    public int countCharacters2(String[] words, String chars) {
        int[] count = new int[26];
        int res =0;

        for (char c : chars.toCharArray()){
            count[c -'a']++;
        }

        outer:
        for (String word : words) {
            int[] tmp = count.clone();
            for (char c : word.toCharArray()) {
                tmp[c-'a']--;
                if (tmp[c-'a']<0) {
                    continue outer;
                }
            }
            res += word.length();
        }
        return res;

    }




}
