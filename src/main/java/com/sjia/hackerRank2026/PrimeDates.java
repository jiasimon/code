package com.sjia.hackerRank2026;

public class PrimeDates {
    // https://www.hackerrank.com/challenges/one-month-preparation-kit-prime-date

    public static int storeMonth[] = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    /**
     * Updates month/year arrays for leap years.
     */
    public static void updateLeapYear(int year) {
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            storeMonth[2] = 29;
        } else {
            storeMonth[2] = 28;
        }
    }

    /**
     * Counts prime dates between d1-m1-y1 and d2-m2-y2 inclusive.
     */
    public static int findPrimeDates(int d1, int m1, int y1, int d2, int m2, int y2) {
        int result = 0;

        while (true) {
            updateLeapYear(y1);

            // Construct DDMMYYYY integer
            int x = d1;
            x = x * 100 + m1;
            x = x * 10000 + y1;

            // Check if prime date (divisible by 4 or 7)
            if (x % 4 == 0 || x % 7 == 0) {
                result++;
            }

            // Exit condition when target date is reached
            if (d1 == d2 && m1 == m2 && y1 == y2) {
                break;
            }

            // Increment date
            d1++;
            if (d1 > storeMonth[m1]) {
                m1++;
                d1 = 1;
                if (m1 > 12) {
                    y1++;
                    m1 = 1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Example: From 02-08-2025 to 04-09-2025
        int d1 = 2, m1 = 8, y1 = 2025;
        int d2 = 4, m2 = 9, y2 = 2025;

        int count = findPrimeDates(d1, m1, y1, d2, m2, y2);
        System.out.println("Number of prime dates: " + count);
    }

}
