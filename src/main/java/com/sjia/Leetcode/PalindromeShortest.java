package com.sjia.Leetcode;

public class PalindromeShortest {

    // #214 https://leetcode.com/problems/shortest-palindrome/

    // Input: "aacecaaa"
    //Output: "aaacecaaa"

    // Runtime: 210 ms, faster than 34.95% of Java online submissions for Shortest Palindrome.
    //Memory Usage: 39.8 MB, less than 41.73% of Java online submissions for Shortest Palindrome.

    // second run, Runtime: 213 ms, faster than 33.64% of Java online submissions for Shortest Palindrome.
    //Memory Usage: 40.2 MB, less than 17.58% of Java online submissions for Shortest Palindrome.
/*
    static String shortestPalindrome(String s) {
        String reverse = new StringBuilder(s).reverse().toString();
        int n = s.length();
        for ( int i = 0; i < n; i++) {
            if (s.substring(0, n - i).equals(reverse.substring(i))) {
                return new StringBuilder(s.substring(n - i)).reverse() + s;
            }
        }
        return "";
    }*/


    // Convert to "find the longest palindrome substring starts from index 0"
    // KMP
    //Runtime: 5 ms, faster than 90.09% of Java online submissions for Shortest Palindrome.
    //Memory Usage: 39.6 MB, less than 60.10% of Java online submissions for Shortest Palindrome.

    static String shortestPalindrome(String s) {
        String ss = s + '#' + new StringBuilder(s).reverse();
        int max = getLastKMP(ss);
        return new StringBuilder(s.substring(max)).reverse() + s;
    }

    static int getLastKMP(String s) {
        int n = s.length();
        char[] c = s.toCharArray();
        int[] nextTable = new int[n + 1];
        nextTable[0] = -1;
        nextTable[1] = 0;
        int k = 0;
        int i = 2;
        while (i <= n) {
            if (k == -1 || c[i - 1] == c[k]) {
                nextTable[i] = k + 1;
                k++;
                i++;
            } else {
                k = nextTable[k];
            }
        }
        return nextTable[n];
    }


    public static void main(String[] args) {

        // abbacd
        //String testData = "aacecaaa";
        //String testData = "abacd"; dcaba
        String testData  = "abbacd";
        String result = shortestPalindrome(testData);

        System.out.printf(" input %s , PalindromeShortest is %s ", testData, result);
    }


}
