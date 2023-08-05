package com.sjia.Leetcode;

public class IntegertoEnglishWords {
    // #273. Integer to English Words https://leetcode.com/problems/integer-to-english-words/  #fb

    /*
    Convert a non-negative integer num to its English words representation.
     */

    // 0 <= num <= 2^31 - 1



    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};


    // < 20, < 100, TENS, THOUSANDS
    // 13 ms, 18.87%, 41.4 MB, 45.50%
    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        int i = 0;
        String words = "";

        while (num > 0) {
            if (num % 1000 != 0)
                words = helper(num % 1000) + THOUSANDS[i] + " " + words;
            num /= 1000;
            i++;
        }

        return words.trim();
    }

    private String helper(int num) {
        if (num == 0)
            return "";
        else if (num < 20)
            return LESS_THAN_20[num] + " ";
        else if (num < 100)
            return TENS[num / 10] + " " + helper(num % 10);
        else
            return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
    }





    // 10ms, 41.35%; 41.28mb, 61.39%
    public String numberToWords2(int num) {
        if (num == 0) return "Zero";

        String words = "";
        if ( num >= 1000000000) {
            int p1 = num/1000000000 ;
            num = num % 1000000000 ;
            words += helper(p1) + "Billion ";
        }

        if (num >= 1000000) {
            int p2 = num/1000000 ;
            num = num % 1000000 ;
            words += helper(p2) + "Million ";
        }

        if (num >= 1000) {
            int p3 = num/1000 ;
            num = num % 1000 ;
            words += helper(p3) + "Thousand ";
        }

        words += helper(num);

//        return words;
        return words.trim();

    }

    public static void main(String[] args) {
        IntegertoEnglishWords solution = new IntegertoEnglishWords();

        int num = 1234567;
        String result = solution.numberToWords2(num);
        System.out.println("The English representation of " + num + " is: " + result);
        // Output: The English representation of 1234567 is: One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven

        int num2 = 1234567892;
        String result2 = solution.numberToWords2(num2);
        System.out.println("The English representation of " + num + " is: " + result2);
        // One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety Two
    }


}
