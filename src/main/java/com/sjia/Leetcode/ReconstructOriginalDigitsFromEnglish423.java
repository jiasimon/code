package com.sjia.Leetcode;

public class ReconstructOriginalDigitsFromEnglish423 {
    // #423. Reconstruct Original Digits from English   https://leetcode.com/problems/reconstruct-original-digits-from-english/description/

    /*
    Given a string s containing an out-of-order English representation of digits 0-9, return the digits in ascending order.

    Input: s = "owoztneoer"     Output: "012"
    Input: s = "fviefuro"       Output: "45"

    1 <= s.length <= 10^5
    s[i] is one of the characters ["e","g","f","i","h","o","n","s","r","u","t","w","v","x","z"]
    s is guaranteed to be valid.
     */

    public String originalDigits(String s) {
        int[] letterCount = new int[26]; // Array to count letter frequencies
        int[] digitCount = new int[10]; // Array to count digit frequencies

        // Count letter frequencies
        for (char c : s.toCharArray()) {
            letterCount[c - 'a']++;
        }

        // Deduce digit counts
        digitCount[0] = letterCount['z' - 'a']; // Count of 'z' in "zero"
        digitCount[2] = letterCount['w' - 'a']; // Count of 'w' in "two"
        digitCount[4] = letterCount['u' - 'a']; // Count of 'u' in "four"
        digitCount[6] = letterCount['x' - 'a']; // Count of 'x' in "six"
        digitCount[8] = letterCount['g' - 'a']; // Count of 'g' in "eight"
        digitCount[3] = letterCount['h' - 'a'] - digitCount[8]; // Count of 'h' in "three" after removing 'g'
        digitCount[5] = letterCount['f' - 'a'] - digitCount[4]; // Count of 'f' in "five" after removing 'u'
        digitCount[7] = letterCount['s' - 'a'] - digitCount[6]; // Count of 's' in "seven" after removing 'x'
        digitCount[9] = letterCount['i' - 'a'] - digitCount[5] - digitCount[6] - digitCount[8]; // Count of 'i' in "nine" after removing other digits
        digitCount[1] = letterCount['n' - 'a'] - digitCount[7] - 2 * digitCount[9]; // Count of 'n' in "one" after removing 'o' and 'e'

        // Construct the result string
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < digitCount[i]; j++) {
                result.append(i);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        ReconstructOriginalDigitsFromEnglish423 solution = new ReconstructOriginalDigitsFromEnglish423();
        String s = "owoztneoer";
        String originalDigits = solution.originalDigits(s);
        System.out.println("Original Digits: " + originalDigits); // Output: "012"
    }
}
