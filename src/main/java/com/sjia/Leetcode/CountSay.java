package com.sjia.Leetcode;

public class CountSay {

    //#38 Count and Say https://leetcode.com/problems/count-and-say/  google interview question in 2005

    //1.     1
    //2.     11
    //3.     21
    //4.     1211
    //5.     111221


    // StringBuffer Runtime: 1 ms, faster than 94.13% of Java online submissions for Count and Say.
    // Memory Usage: 36.9 MB, less than 67.68% of Java online submissions for Count and Say.

    static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        StringBuffer res = new StringBuffer();
        String tmp = countAndSay(n - 1);
        int length = tmp.length();
        int a = 0;
        for (int i = 1; i < length + 1; i++) {
            if (i == length) {
                return res.append(i - a).append(tmp.charAt(a)).toString();
            } else if (tmp.charAt(i) != tmp.charAt(a) ) {
                res.append(i - a).append(tmp.charAt(a));
                a = i;
            }
        }
        return res.toString();
    }


    // if use String instead of StringBuffer
    // Runtime: 31 ms, faster than 7.65% of Java online submissions for Count and Say.
    //Memory Usage: 40.1 MB, less than 13.16% of Java online submissions for Count and Say.

/*
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String res = "";
        String tmp = countAndSay(n - 1);
        int length = tmp.length();
        int a = 0;
        for (int i = 1; i < length + 1; i++) {
            if (i == length) {
                return res + (i - a) + tmp.charAt(a);
            } else if (tmp.charAt(i) != tmp.charAt(a) ) {
                res = res + (i - a) + tmp.charAt(a);
                a = i;
            }
        }
        return res.toString();
    }*/


    /*
    The method starts with the base case where n = 1, and the initial string is "1". It then iterates from 2 to n to generate the subsequent count-and-say sequences.

Within the loop, a StringBuilder sb is used to construct the next sequence. It iterates through the characters of the current sequence and counts the consecutive occurrences of each character. It appends the count and the character to sb.

The resulting sb is converted to a string and assigned back to the result variable. This process is repeated n times to generate the desired count-and-say sequence.

For example, if n = 5, the output will be "111221", which represents the fifth count-and-say sequence.

Note: The count-and-say sequence is a sequence of integers where each term is obtained by reading the previous term and counting the number of digits in groups of the same digit.


     */

    public static String countAndSay2(int n) {
        if (n <= 0)
            return "";

        String result = "1";
        int count = 1;

        while (count < n) {
            StringBuilder sb = new StringBuilder();
            int i = 0;

            while (i < result.length()) {
                char currentChar = result.charAt(i);
                int countChar = 1;

                while (i + 1 < result.length() && result.charAt(i) == result.charAt(i + 1)) {
                    countChar++;
                    i++;
                }

                sb.append(countChar);
                sb.append(currentChar);
                i++;
            }

            result = sb.toString();
            count++;
        }

        return result;
    }


    public static void main(String[] args) {
//        int testData = 5;
        int testData = 7;
        String result = countAndSay2(testData);
        System.out.printf( "Number %d CountandSay is : %s ", testData, result);
    }

}
