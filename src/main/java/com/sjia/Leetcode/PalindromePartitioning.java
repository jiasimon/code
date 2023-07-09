package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePartitioning {

    // #131. Palindrome Partitioning https://leetcode.com/problems/palindrome-partitioning/
    // Given a string s, partition s such that every substring of the partition is a palindrome.
    //Return all possible palindrome partitioning of s.


    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), s, 0);
        return result;

    }

    public void backtrack(List<List<String>> list, List<String> tempList, String s, int start){
        if(start == s.length())
            list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < s.length(); i++){
                if(isPalindrome(s, start, i)){
                    tempList.add(s.substring(start, i + 1));
                    backtrack(list, tempList, s, i + 1);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }
    public boolean isPalindrome(String s, int start, int end){
//        while(low < high)
//            if(s.charAt(low++) != s.charAt(high--)) return false;
//        return true;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;

    }



    public static void main(String[] args) {

        String testData = "aab";
        //String testData  = " a  ";
//        String testData  = " a  ";
        PalindromePartitioning solution = new PalindromePartitioning();
        List<List<String>> result = solution.partition(testData);

        System.out.printf(" input %s Palindrome Partitioning: %s ", testData, result);
    }

}
