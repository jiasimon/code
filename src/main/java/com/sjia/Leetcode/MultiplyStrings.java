package com.sjia.Leetcode;

public class MultiplyStrings {
    // 43. Multiply Strings https://leetcode.com/problems/multiply-strings/



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
/*        for (int i=0; i < res.length; i++) {
            if ( i==0 && res[i]==0 ) continue;
            sb.append(res[i]);
        }
        return sb.toString(); */

        for(int p : res) if(!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();

    }


    public String multiplyStrings(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        int[] result = new int[n1 + n2];

        // Perform digit-by-digit multiplication
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = product + result[i + j + 1];

                result[i + j] += sum / 10;
                result[i + j + 1] = sum % 10;
            }
        }

        // Construct the final result string
        StringBuilder sb = new StringBuilder();
        for (int digit : result) {
            if (!(sb.length() == 0 && digit == 0)) {
                sb.append(digit);
            }
        }

        // Handle the case of zero multiplication
        if (sb.length() == 0) {
            return "0";
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        MultiplyStrings solution = new MultiplyStrings();
        String num1 = "123";
        String num2 = "456";
        String result = solution.multiply(num1, num2);
        System.out.println(result);
    }


}
