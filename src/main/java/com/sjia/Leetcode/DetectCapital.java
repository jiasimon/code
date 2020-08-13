package com.sjia.Leetcode;

public class DetectCapital {

    // #520 https://leetcode.com/problems/detect-capital/

    // Runtime: 8 ms, faster than 7.94% of Java online submissions for Detect Capital.
    //Memory Usage: 39.9 MB, less than 8.48% of Java online submissions for Detect Capital.
    public boolean detectCapitalUse(String word) {
        return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
    }



    // Runtime: 8 ms, faster than 7.94% of Java online submissions for Detect Capital.
    //Memory Usage: 39.6 MB, less than 22.38% of Java online submissions for Detect Capital.
/*
    public boolean detectCapitalUse(String word) {
        return word.matches("[A-Z]*|[A-Z]?[a-z]*");
    }*/

    

}
