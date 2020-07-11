package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class letterCombinations {

    // #17 https://leetcode.com/problems/letter-combinations-of-a-phone-number/submissions/

    //BFS Runtime: 14 ms, faster than 5.34% of Java online submissions for Letter Combinations of a Phone Number.
    //Memory Usage: 40.4 MB, less than 5.07% of Java online submissions for Letter Combinations of a Phone Number.


    // use for (char digit : digits.toCharArray())  instead of for (int i=0
    // Runtime: 5 ms, faster than 42.41% of Java online submissions for Letter Combinations of a Phone Number.
    //Memory Usage: 39.4 MB, less than 53.00% of Java online submissions for Letter Combinations of a Phone Number.

    static List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<String>();

        String[] mapTable = new String[]{
                "0",
                "",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"};
        List<String> res = new ArrayList<>();
        res.add("");
        for (char digit : digits.toCharArray()) {
            List<String> tmp = new ArrayList<>();
            for (String t : res) {
                String s = mapTable[Character.getNumericValue(digit)];
                for (int j = 0; j < s.length(); ++j)
                    tmp.add(t + s.charAt(j));
            }
            res = tmp;
        }

        return res;
    }


    public static void main(String[] args) {


        String testData  = "23";
        List result = letterCombinations(testData);

        System.out.printf(" Three sum result is %s \n", result);
    }



}
