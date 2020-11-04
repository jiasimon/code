package com.sjia.Leetcode;

public class MultiplyStrings {
    // #43 https://leetcode.com/problems/multiply-strings/



    // Runtime: 3 ms, faster than 90.02% of Java online submissions for Multiply Strings.
    //Memory Usage: 38.9 MB, less than 31.75% of Java online submissions for Multiply Strings.
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int a = num1.length(), b = num2.length();
        int[] res = new int[a+b];

        for (int i = a-1; i>=0; i--){
            for (int j= b-1; j>=0; j--) {
                int tmp = (num1.charAt(i) - '0') * (num2.charAt(j)- '0');
                int p1= i+j, p2 = i + j + 1;

                int sum = tmp + res[p2];
                res[p1] += sum / 10 ;
                res[p2] = sum % 10;
            }

        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < res.length; i++) {
            if ( i==0 && res[i]==0 ) continue;
            sb.append(res[i]);
        }
        return sb.toString();

    }


}
