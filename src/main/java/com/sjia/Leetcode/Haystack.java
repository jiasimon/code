package com.sjia.Leetcode;

public class Haystack {

    // #28 Find the Index of the First Occurrence in a String https://leetcode.com/problems/implement-strstr/

    // haystack = "hello", needle = "ll", haystack = "aaaaa", needle = "bba"
    // Input: haystack = "sadbutsad", needle = "sadbutsad"
    // 1 <= haystack.length, needle.length <= 104
    // haystack and needle consist of only lowercase English characters.


    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Implement strStr().
    //Memory Usage: 39.9 MB, less than 5.21% of Java online submissions for Implement strStr().

    // if needle is "", return 0; with  substring, no need to check

    // KMB, Rabin Karp hash,

    // brute force
    static int strStr(String haystack, String needle) {
        int h = haystack.length(), x = needle.length();
        for ( int i = 0; i< h-x+1; i++ ) {
            if(needle.equals(haystack.substring(i, i+x))) return i;
        }
        return -1;

    }


    // java method
    static int strStr2(String haystack, String needle) {
        return haystack.indexOf(needle);
    }


    // sliding window
    static int strStr3(String haystack, String needle) {
        int h = haystack.length(), x = needle.length();
        for ( int i = 0; i<= h-x; i++ ) {
            for ( int j=0; j<x; j++) {
                if(needle.charAt(j) != haystack.charAt(i+j)) {
                    break;
                }
                if ( j== x-1) return i;
            }

        }
        return -1;

    }

    // Rabin-Karp single Hash
    public int hashValue(String string, int RADIX, int MOD, int m) {
        int ans = 0;
        long factor = 1;
        for (int i = m - 1; i >= 0; i--) {
            ans += ((int) (string.charAt(i) - 'a') * factor) % MOD;
            factor = (factor * RADIX) % MOD;
        }
        return ans % MOD;
    }

    public int strStr4(String haystack, String needle) {
        int m = needle.length();
        int n = haystack.length();
        if (n < m)
            return -1;

        // CONSTANTS
        int RADIX = 26;
        int MOD = 1000000033;
        long MAX_WEIGHT = 1;

        for (int i = 0; i < m; i++)
            MAX_WEIGHT = (MAX_WEIGHT * RADIX) % MOD;

        // Compute hash of needle
        long hashNeedle = hashValue(needle, RADIX, MOD, m), hashHay = 0;

        // Check for each m-substring of haystack, starting at index windowStart
        for (int windowStart = 0; windowStart <= n - m; windowStart++) {
            if (windowStart == 0) {
                // Compute hash of the First Substring
                hashHay = hashValue(haystack, RADIX, MOD, m);
            } else {
                // Update Hash using Previous Hash Value in O(1)
                hashHay = ((hashHay * RADIX) % MOD - ((int) (haystack.charAt(windowStart - 1) - 'a') * MAX_WEIGHT) % MOD
                        + (int) (haystack.charAt(windowStart + m - 1) - 'a') + MOD) % MOD;
            }
            // If the hash matches, Check Character by Character.
            // Because of Mod, spurious hits can be there.
            if (hashNeedle == hashHay) {
                for (int i = 0; i < m; i++) {
                    if (needle.charAt(i) != haystack.charAt(i + windowStart)) {
                        break;
                    }
                    if (i == m - 1) {
                        return windowStart;
                    }
                }
            }
        }

        return -1;
    }



    public static void main(String[] args) {
        String haystack = "sadbutsad";
        String needle = "db";
        int result = strStr3(haystack, needle);
        System.out.printf("The index of needle %s is: %d", needle, result);

    }


}
