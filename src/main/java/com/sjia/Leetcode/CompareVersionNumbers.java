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
    // 1 ms, 84.54% ; 40.5 MB, 84.83%
    public int compareVersion2(String version1, String version2) {
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


    // 1 ms, 84.54% ; 40.8 MB, 37.69%
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int num = Math.max(v1.length, v2.length);

        for (int i=0; i < num; i++) {
            int num1, num2;
            if (i < v1.length) {
                num1 = Integer.parseInt(v1[i]);
            } else {
                num1 = 0;
            }

            if (i < v2.length) {
                num2 = Integer.parseInt(v2[i]);
            } else {
                num2 = 0;
            }

            if (num1 < num2) return -1;
            else if (num1 > num2)  return 1;
        }
        return 0;
    }


    public static void main(String[] args) {
        CompareVersionNumbers solution = new CompareVersionNumbers();

        // Test case 1
        String version1 = "1.01";
        String version2 = "1.001";
        int result1 = solution.compareVersion(version1, version2);
        System.out.println("Compare Version Numbers Test Case 1: " + result1);  // Expected output: 0

        // Test case 2
        String version3 = "1.0";
        String version4 = "1.0.0";
        int result2 = solution.compareVersion(version3, version4);
        System.out.println("Compare Version Numbers Test Case 2: " + result2);  // Expected output: 0

        // Test case 3
        String version5 = "0.1";
        String version6 = "1.1";
        int result3 = solution.compareVersion(version5, version6);
        System.out.println("Compare Version Numbers Test Case 3: " + result3);  // Expected output: -1

        // Test case 4
        String version7 = "1.0.1";
        String version8 = "1";
        int result4 = solution.compareVersion(version7, version8);
        System.out.println("Compare Version Numbers Test Case 4: " + result4);  // Expected output: 1

        // Test case 5
        String version9 = "7.5.2.3";
        String version10 = "7.5.3";
        int result5 = solution.compareVersion(version9, version10);
        System.out.println("Compare Version Numbers Test Case 5: " + result5);  // Expected output: -1

    }


}
