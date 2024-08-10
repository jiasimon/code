package com.sjia.Leetcode600;

public class RepeatedStringMatch {
    // #686. Repeated String Match      https://leetcode.com/problems/repeated-string-match/description/
    /*
    Notice: string "abc" repeated 0 times is "", repeated 1 time is "abc" and repeated 2 times is "abcabc".

    Input: a = "abcd", b = "cdabcdab"   Output: 3
    Input: a = "a", b = "aa"        Output: 2

    1 <= a.length, b.length <= 10000
    a and b consist of lowercase English letters.
     */

    public int repeatedStringMatch(String a, String b) {
        int count = 1;
        StringBuilder sb = new StringBuilder(a);

        // Repeat string `a` until its length is greater than or equal to `b`
        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }

        // Check if `b` is a substring of the current repeated `a`
        if (sb.toString().contains(b)) {
            return count;
        }

        // Append `a` one more time to check the overlap case
        sb.append(a);
        count++;

        if (sb.toString().contains(b)) {
            return count;
        }

        // If `b` is still not found, return -1
        return -1;
    }

    public static void main(String[] args) {
        RepeatedStringMatch solution = new RepeatedStringMatch();

        // Test Case 1
        String a1 = "abcd";
        String b1 = "cdabcdab";
        System.out.println("Test Case 1: " + solution.repeatedStringMatch(a1, b1)); // Output: 3

        // Test Case 2
        String a2 = "a";
        String b2 = "aa";
        System.out.println("Test Case 2: " + solution.repeatedStringMatch(a2, b2)); // Output: 2

        // Test Case 3
        String a3 = "abc";
        String b3 = "cabcabca";
        System.out.println("Test Case 3: " + solution.repeatedStringMatch(a3, b3)); // Output: 4

        // Test Case 4
        String a4 = "abc";
        String b4 = "xyz";
        System.out.println("Test Case 4: " + solution.repeatedStringMatch(a4, b4)); // Output: -1
    }

}
