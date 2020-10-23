package com.sjia.Leetcode;

public class RegularExpression {
    // #10 https://leetcode.com/problems/regular-expression-matching/
    // '.' Matches any single character.​​​​ '*' Matches zero or more of the preceding element.
    // Given an input string (s) and a pattern (p),
    // implement regular expression matching with support for '.' and '*' where:

    // Runtime: 43 ms, faster than 27.82% of Java online submissions for Regular Expression Matching.
    //Memory Usage: 39.3 MB, less than 5.05% of Java online submissions for Regular Expression Matching.
    public boolean isMatch(String s, String p) {
        return s.matches(p);
    }


}
