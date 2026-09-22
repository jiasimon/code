package com.sjia.hackerRank2026;

import java.util.Scanner;

public class BiggerIsGreater {
    // https://www.hackerrank.com/challenges/bigger-is-greater/problem?isFullScreen=true

    public static String biggerIsGreater(String w) {
        char[] array = w.toCharArray();
        int n = array.length;

        // Step 1: Find the longest non-increasing suffix from the right
        int i = n - 2;
        while (i >= 0 && array[i] >= array[i + 1]) {
            i--;
        }

        // If no such element is found, it's already the largest permutation
        if (i < 0) {
            return "no answer";
        }

        // Step 2: Find the rightmost character in the suffix greater than array[i]
        int j = n - 1;
        while (array[j] <= array[i]) {
            j--;
        }

        // Step 3: Swap characters at index i and j
        swap(array, i, j);

        // Step 4: Reverse the suffix to make it the smallest possible combination
        reverse(array, i + 1, n - 1);

        return new String(array);
    }

    private static void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void reverse(char[] array, int start, int end) {
        while (start < end) {
            swap(array, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int t = scanner.nextInt();
            for (int i = 0; i < t; i++) {
                String w = scanner.next();
                System.out.println(biggerIsGreater(w));
            }
        }
        scanner.close();
    }


}
