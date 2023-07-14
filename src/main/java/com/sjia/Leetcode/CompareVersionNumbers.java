package com.sjia.Leetcode;

public class CompareVersionNumbers {
    // #165. Compare Version Numbers    https://leetcode.com/problems/compare-version-numbers/description/
    /*
    For example 2.5.33 and 0.1 are valid version numbers.
    Revisions are compared using their integer value ignoring any leading zeros.
    This means that revisions 1 and 001 are considered equal.
    version 1.0 is less than version 1.1

    Input: version1 = "1.01", version2 = "1.001"    Output: 0
    Explanation: Ignoring leading zeroes, both "01" and "001" represent the same integer "1".

    Input: version1 = "1.0", version2 = "1.0.0"     Output: 0
    Explanation: version1 does not specify revision 2, which means it is treated as "0".

    Input: version1 = "0.1", version2 = "1.1"       Output: -1
    Explanation: version1's revision 0 is "0", while version2's revision 0 is "1". 0 < 1, so version1 < version2.

     */

    // split, max length,
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int n = Math.max(v1.length, v2.length );

        for (int i = 0; i < n; i++) {
            int num1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int num2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;

            if (num1 > num2) {
                return 1;
            } else if (num1 < num2) {
                return -1;
            }
        }
        return 0;
    }




}
