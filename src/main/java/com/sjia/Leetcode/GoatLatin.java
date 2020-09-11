package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GoatLatin {
    // #824 https://leetcode.com/problems/goat-latin/

    // Runtime: 11 ms, faster than 30.04% of Java online submissions for Goat Latin.
    //Memory Usage: 40.6 MB, less than 11.79% of Java online submissions for Goat Latin.
    public String toGoatLatin(String S) {
        Set<Character> vowel = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        String res = "";
        String[] tmp =  S.split(" ");
        for (int i=0; i < tmp.length; i++) {
            if(vowel.contains(tmp[i].charAt(0))) {
                res += " " + tmp[i] + "ma";
            } else {
                res += " " + tmp[i].substring(1) + tmp[i].charAt(0) + "ma";
            }
            for (int j=0; j<=i; j++) res += "a";
        }
        return res.substring(1);
    }

    public static void main(String[] args) {
        String testData  = "I speak Goat Latin";
        GoatLatin solution = new GoatLatin();
        String result = solution.toGoatLatin(testData);

        System.out.printf("testData %s add digits is %s \n", testData,result);
    }


}
