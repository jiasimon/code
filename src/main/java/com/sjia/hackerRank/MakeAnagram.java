package com.sjia.hackerRank;

public class MakeAnagram {

    /*
    https://www.hackerrank.com/challenges/ctci-making-anagrams/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
     */

    public static int makeAnagram(String a, String b) {
        // Write your code here
        int[] freq = new int[26];

        for (char c : a.toCharArray() ) {
            freq[c - 'a']++;
        }
        for ( char c: b.toCharArray() ) {
            freq[ c - 'a']--;
        }

        int res = 0;
        for ( int n : freq) {
            res += Math.abs(n);
        }

        return res;

    }


    public static void main(String[] args) {
        String s1 = "cdexx";
        String s2 = "dcfx";
        makeAnagram(s1, s2);

        System.out.println(s1 + " and " + s2 + " makeAnagram: " + makeAnagram(s1, s2)); //
    }
}
