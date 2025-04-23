package com.sjia.Leetcode700;

import java.util.Locale;

public class ShortestCompletingWord {
    // #748. Shortest Completing Word   https://leetcode.com/problems/shortest-completing-word/description/
    /*
    Input: licensePlate = "1s3 PSt", words = ["step","steps","stripe","stepple"]
    Output: "steps"
    Explanation: licensePlate contains letters 's', 'p', 's' (ignoring case), and 't'.
    "step" contains 't' and 'p', but only contains 1 's'.
    "steps" contains 't', 'p', and both 's' characters.

    Step 1: Extract Letters from License Plate

    Convert all characters in licensePlate to lowercase.
    Ignore digits and spaces.
    Count the frequency of letters.

    Step 2: Check Each Word

    For each word in words, count the frequency of letters.
    Compare it with the required frequency from the license plate.
    Track the shortest valid word.
     */

    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] targetFreq = getLetterFrequency(licensePlate);
        String shortestWord = null;

        for (String word : words) {
            if (isCompletingWord(word, targetFreq)) {
                if (shortestWord == null || word.length() < shortestWord.length()) {
                    shortestWord = word;
                }
            }
        }
        return shortestWord;
    }

    private int[] getLetterFrequency(String str) {
        int[] freq = new int[26];
        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                freq[Character.toLowerCase(c) - 'a']++;
            }
        }
        return freq;
    }

    private int[] getLetterFrequency2(String str) {
        int[] freq = new int[26];
        String tmp = str.toLowerCase();
        for (char c : tmp.toCharArray()) {
            if (Character.isLetter(c)) {
                freq[c - 'a']++;
            }
        }
        return freq;
    }

    private boolean isCompletingWord(String word, int[] targetFreq) {
        int[] wordFreq = new int[26];
        for (char c : word.toCharArray()) {
            wordFreq[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (wordFreq[i] < targetFreq[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ShortestCompletingWord solution = new ShortestCompletingWord();

        String licensePlate1 = "1s3 PSt";
        String[] words1 = {"step", "steps", "stripe", "stepple"};
        System.out.println(solution.shortestCompletingWord(licensePlate1, words1)); // Output: "steps"

        String licensePlate2 = "1s3 456";
        String[] words2 = {"looks", "pest", "stew", "show"};
        System.out.println(solution.shortestCompletingWord(licensePlate2, words2)); // Output: "pest"
    }
}
