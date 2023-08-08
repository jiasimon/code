package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReverseVowels {

    // #345. Reverse Vowels of a String  https://leetcode.com/problems/reverse-vowels-of-a-string/
    // Write a function that takes a string and reverse only the vowels of a string.

    // Runtime: 5 ms, faster than 59.04% of Java online submissions for Reverse Vowels of a String.
    //Memory Usage: 40.7 MB, less than 14.72% of Java online submissions for Reverse Vowels of a String.
/*
    public String reverseVowels(String s) {
        if (s ==null || s.length()==0)  return s;
        String vowel = "aeiouAEIOU";
        char [] tmp = s.toCharArray();
        int left =0, right = tmp.length-1;
        while (left < right) {
            if (!vowel.contains(Character.toString(tmp[left])) ) left++;
            else if (!vowel.contains(Character.toString(tmp[right])) ) right--;
            else if (vowel.contains(Character.toString(tmp[left])) &&
                    vowel.contains(Character.toString(tmp[right])) ) {
                char a = tmp[left];
                tmp[left] = tmp[right];
                tmp[right] = a;
                left++;
                right--;
            }
        }
        return new String(tmp);
    }*/



    // Runtime: 5 ms, faster than 59.04% of Java online submissions for Reverse Vowels of a String.
    //Memory Usage: 39.8 MB, less than 38.58% of Java online submissions for Reverse Vowels of a String.
    public String reverseVowels2(String s) {
        if (s ==null || s.length()==0)  return s;
        //String vowel = "aeiouAEIOU";
        char [] tmp = s.toCharArray();
        Set<Character> vowelSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int left =0, right = tmp.length-1;
        while (left < right) {
            if (!vowelSet.contains(tmp[left]) ) left++;
            else if (!vowelSet.contains(tmp[right]) ) right--;
            else if (vowelSet.contains(tmp[left]) &&
                    vowelSet.contains(tmp[right]) ) {
                char a = tmp[left];
                tmp[left] = tmp[right];
                tmp[right] = a;
                left++;
                right--;
            }
        }
        return new String(tmp);
    }



    // 'aeiouAEIOU'.indexOf(c) != -1
    // 4 ms, 75.4%; 43.6 MB, 96.6%
    public String reverseVowels(String s) {
        char[] charArray = s.toCharArray();
        int left = 0;
        int right = charArray.length - 1;

        while (left < right) {
            if (isVowel(charArray[left]) && isVowel(charArray[right])) {
                // Swap the vowels at left and right pointers
                char temp = charArray[left];
                charArray[left] = charArray[right];
                charArray[right] = temp;
                left++;
                right--;
            } else {
                // Move the left pointer if the character at left is not a vowel
                if (!isVowel(charArray[left])) {
                    left++;
                }
                // Move the right pointer if the character at right is not a vowel
                if (!isVowel(charArray[right])) {
                    right--;
                }
            }
        }

        return new String(charArray);
    }

    // indexOf(c) != -1
    // 4 ms, 75.4%; 43.6 MB, 96.6%
    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }


    // String contains
    // 6 ms, 51.65%; 45.1 MB, 14.62%
    private boolean isVowel_contains(char c) {
        return "aeiouAEIOU".contains(c+"");
    }


    public static void main(String[] args) {
        ReverseVowels solution = new ReverseVowels();
        String s = "hello";
        System.out.println(solution.reverseVowels(s)); // Output: "holle"
    }



}
