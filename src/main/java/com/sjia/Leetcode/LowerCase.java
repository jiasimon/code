package com.sjia.Leetcode;

public class LowerCase {
    // #709 https://leetcode.com/problems/to-lower-case/
    // Implement function ToLowerCase() that has a string parameter str,
    // and returns the same string in lowercase.

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for To Lower Case.
    //Memory Usage: 37.4 MB, less than 55.31% of Java online submissions for To Lower Case.
    public String toLowerCase(String str) {
        char[] tmp = str.toCharArray();
        for (int i=0; i< tmp.length; i++) {
            if ( tmp[i] >= 'A' && tmp[i] <= 'Z') {
                tmp[i] = (char) (tmp[i] + 'a' -'A');
            }
        }
        return String.valueOf(tmp);
    }

    public static void main(String[] args) {

        String testData  = "Hello";
        LowerCase solution = new LowerCase();

        String result = solution.toLowerCase(testData);

        System.out.printf(" input %s toLowerCase: %s ", testData, result);
    }


}
