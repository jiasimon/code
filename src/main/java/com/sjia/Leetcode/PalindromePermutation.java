package com.sjia.Leetcode;

import java.util.HashSet;

public class PalindromePermutation {

    // #266 PalindromePermutation
    //Given a string, determine if a permutation of the string could form a palindrome.


    static boolean canPermutePalindrome( String s){
        HashSet<Character> tool = new HashSet<Character>();
        for (int i=0; i < s.length(); i++) {
            if ( !tool.contains(s.charAt(i)) ) tool.add(s.charAt(i));
            else tool.remove(s.charAt(i));
        }
        return tool.isEmpty() || tool.size()==1 ;
    }


    public static void main(String[] args) {

        //String testData = "";
        //String testData  = " a  ";
        //String testData  = "aa ";
        //String testData  = "carerac";
        //String testData  = aab;
        String testData  = "a  ";
        boolean result = canPermutePalindrome(testData);

        System.out.printf(" input %s : canPermutePalindrome: %b ", testData, result);
    }

}
