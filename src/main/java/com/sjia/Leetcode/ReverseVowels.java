package com.sjia.Leetcode;

public class ReverseVowels {

    // #345 https://leetcode.com/problems/reverse-vowels-of-a-string/
    // Write a function that takes a string and reverse only the vowels of a string.

    // Runtime: 5 ms, faster than 59.04% of Java online submissions for Reverse Vowels of a String.
    //Memory Usage: 40.7 MB, less than 14.72% of Java online submissions for Reverse Vowels of a String.
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

    }


}
