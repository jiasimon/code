package com.sjia.Leetcode;

public class DetectCapital {

    // #520 https://leetcode.com/problems/detect-capital/

    // Runtime: 8 ms, faster than 7.94% of Java online submissions for Detect Capital.
    //Memory Usage: 39.9 MB, less than 8.48% of Java online submissions for Detect Capital.
/*
    public boolean detectCapitalUse(String word) {
        return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
    }*/



    // Runtime: 8 ms, faster than 7.94% of Java online submissions for Detect Capital.
    //Memory Usage: 39.6 MB, less than 22.38% of Java online submissions for Detect Capital.
/*
    public boolean detectCapitalUse(String word) {
        return word.matches("[A-Z]*|[A-Z]?[a-z]*");
    }*/


    // Runtime: 2 ms, faster than 41.80% of Java online submissions for Detect Capital.
    //Memory Usage: 38.1 MB, less than 48.35% of Java online submissions for Detect Capital.
/*    public boolean detectCapitalUse(String word) {
        if (word.length() == 1) return true;
        boolean result = word.substring(1).equals(word.substring(1).toLowerCase());
        if (Character.isUpperCase(word.charAt(0)) ) {
            return word.substring(1).equals(word.substring(1).toUpperCase()) ||
                    result;
        } else {
            return result;
        }
    }*/



    // Runtime: 2 ms, faster than 41.80% of Java online submissions for Detect Capital.
    //Memory Usage: 37.9 MB, less than 72.77% of Java online submissions for Detect Capital.
    public boolean detectCapitalUse(String word) {
        if (word.length() == 1) return true;
        boolean result = word.substring(1).equals(word.substring(1).toLowerCase());
        return result || word.equals(word.toUpperCase());
    }


}
