package com.sjia.Leetcode;

public class UniqueSubstringsWraparound {
    // #467. Unique Substrings in Wraparound String     https://leetcode.com/problems/unique-substrings-in-wraparound-string/description/

    /*
    We define the string base to be the infinite wraparound string of "abcdefghijklmnopqrstuvwxyz", so base will look like this:

    "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".
    Given a string s, return the number of unique non-empty substrings of s are present in base.

    Input: s = "a"      Output: 1
    Input: s = "cac"    Output: 2
    Explanation: There are two substrings ("a", "c") of s in base.

    Input: s = "zab"    Output: 6
    Explanation: There are six substrings ("z", "a", "b", "za", "ab", and "zab") of s in base.

     */


    // maxLengthEndingWith = new int[26]
    // 9 ms, 66.13%; 43.3 MB, 80.65%
    public int findSubstringInWraproundString(String p) {
        int[] maxLengthEndingWith = new int[26];

        // Calculate the maximum length of substrings ending with each character
        int maxLen = 0;
        for (int i = 0; i < p.length(); i++) {
            if (i > 0 && (p.charAt(i) == p.charAt(i - 1) + 1 || p.charAt(i) == 'a' && p.charAt(i - 1) == 'z')) {
                maxLen++;
            } else {
                maxLen = 1;
            }

            int index = p.charAt(i) - 'a';
            maxLengthEndingWith[index] = Math.max(maxLengthEndingWith[index], maxLen);
        }

        // Sum up the maximum lengths for all characters
        int uniqueSubstrings = 0;
        for (int len : maxLengthEndingWith) {
            uniqueSubstrings += len;
        }

        return uniqueSubstrings;
    }

    public static void main(String[] args) {
        UniqueSubstringsWraparound solution = new UniqueSubstringsWraparound();
        String p = "zab";

        int uniqueSubstrings = solution.findSubstringInWraproundString(p);
        System.out.println("Unique Substrings: " + uniqueSubstrings); // Output: 6
    }

}
