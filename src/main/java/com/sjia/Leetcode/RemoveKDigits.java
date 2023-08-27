package com.sjia.Leetcode;

import java.util.Stack;

public class RemoveKDigits {
    // #402. Remove K Digits    https://leetcode.com/problems/remove-k-digits/description/

    /*
    Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.

    Input: num = "1432219", k = 3   Output: "1219"
    Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

    Input: num = "10200", k = 1     Output: "200"
    Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.

    Input: num = "10", k = 2        Output: "0"
    Explanation: Remove all the digits from the number and it is left with nothing which is 0.

    1 <= k <= num.length <= 10^5
    num consists of only digits.

     */


    // Stack, stack.peek() > digit
    // 66 ms, 26.53%; 44.7 MB, 41.76%
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if ( n== k) return "0";

        Stack<Character> stack = new Stack<>();
        for (char digit: num.toCharArray()) {
            while ( k > 0 && !stack.isEmpty() && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }

        // eg: 123456, k=2
        while ( k > 0 ) {
            stack.pop();
            k--;
        }

        StringBuilder result = new StringBuilder();

        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }

        // Remove leading zeros
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        return result.toString();
    }




    // sb reverse
    public String removeKdigits_reverseSB(String num, int k) {
        int len = num.length();
        //corner case
        if(k==len)
            return "0";

        Stack<Character> stack = new Stack<>();
        int i =0;
        while(i<num.length()){
            //whenever meet a digit which is less than the previous digit, discard the previous one
            while(k>0 && !stack.isEmpty() && stack.peek()>num.charAt(i)){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
            i++;
        }

        // corner case like "1111"
        while(k>0){
            stack.pop();
            k--;
        }

        //construct the number from the stack
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
            sb.append(stack.pop());
        sb.reverse();

        //remove all the 0 at the head
        while(sb.length()>1 && sb.charAt(0)=='0')
            sb.deleteCharAt(0);
        return sb.toString();

    }


    public static void main(String[] args) {
        RemoveKDigits solution = new RemoveKDigits();
        String num = "1432219";
        int k = 3;
        String smallestNumber = solution.removeKdigits(num, k);
        System.out.println("Smallest number after removing " + k + " digits: " + smallestNumber);
    }



}
