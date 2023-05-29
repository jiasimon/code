package com.sjia.Leetcode;

public class AddBinary {

    // #67. Add Binary  https://leetcode.com/problems/add-binary/    #fb
    // a = "1010", b = "1011" , Output: "10101"
    // 1 <= a.length, b.length <= 10^4
    // FB interview


    // Runtime: 2 ms, faster than 86.61% of Java online submissions for Add Binary.
    //Memory Usage: 40.1 MB, less than 6.37% of Java online submissions for Add Binary.

    // Runtime: 1 ms, faster than 100.00% of Java online submissions for Add Binary.
    //Memory Usage: 37.8 MB, less than 69.28% of Java online submissions for Add Binary.
    static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        for (int i=a.length()-1, j=b.length()-1; i>=0 || j>=0 ; i--, j--) {
            int sum = carry;
            if (i>=0) {
                sum += a.charAt(i) - '0';
            }
            if (j>=0) {
                sum += b.charAt(j) - '0';
            }
            result.append(sum % 2);
            carry = sum/2;
        }
        if (carry==1) result.append("1");
        return result.reverse().toString();

    }


    // java.lang.NumberFormatException: For input string:
/*
    static String addBinary(String a, String b) {
//        int a1 = Integer.parseInt(a, 2);
//        int b1 = Integer.parseInt(b,2);
//        return  Integer.toBinaryString(a1+b1);
        long a1 = Long.parseLong(a, 2);
        long b1 = Long.parseLong(b, 2);
        return Long.toBinaryString(a1+b1);

    }*/


    // Runtime: 3 ms, faster than 25.88% of Java online submissions for Add Binary.
    //Memory Usage: 39.2 MB, less than 16.78% of Java online submissions for Add Binary.
    public static String addBinary2(String a, String b) {
        int i= a.length()-1, j= b.length()-1, carry =0;
        StringBuilder sb = new StringBuilder();
        while (i>=0 || j>=0 || carry !=0) {
            int x,y;
            if (i>=0) x= a.charAt(i) - '0';
            else x = 0;
            if ( j >=0) y = b.charAt(j) - '0';
            else y = 0;
            int tmp = x+y+carry;
            sb.append(tmp % 2);
            carry = tmp / 2;
            i--;
            j--;
        }
        return sb.reverse().toString();

    }


    // sb.insert(0, sum % 2)
    public static String addBinary3(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }

            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }

            sb.insert(0, sum % 2);
            carry = sum / 2;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String testData = "11";
        String testData2 = "1";
        String result = addBinary3(testData,testData2);
        System.out.printf( "Binary %s plus %s  is : %s ", testData,testData2, result);

        System.out.println();
        String c = "1010";
        String d = "1011";
        String result2 = addBinary3(c, d);
        System.out.println("Binary Sum: " + result2); // Output: "10101"
    }

}
