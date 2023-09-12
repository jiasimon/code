package com.sjia.Leetcode;

import java.util.HashSet;
import java.util.Set;

public class MinDeletionsToMakeFreqsUnique1647 {
    // #1647. Minimum Deletions to Make Character Frequencies Unique    https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/?envType=daily-question&envId=2023-09-12

    /*
    A string s is called good if there are no two different characters in s that have the same frequency.

    Given a string s, return the minimum number of characters you need to delete to make s good.

    The frequency of a character in a string is the number of times it appears in the string. For example, in the string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1.

    Input: s = "aab"        Output: 0
    Explanation: s is already good.

    Input: s = "aaabbbcc"   Output: 2
    Explanation: You can delete two 'b's resulting in the good string "aaabcc".
    Another way it to delete one 'b' and one 'c' resulting in the good string "aaabbc".

    1 <= s.length <= 100000
    s contains only lowercase English letters.
     */


    // int[26], set uniqueFreq
    // 7 ms, 98.85%; 44.3 MB, 87.77%
    public int minDeletions(String s) {
        int[] frequency = new int[26]; // Assuming lowercase English letters only
        Set<Integer> uniqueFreq = new HashSet<>();
        int deletions = 0;

        // Calculate character frequencies
        for (char c : s.toCharArray()) {
            frequency[c - 'a']++;
        }

        for (int freq : frequency) {
            while (freq > 0 && !uniqueFreq.add(freq)) {
                freq--; // Decrement the frequency until it's unique
                deletions++; // Increment the deletion counter
            }
        }

        return deletions;
    }


    

    public static void main(String[] args) {
        MinDeletionsToMakeFreqsUnique1647 solution = new MinDeletionsToMakeFreqsUnique1647();
        String s = "aaabbbccc";
        int minDeletions = solution.minDeletions(s);
        System.out.println("Minimum Deletions: " + minDeletions); // Output: 2 (e.g., "aabbccccc")
    }

}
