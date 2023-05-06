package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {

    // #17 Letter Combinations of a Phone Number https://leetcode.com/problems/letter-combinations-of-a-phone-number/submissions/

    // 0 <= digits.length <= 4
    // digits[i] is a digit in the range ['2', '9'].


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
        char[] cur = new char [digits.length()];
        dfs(digits, mapTable, 0, cur, res );

        return res;
    }

    //  DFS , depth-first search
    private static void dfs(String digits, String[] mapTable, int i, char[] cur, List<String> res) {
        if (i == digits.length()) {
            if( i > 0 ) res.add(new String(cur) );
            return;
        }

        String tmp = mapTable[Character.getNumericValue(digits.charAt(i))];
        for (int j = 0; j < tmp.length(); ++j) {
            cur[i] = tmp.charAt(j);
            dfs(digits, mapTable, i + 1, cur, res);
        }

    }

/*    static List<String> letterCombinations(String digits) {
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
    }*/


    // backTracking
    public static List<String> letterCombinations2(String digits) {

        List<String> res = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return res;
        }

        String[] lettersMap = {"0", "" ,"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(res, new StringBuilder(), digits, lettersMap, 0);
        return res;
    }

    public static void backtrack(List<String> res, StringBuilder sb, String digits, String[] lettersMap, int idx) {
        if (idx == digits.length()) {
            res.add(sb.toString());
            return;
        }


        // int a = ch - '0';
        // int a = Character.getNumericValue(ch);
        // Integer.parseInt(String.valueOf(ch))
        int tmp = Character.getNumericValue(digits.charAt(idx));
        String numStr = lettersMap[tmp];
        for (int i = 0; i < numStr.length(); i++) {
            sb.append(numStr.charAt(i));
            backtrack(res, sb, digits, lettersMap, idx + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


    public static void main(String[] args) {


        String testData  = "23";
        List result = letterCombinations2(testData);

        System.out.printf(" Three sum result is %s \n", result);
    }



}
