package com.sjia.Leetcode;

import java.util.Arrays;

public class ReverseString2 {

    // #541 https://leetcode.com/problems/reverse-string-ii/

    // Runtime: 1 ms, faster than 86.41% of Java online submissions for Reverse String II.
    //Memory Usage: 39.3 MB, less than 91.69% of Java online submissions for Reverse String II.
    public String reverseStr(String s, int k) {
        char[] tmp = s.toCharArray();
        for (int i=0; i < tmp.length; i += 2*k) {
            int left = i, right = Math.min(i + k - 1, tmp.length-1) ;
            while (left < right) {
                char t = tmp[left];
                tmp[left] = tmp[right];
                tmp[right] = t;
                left++;
                right--;
            }
        }
        return new String(tmp);
    }

    public static void main(String[] args) {

        String testData  = "abcdefg";
        int k = 2;
        ReverseString2 solution = new ReverseString2();
        String result = solution.reverseStr(testData, k);

        System.out.printf(" testData %s , k : %s , ReverseString2 is:  %s \n", testData,k ,result);
    }


}
