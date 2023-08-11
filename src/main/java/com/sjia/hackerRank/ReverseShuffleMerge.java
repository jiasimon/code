package com.sjia.hackerRank;

import java.util.*;

public class ReverseShuffleMerge {
    // https://www.hackerrank.com/challenges/reverse-shuffle-merge/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=greedy-algorithms

    /*
    The problem states that you are given a string s which is the result of
    the following operations on some string A. s = merge(reverse(A) ), shuffle(A))
    We need to find the lexicographically smallest A. Which means A with the lowest alphabetical order.

    eggegg              egg
    aeiouuoiea          aeiou
    abcdefgabcdefg      agfedcb     reversed= gfedcbagfedcba

     */


    static String reverseShuffleMerge(String s) {
        int[] freq = new int[26]; // Frequency of characters in s
        int[] needed = new int[26]; // Characters needed for the answer
        int[] used = new int[26]; // Characters used for the answer
        char[] result = new char[s.length() / 2];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            needed[i] = freq[i] / 2;
        }

        int resultIndex = 0;
        int sIndex = s.length() - 1;

        for (; resultIndex < result.length; resultIndex++) {
            int minCharIdx = -1;

            // Find the smallest possible character for the current position
            for (int j = 0; j < 26; j++) {
                if (needed[j] > 0 && (minCharIdx == -1 || (char) (j + 'a') < result[resultIndex])) {
                    minCharIdx = j;
                }
            }

            // Update needed and used arrays
            needed[minCharIdx]--;
            used[minCharIdx]++;

            // Move to the next position in the string
            while ((sIndex >= 0 && s.charAt(sIndex) != minCharIdx + 'a') || used[minCharIdx] > freq[minCharIdx] / 2) {
                if (s.charAt(sIndex) == minCharIdx + 'a') {
                    used[minCharIdx]--;
                }
                sIndex--;
            }

            // Add the character to the result
            result[resultIndex] = (char) (minCharIdx + 'a');
        }

        return new String(result);
    }


    static String reverseShuffleMerge_stack(String s) {
        int[] freq = new int[26]; // Frequency of characters in s
        int[] needed = new int[26]; // Characters needed for the answer
        int[] used = new int[26]; // Characters used for the answer
//        char[] result = new char[s.length() / 2];
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            needed[i] = freq[i] / 2;
        }

        // "abcdefgabcdefg"  into "gfedcbagfedcba"
        String reversedStr = new StringBuilder(s).reverse().toString();
        for (int i = 0; i < reversedStr.length(); i++) {
            int curr = reversedStr.charAt(i) - 'a';


            while (!stack.isEmpty() && reversedStr.charAt(i) < stack.peek()
                    && freq[stack.peek() - 'a'] >= needed[stack.peek() - 'a']) {

                used[stack.peek() - 'a']--;
                stack.pop();


            }

            if (used[curr] < needed[curr]) {
                stack.push(reversedStr.charAt(i));
                freq[curr]--;

                used[curr]++;

            } else {
                freq[curr]--;
            }


        }

        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        return result.toString();

    }


    public static void main(String[] args) {
//        String s = "abcdefgabcdefg";
//        String s = "eggegg";
        String s = "djjcddjggbiigjhfghehhbgdigjicafgjcehhfgifadihiajgciagicdahcbajjbhifjiaajigdgdfhdiijjgaiejgegbbiigida";
//        String s = "aeiouuoiea";
        String result = reverseShuffleMerge_stack(s);
        System.out.println(s + " reverseShuffleMerge: " + result);

    }


}
