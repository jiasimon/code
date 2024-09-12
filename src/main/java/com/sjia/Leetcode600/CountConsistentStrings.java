package com.sjia.Leetcode600;

public class CountConsistentStrings {
    // #1684. Count the Number of Consistent Strings    https://leetcode.com/problems/count-the-number-of-consistent-strings/description/?envType=daily-question&envId=2024-09-12
    /*
    Input: allowed = "ab", words = ["ad","bd","aaab","baa","badab"]     Output: 2
    Input: allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]  Output: 7
     */

    // boolean array of allowed characters
    public int countConsistentStrings(String allowed, String[] words) {
        // Create a boolean array to keep track of allowed characters
        boolean[] allowedChars = new boolean[26];
        for (char c : allowed.toCharArray()) {
            allowedChars[c - 'a'] = true;
        }

        int count = 0;
        for (String word : words) {
            if (isConsistent(word, allowedChars)) {
                count++;
            }
        }

        return count;
    }

    private boolean isConsistent(String word, boolean[] allowedChars) {
        for (char c : word.toCharArray()) {
            if (!allowedChars[c - 'a']) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CountConsistentStrings solution = new CountConsistentStrings();

        // Test case 1
        String allowed1 = "ab";
        String[] words1 = {"ad", "bd", "aaab", "baa", "badab"};
        System.out.println("Test case 1: " + solution.countConsistentStrings(allowed1, words1)); // Expected output: 2

        // Test case 2
        String allowed2 = "abc";
        String[] words2 = {"a", "b", "c", "ab", "ac", "bc", "abc"};
        System.out.println("Test case 2: " + solution.countConsistentStrings(allowed2, words2)); // Expected output: 7

        // Test case 3
        String allowed3 = "cad";
        String[] words3 = {"cc", "acd", "b", "ba", "bac", "bad", "ac", "d"};
        System.out.println("Test case 3: " + solution.countConsistentStrings(allowed3, words3)); // Expected output: 4
    }
}
