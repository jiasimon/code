package com.sjia.Leetcode2000Plus;

public class BeautifulSubstring {
    // #2904. Shortest and Lexicographically Smallest Beautiful String
    // https://leetcode.com/problems/shortest-and-lexicographically-smallest-beautiful-string/description/
    /*
    You are given a binary string s and a positive integer k
    A substring of s is beautiful if the number of 1's in it is exactly k.

    Input: s = "100011001", k = 3   Output: "11001"
     */

    public String shortestBeautifulSubstring(String s, int k) {
        int count =0;
        char[] charArray = s.toCharArray();
        for ( char c : charArray) {
            if (c=='1') {
                count++;
            }
        }
        if (count<k) return "";

        for ( int size = k; ; size++) {
            String res = "";
            for (int i=size; i<= s.length(); i++ ) {
                String t = s.substring(i-size, i);
                if ( ( res.isEmpty() || t.compareTo(res) < 0 ) && t.replace("0", "").length()==k ) {
                    res = t;
                }
            }
            if ( !res.isEmpty()) {
                return res;
            }
        }
    }

    public static void main(String[] args) {
        BeautifulSubstring sol = new BeautifulSubstring();
        int passed = 0;
        int total = 0;

        // Test 1: Example from LeetCode - s = "100011001", k = 3
        total++;
        String result1 = sol.shortestBeautifulSubstring("100011001", 3);
        if (result1.equals("11001")) {
            System.out.println("Test 1 PASSED: " + result1);
            passed++;
        } else {
            System.out.println("Test 1 FAILED: expected '11001', got '" + result1 + "'");
        }

        // Test 2: s = "1011", k = 2
        total++;
        String result2 = sol.shortestBeautifulSubstring("1011", 2);
        if (result2.equals("11")) {
            System.out.println("Test 2 PASSED: " + result2);
            passed++;
        } else {
            System.out.println("Test 2 FAILED: expected '11', got '" + result2 + "'");
        }

        // Test 3: s = "000", k = 1 -> not enough ones, expect ""
        total++;
        String result3 = sol.shortestBeautifulSubstring("000", 1);
        if (result3.equals("")) {
            System.out.println("Test 3 PASSED: (empty string as expected)");
            passed++;
        } else {
            System.out.println("Test 3 FAILED: expected '', got '" + result3 + "'");
        }

        // Test 4: s = "1", k = 1 -> exact single match
        total++;
        String result4 = sol.shortestBeautifulSubstring("1", 1);
        if (result4.equals("1")) {
            System.out.println("Test 4 PASSED: " + result4);
            passed++;
        } else {
            System.out.println("Test 4 FAILED: expected '1', got '" + result4 + "'");
        }

        // Test 5: s = "111", k = 3 -> whole string is needed
        total++;
        String result5 = sol.shortestBeautifulSubstring("111", 3);
        if (result5.equals("111")) {
            System.out.println("Test 5 PASSED: " + result5);
            passed++;
        } else {
            System.out.println("Test 5 FAILED: expected '111', got '" + result5 + "'");
        }

        // Test 6: s = "0110", k = 1 -> smallest single '1' substring among ties
        // Two substrings of length 1 with one '1': positions 1 and 2, both "1"
        total++;
        String result6 = sol.shortestBeautifulSubstring("0110", 1);
        if (result6.equals("1")) {
            System.out.println("Test 6 PASSED: " + result6);
            passed++;
        } else {
            System.out.println("Test 6 FAILED: expected '1', got '" + result6 + "'");
        }

        // Test 7: s = "10101", k = 2 -> multiple candidates of same size, pick lexicographically smallest
        // Substrings of length 3 with 2 ones: "101" (idx0-2), "010" no (1 one), "101" (idx2-4)
        // Valid: "101" and "101" -> smallest is "101"
        total++;
        String result7 = sol.shortestBeautifulSubstring("10101", 2);
        if (result7.equals("101")) {
            System.out.println("Test 7 PASSED: " + result7);
            passed++;
        } else {
            System.out.println("Test 7 FAILED: expected '101', got '" + result7 + "'");
        }

        // Test 8: empty string input
        total++;
        String result8 = sol.shortestBeautifulSubstring("", 1);
        if (result8.equals("")) {
            System.out.println("Test 8 PASSED: (empty string as expected)");
            passed++;
        } else {
            System.out.println("Test 8 FAILED: expected '', got '" + result8 + "'");
        }

        // Test 9: k = 0 edge case -> shortest substring with 0 ones
        // Smallest length is 0 (size starts at k=0), so result should be "" immediately since res stays "" at size 0...
        // NOTE: This is an edge case that may behave unexpectedly - see explanation below
        total++;
        String result9 = sol.shortestBeautifulSubstring("101", 0);
        System.out.println("Test 9 (k=0 edge case) result: '" + result9 + "'");

        System.out.println("\n" + passed + "/" + total + " tests passed.");
    }

}
