package com.sjia.hackerRank2026;

import java.util.Scanner;

public class ModifiedKaprekarNumbers {
    // https://www.hackerrank.com/challenges/kaprekar-numbers/problem?isFullScreen=true

    public static void kaprekarNumbers(int p, int q) {
        boolean found = false;

        for (long i = p; i <= q; i++) {
            if (isKaprekar(i)) {
                System.out.print(i + " ");
                found = true;
            }
        }

        if (!found) {
            System.out.print("INVALID RANGE");
        }
    }

    private static boolean isKaprekar(long n) {
        // Step 1: Calculate the square of the number
        long square = n * n;

        // Step 2: Convert both original number and square to strings
        String nStr = String.valueOf(n);
        String sqStr = String.valueOf(square);

        // Step 3: Determine the split point
        // The right piece must have exactly 'd' digits (the same length as n)
        int splitIndex = sqStr.length() - nStr.length();

        // Step 4: Extract the left and right pieces
        String leftStr = sqStr.substring(0, splitIndex);
        String rightStr = sqStr.substring(splitIndex);

        // Convert pieces to long (if left is empty, its value is 0)
        long left = leftStr.isEmpty() ? 0 : Long.parseLong(leftStr);
        long right = rightStr.isEmpty() ? 0 : Long.parseLong(rightStr);

        // Step 5: Check if the sum of the pieces equals the original number
        return (left + right) == n;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            kaprekarNumbers(p, q);
        }
        scanner.close();
    }

}
