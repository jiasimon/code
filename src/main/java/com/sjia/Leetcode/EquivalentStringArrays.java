package com.sjia.Leetcode;

public class EquivalentStringArrays {
    // #1662. Check If Two String Arrays are Equivalent https://leetcode.com/problems/check-if-two-string-arrays-are-equivalen

    /*
    Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.

    A string is represented by an array if the array elements concatenated in order forms the string.

    Input: word1 = ["ab", "c"], word2 = ["a", "bc"]     Output: true

    Input: word1 = ["a", "cb"], word2 = ["ab", "c"]     Output: false

    Input: word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]  Output: true

    1 <= word1.length, word2.length <= 1000,
    1 <= word1[i].length, word2[i].length <= 1000
     */

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (String word : word1) {
            sb1.append(word);
        }

        for (String word : word2) {
            sb2.append(word);
        }

        return sb1.toString().equals(sb2.toString());
    }

    
    public static void main(String[] args) {
        EquivalentStringArrays solution = new EquivalentStringArrays();

        String[] word1 = {"ab", "c"};
        String[] word2 = {"a", "bc"};

        boolean areEquivalent = solution.arrayStringsAreEqual(word1, word2);
        System.out.println("Are the string arrays equivalent? " + areEquivalent);
    }
}
