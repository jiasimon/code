package com.sjia.hackerRank2026;

public class BeautifulDays {
    // https://www.hackerrank.com/challenges/beautiful-days-at-the-movies

    public static int beautifulDays(int i, int j, int k) {
        int count = 0;
        for (int day = i; day <= j; day++) {
            if (Math.abs(day - reverseNumber(day)) % k == 0) {
                count++;
            }
        }
        return count;
    }

    private static int reverseNumber(int num) {
        int reversed = 0;
        while (num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }
        return reversed;
    }

}
