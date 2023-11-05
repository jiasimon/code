package com.sjia.Leetcode;

public class LicenseKeyFormatting482 {
    // #482. License Key Formatting     https://leetcode.com/problems/license-key-formatting/description/

    /*
    We want to reformat the string s such that each group contains exactly k characters, except for the first group, which could be shorter than k but still must contain at least one character. Furthermore, there must be a dash inserted between two groups, and you should convert all lowercase letters to uppercase.

    Return the reformatted license key.

    Input: s = "5F3Z-2e-9-w", k = 4     Output: "5F3Z-2E9W"

    Input: s = "2-5g-3-J", k = 2        Output: "2-5G-3J"

    1 <= s.length <= 10^5
    s consists of English letters, digits, and dashes '-'
    1 <= k <= 10^4

     */


    // S.replace("-", "").toUpperCase()
    // 11 ms, 81.43%; 43.2 MB, 90.26%
    public String licenseKeyFormatting(String S, int K) {
        S = S.replace("-", "").toUpperCase(); // Remove existing dashes and convert to uppercase
        StringBuilder sb = new StringBuilder();

        int firstGroupLen = S.length() % K; // Length of the first group

        // Append the first group with length firstGroupLen
        if (firstGroupLen > 0) {
            sb.append(S, 0, firstGroupLen);
            if (firstGroupLen < S.length()) {
                sb.append("-");
            }
        }

        // Append the remaining groups of length K
        for (int i = firstGroupLen; i < S.length(); i += K) {
            sb.append(S, i, i + K);
            if (i + K < S.length()) {
                sb.append("-");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        LicenseKeyFormatting482 solution = new LicenseKeyFormatting482();
        String S = "5F3Z-2e-9-w";
        int K = 4;

        String formatted = solution.licenseKeyFormatting(S, K);
        System.out.println("Formatted License Key: " + formatted);
    }



}
