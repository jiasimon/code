package com.sjia.Leetcode;

public class CountSay {

    //#38 https://leetcode.com/problems/count-and-say/  google interview question in 2005

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


    public static void main(String[] args) {
        int testData = 5;
        String result = countAndSay(testData);
        System.out.printf( "Number %d CountandSay is : %s ", testData, result);
    }

}
