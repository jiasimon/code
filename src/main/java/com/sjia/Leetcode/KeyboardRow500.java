package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeyboardRow500 {
    // #500. Keyboard Row   https://leetcode.com/problems/keyboard-row/description/

    /*
    Given an array of strings words, return the words that can be typed using letters of the alphabet on only one row of American keyboard like the image below.

    the first row consists of the characters "qwertyuiop",
    the second row consists of the characters "asdfghjkl", and
    the third row consists of the characters "zxcvbnm".

    1 <= words.length <= 20
    1 <= words[i].length <= 100
    words[i] consists of English letters (both lowercase and uppercase).

     */

    // 0ms. 100%
    public String[] findWords(String[] words) {
        String[] rows = {"QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM"};
        List<String> result = new ArrayList<>();

        for (String word : words) {
            String wordUpper = word.toUpperCase();

            boolean inRow = true;
            int row = -1;
            for (int i = 0; i < rows.length; i++) {
                if (rows[i].indexOf(wordUpper.charAt(0)) != -1) {
                    inRow = true;
                    row = i;
                    break;
                }
            }

            for (int i = 1; i < wordUpper.length(); i++) {
                if (rows[row].indexOf(wordUpper.charAt(i)) == -1) {
                    inRow = false;
                    break;
                }
            }

            if (inRow) {
                result.add(word);
            }
        }

        return result.toArray(new String[0]);
    }



    // lowerWord.chars().allMatch
    // 2ms, 6.64%
    public String[] findWords_stream(String[] words) {
        List<String> ans = new ArrayList<>();
        final int[] rows = {2, 3, 3, 2, 1, 2, 2, 2, 1, 2, 2, 2, 3,
                3, 1, 1, 1, 1, 2, 1, 1, 3, 1, 3, 1, 3};

        for (final String word : words) {
            final String lowerWord = word.toLowerCase();
            final int row = rows[lowerWord.charAt(0) - 'a'];
            final boolean isValid = lowerWord.chars().allMatch(c -> rows[c - 'a'] == row);
            if (isValid)
                ans.add(word);
        }

        return ans.toArray(new String[0]);
    }

    public static void main(String[] args) {
        KeyboardRow solution = new KeyboardRow();
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};

        String[] wordsInOneRow = solution.findWords(words);
        System.out.println("Words in One Row: " + Arrays.toString(wordsInOneRow));
    }

}
