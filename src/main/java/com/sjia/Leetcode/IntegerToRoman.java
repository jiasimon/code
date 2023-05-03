package com.sjia.Leetcode;

public class IntegerToRoman {

    // #12  Integer to Roman
    // https://leetcode.com/problems/integer-to-roman/
    //Symbol       Value
    //I             1
    //V             5
    //X             10
    //L             50
    //C             100
    //D             500
    //M             1000
    //V             5000

    // code thousand , hundred...
    // Runtime: 21 ms, faster than 8.22% of Java online submissions for Integer to Roman.
    // Memory Usage: 43.9 MB, less than 5.01% of Java online submissions for Integer to Roman.

/*    static String intToRoman(int num)
    {
        // storing roman values of digits from 0-9 in different position

        String m[] = {"", "M", "MM", "MMM"};
        String c[] = {"", "C", "CC", "CCC", "CD", "D",
                "DC", "DCC", "DCCC", "CM"};
        String x[] = {"", "X", "XX", "XXX", "XL", "L",
                "LX", "LXX", "LXXX", "XC"};
        String i[] = {"", "I", "II", "III", "IV", "V",
                "VI", "VII", "VIII", "IX"};

        String thousand = m[num/1000];
        String hundered = c[(num%1000)/100];
        String ten = x[(num%100)/10];
        String one = i[num%10];

        String result = thousand + hundered + ten + one;

        return result;
    }*/


    // greedy
    // Runtime: 4 ms, faster than 88.28% of Java online submissions for Integer to Roman.
    //Memory Usage: 38.2 MB, less than 6.38% of Java online submissions for Integer to Roman.
    public static String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length && num >= 0; i++) {
            // Repeat while the current symbol still fits into num.
            while (values[i] <= num) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }



    public static String intToRomanGreedy(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder sb = new StringBuilder();
        for (int i=0; i < values.length && num >=0; i++) {
            while (values[i] <= num) {
                num = num - values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();

    }




    public static void main(String[] args) {

        //1994  MCMXCIV
        //2020  MMXXX
        //135

        int testData  = 135;
        String result = intToRoman(testData);

        System.out.printf(" %d ToRoman is %s \n", testData, result);

    }

}
