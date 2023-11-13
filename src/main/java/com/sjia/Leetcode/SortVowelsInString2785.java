package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortVowelsInString2785 {
    // #2785. Sort Vowels in a String   https://leetcode.com/problems/sort-vowels-in-a-string/description/?envType=daily-question&envId=2023-11-13

    /*
    Return the resulting string.

    The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in lowercase or uppercase. Consonants comprise all letters that are not vowels.

    Input: s = "lEetcOde"       Output: "lEOtcede"

    Input: s = "lYmpH"          Output: "lYmpH"

    1 <= s.length <= 100000

    s consists only of letters of the English alphabet in uppercase and lowercase.

     */


    // Collections.sort
    
    public String sortVowels(String s) {
        StringBuilder sb = new StringBuilder();
        List<Character> vowels = new ArrayList<>();

        for (final char c : s.toCharArray())
            if (isVowel(c))
                vowels.add(c);

        Collections.sort(vowels);

        int i = 0; // vowels' index
        for (final char c : s.toCharArray())
            sb.append(isVowel(c) ? vowels.get(i++) : c);

        return sb.toString();
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    public static void main(String[] args) {
        SortVowelsInString2785 solution = new SortVowelsInString2785();
        String s1 = "lEetcOde";
        String s2 = "lYmpH";

        System.out.println("Output 1: " + solution.sortVowels(s1)); // "lEOtcede"
        System.out.println("Output 2: " + solution.sortVowels(s2)); // "lYmpH"
    }

}
